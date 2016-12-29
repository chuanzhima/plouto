package com.smk.pay.core.factory;

import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.enums.AccountTransTypeEnum;
import com.smk.pay.core.exception.ServiceException;
import com.smk.pay.core.manager.atom.IReverse;
import com.smk.pay.core.manager.atom.impl.Reverse4Withdraw;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/20 16:43
 */
@Component("reverseFactory")
public class ReverseFactory implements InitializingBean, ApplicationContextAware {

    private static ConcurrentHashMap<AccountTransTypeEnum, IReverse> REVERSE_MAP =
            new ConcurrentHashMap<>();

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public IReverse getReverseBean(AccountTransTypeEnum transTypeEnum) {
        IReverse reverse = REVERSE_MAP.get(transTypeEnum);
        if (null == reverse)
            throw new ServiceException(ResultCodeConstant.TRANS_TYPE_INCORRECT);

        return reverse;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        REVERSE_MAP.put(AccountTransTypeEnum.WITHDRAW, context.getBean(Reverse4Withdraw.class));
    }
}
