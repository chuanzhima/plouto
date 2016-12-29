package com.smk.pay.core.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountFundFlowEnum;
import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.request.RequestHeader;
import com.smk.pay.account.core.response.RpcResponse;
import com.smk.pay.account.core.service.IAccountValidatorService;
import com.smk.pay.core.annotations.DubboService;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.meta.ServiceResultCode;
import com.smk.pay.core.utils.StringUtil;
import com.smk.pay.core.validator.ConsumeValiator;
import com.smk.pay.core.validator.RechargeValidator;
import com.smk.pay.core.validator.WithdrawValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 账户校验服务
 * <p/>
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/26 17:18
 */
@Service(version = "1.0.0")
public class AccountValidatorService implements IAccountValidatorService {

    @Autowired
    private RechargeValidator rechargeValidator;
    @Autowired
    private ConsumeValiator consumeValiator;
    @Autowired
    private WithdrawValidator withdrawValidator;

    @DubboService
    @Override
    public RpcResponse<String> validate4Recharge(RequestHeader header, AccountTypeEnum typeEnum, AccountChannelEnum channelEnum,
                                                 String typeVal,
                                                 AccountFundFlowEnum fundFlowEnum, BigDecimal amount) {

        if (StringUtil.isNull(header, typeEnum, amount, fundFlowEnum) || amount.compareTo(new BigDecimal
                (0)) < 0 || StringUtil.isEmpty(header.getReqSeq(), header.getTxDate(), header.getTxTime(), typeVal)) {
            return new RpcResponse<>(Boolean.FALSE, ResultCodeConstant
                    .PARAMETER_INVALID, ServiceResultCode.RESULT_CODE_MAPPING.get(ResultCodeConstant
                    .PARAMETER_INVALID));
        }
        Map<Boolean, String> validateMap = rechargeValidator.validate(header, channelEnum, fundFlowEnum, typeEnum,
                typeVal, amount);
        if (validateMap.containsKey(Boolean.FALSE))
            return new RpcResponse<>(Boolean.FALSE, validateMap.get(Boolean.FALSE), ServiceResultCode
                    .RESULT_CODE_MAPPING.get(validateMap.get(Boolean.FALSE)));
        return new RpcResponse<>(Boolean.TRUE);
    }

    @DubboService
    @Override
    public RpcResponse<String> validate4Consume(RequestHeader header, AccountTypeEnum typeEnum, String typeValue,
                                                BigDecimal amount) {

        if (StringUtil.isNull(header, typeEnum, amount) ||
                StringUtil.isEmpty(header.getReqSeq(), header.getTxDate(), header.getTxTime(), typeValue)) {
            return new RpcResponse<>(Boolean.FALSE, ResultCodeConstant
                    .PARAMETER_INVALID, ServiceResultCode.RESULT_CODE_MAPPING.get(ResultCodeConstant
                    .PARAMETER_INVALID));
        }
        Map<Boolean, String> validateMap = consumeValiator.validate(header, typeEnum, typeValue, amount);
        if (validateMap.containsKey(Boolean.FALSE))
            return new RpcResponse<>(Boolean.FALSE, validateMap.get(Boolean.FALSE), ServiceResultCode
                    .RESULT_CODE_MAPPING.get(validateMap.get(Boolean.FALSE)));
        return new RpcResponse<>(Boolean.TRUE);
    }

    @DubboService
    @Override
    public RpcResponse<String> validate4Withdraw(RequestHeader header, AccountTypeEnum typeEnum, String typeValue,
                                                 BigDecimal amount) {

        if (StringUtil.isNull(header, typeEnum, amount)
                || amount.compareTo(new BigDecimal(0)) < 0 ||
                StringUtil.isEmpty(header.getReqSeq(), header.getTxDate(), header.getTxTime(), typeValue)) {
            return new RpcResponse<>(Boolean.FALSE, ResultCodeConstant
                    .PARAMETER_INVALID, ServiceResultCode.RESULT_CODE_MAPPING.get(ResultCodeConstant
                    .PARAMETER_INVALID));
        }
        Map<Boolean, String> validateMap = withdrawValidator.validate(header, typeEnum, typeValue, amount);
        if (validateMap.containsKey(Boolean.FALSE))
            return new RpcResponse<>(Boolean.FALSE, validateMap.get(Boolean.FALSE), ServiceResultCode
                    .RESULT_CODE_MAPPING.get(validateMap.get(Boolean.FALSE)));
        return new RpcResponse<>(Boolean.TRUE);
    }
}
