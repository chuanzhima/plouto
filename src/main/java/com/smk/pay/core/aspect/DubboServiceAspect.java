package com.smk.pay.core.aspect;

import com.alibaba.fastjson.JSONObject;
import com.smk.pay.account.core.response.RpcResponse;
import com.smk.pay.core.annotations.DubboService;
import com.smk.pay.core.config.PloutoConfig;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.exception.DBException;
import com.smk.pay.core.exception.ServiceException;
import com.smk.pay.core.meta.ServiceResultCode;
import com.smk.pay.core.utils.StringUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;

/**
 * Dubbo 服务拦截
 * 1、日志
 * 2、执行时间
 * 3、异常封装
 *
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/24 11:07
 */
@Aspect
@Component
public class DubboServiceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(DubboService.class);
    private static final String ERROR_MAIL_SWITCH = "on";
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private PloutoConfig ploutoConfig;

    @Around("@annotation(com.smk.pay.core.annotations.DubboService)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
            String clsName = joinPoint.getTarget().getClass().getSimpleName();
            String methodName = joinPoint.getSignature().getName();
            String metaInfo = clsName + "->" + methodName;
            Object[] args = joinPoint.getArgs();
            long beginMills = System.currentTimeMillis();
            StringBuffer argsBuffer = new StringBuffer("params : ");
            if (null != args && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    String objName = args[i].getClass().getSimpleName();
                    argsBuffer.append(objName).append(" = ").append(toJsonStr(args[i])).append(",");
                }
            } else {
                argsBuffer.append("empty");
            }
            LOGGER.info(metaInfo + ", " + argsBuffer.toString());
            Object retVal;
            try {
                retVal = joinPoint.proceed();
            } catch (Throwable throwable) {

                if (throwable instanceof ServiceException) {
                    LOGGER.warn(metaInfo + " ServiceException! " + ServiceResultCode.RESULT_CODE_MAPPING.get(throwable.getMessage()));
                    return new RpcResponse<>(Boolean.FALSE, throwable.getMessage(),
                            ServiceResultCode.RESULT_CODE_MAPPING.get(throwable.getMessage()));
                }
                SimpleMailMessage message = null;
                Boolean isSend = Boolean.FALSE;
                if (ERROR_MAIL_SWITCH.equals(ploutoConfig.getErrorMailSwitch())) {
                    isSend = Boolean.TRUE;
                    message = new SimpleMailMessage();
                    message.setFrom(ploutoConfig.getErrorMailFrom());
                    message.setTo(ploutoConfig.getErrorMailTo().split(","));
                    message.setSubject(ploutoConfig.getErrorMailSubject());

                }

                if (throwable instanceof DBException) {
                    LOGGER.error(metaInfo + " DBException! ", throwable);
                    if (isSend) {
                        message.setText(metaInfo + " DBException! " + throwable.getMessage() + argsBuffer.toString
                                ());
                        try {
                            mailSender.send(message);
                        } catch (MailException e) {
                            LOGGER.warn("send mail exception!");
                        }
                    }
                    return new RpcResponse<>(Boolean.FALSE, ResultCodeConstant.SYSTEM_ERROR,
                            ServiceResultCode.RESULT_CODE_MAPPING.get(ResultCodeConstant.SYSTEM_ERROR));
                } else {
                    LOGGER.error(metaInfo + " Exception! ", throwable);
                    if (isSend) {
                        message.setText(metaInfo + " Exception! " + throwable.getMessage() + argsBuffer.toString
                                ());
                        try {
                            mailSender.send(message);
                        } catch (MailException e) {
                            LOGGER.warn("send mail exception!");
                        }
                    }
                    return new RpcResponse<>(Boolean.FALSE, ResultCodeConstant.SYSTEM_ERROR,
                            ServiceResultCode.RESULT_CODE_MAPPING.get(ResultCodeConstant.SYSTEM_ERROR));
                }

            }
            LOGGER.info(metaInfo + ", " + "result : " + toJsonStr(retVal));
            LOGGER.info(metaInfo + ", " + "cost : " + Float.valueOf((System.currentTimeMillis()
                    - beginMills)) / 1000 + " s");

            return retVal;
        } catch (Throwable throwable) {
            Object retVal = joinPoint.proceed();
            return retVal;
        }
    }

    private String toJsonStr(Object object) {
        if (object == null)
            return StringUtil.EMPTY;
        if (object instanceof Object || object instanceof Array)
            return JSONObject.toJSONString(object);
        else
            return object.toString();
    }

}
