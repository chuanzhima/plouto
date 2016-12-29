package com.smk.pay.core.validator;

import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountFundFlowEnum;
import com.smk.pay.account.core.enums.AccountInfoStatusEnum;
import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.request.RequestHeader;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.dto.AccountInfoDto;
import com.smk.pay.core.enums.AccountTransTypeEnum;
import com.smk.pay.core.manager.atom.IRecharge;
import com.smk.pay.core.utils.StringUtil;
import com.smk.pay.core.validator.base.AccountValidator;
import com.smk.pay.core.validator.base.PrepaidCardValidator;
import com.smk.pay.core.validator.base.TransValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 充值校验器
 * <p/>
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/11 11:21
 */
@Component(value = "rechargeValidator")
public class RechargeValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RechargeValidator.class);
    @Autowired
    private AccountValidator accountValidator;
    @Autowired
    private TransValidator transValidator;
    @Autowired
    private PrepaidCardValidator prepaidCardValidator;

    // 个人充值校验
    public Map<Boolean, String> validate(RequestHeader header, AccountChannelEnum channelEnum, AccountFundFlowEnum
            fundFlowEnum, AccountTypeEnum type, String typeValue, BigDecimal amount) {

        Map<Boolean, String> validateMap = new HashMap<Boolean, String>() {{
            put(Boolean.TRUE, ResultCodeConstant.SUCCESS);
        }};
        // 校验重复交易
        Boolean isRepeat = transValidator.isRepeatTrans(header.getReqSeq(), header.getTxDate
                (), header.getTxTime(), AccountTransTypeEnum.RECHARGE.key(), AccountInfoStatusEnum
                .NORMAL.value());
        if (isRepeat) {
            LOGGER.warn("validate result: sequence-no repeat,no=" + header.getReqSeq());
            return new HashMap<Boolean, String>() {{
                put(Boolean.FALSE, ResultCodeConstant.REPEAT_TRANS_SEQUENCE_NO);
            }};
        }
        String accoutCls = "1";
        String accountId = StringUtil.EMPTY;
        if (IRecharge.SOURCE_TYPE_USER_ID.equals(type.value())) {
            // 校验账户合法性
            Map<Boolean, List<String>> accountMap = accountValidator.isValidAccount(typeValue,
                    null, Arrays.asList(AccountInfoStatusEnum.NORMAL.value()));
            if (accountMap.containsKey(Boolean.FALSE)) {
                final String resultVal = accountMap.get(Boolean.FALSE).get(0);
                return new HashMap<Boolean, String>() {{
                    put(Boolean.FALSE, resultVal);
                }};
            }
            accoutCls = accountMap.get(Boolean.TRUE).get(2);
            accountId = accountMap.get(Boolean.TRUE).get(0);
            validateMap.put(Boolean.TRUE, accountId);
        } else if (IRecharge.SOURCE_TYPE_CARD.equals(type.value())) {

            AccountInfoDto accountInfoDto = prepaidCardValidator.isValidCard(typeValue);
            if (accountInfoDto == null) {
                return new HashMap<Boolean, String>() {{
                    put(Boolean.FALSE, ResultCodeConstant.ACCOUNT_NOT_EXIST);
                }};
            }
            if (!AccountInfoStatusEnum.NORMAL.value().equals(accountInfoDto.getStatus()))
                return new HashMap<Boolean, String>() {{
                    put(Boolean.FALSE, ResultCodeConstant.ACCOUNT_STATUS_INVALID);
                }};
            if (fundFlowEnum == AccountFundFlowEnum.GGK) {
                boolean isForbidden = prepaidCardValidator.isForbiddenCard(typeValue);
                if (isForbidden)
                    return new HashMap<Boolean, String>() {{
                        put(Boolean.FALSE, ResultCodeConstant.GGK_RECHARGE_FORBIDDEN);
                    }};
            }
            accoutCls = accountInfoDto.getAccountClass();
            accountId = accountInfoDto.getAccountId().toString();
            validateMap.put(Boolean.TRUE, accountId);
        } else if (IRecharge.SOURCE_TYPE_IDENTITY_ID.equals(type)) {
            // TODO 用身份证号对卡充值
        } else {
            return new HashMap<Boolean, String>() {{
                put(Boolean.FALSE, ResultCodeConstant.INVALID_RECHARGE_TYPE);
            }};
        }
        // 单日，单笔，累计限额
        final String limitResult = transValidator.transLimits(accoutCls, accountId, AccountTransTypeEnum.RECHARGE.key(),
                amount);
        if (!StringUtil.isEmpty(limitResult))
            return new HashMap<Boolean, String>() {{
                put(Boolean.FALSE, limitResult);
            }};
        return validateMap;
    }

    // 商户充值校验
    public Map<Boolean, String> validate4Merchant(RequestHeader header, String merchantId) {

        Map<Boolean, String> validateMap = new HashMap<Boolean, String>() {{
            put(Boolean.TRUE, ResultCodeConstant.SUCCESS);
        }};

        // 校验重复交易
        Boolean isRepeat = transValidator.isRepeatTrans(header.getReqSeq(), header.getTxDate
                (), header.getTxTime(), AccountTransTypeEnum.RECHARGE.key(), AccountInfoStatusEnum
                .NORMAL.value());
        if (isRepeat) {
            LOGGER.warn("validate4Merchant result: sequence-no repeat,no=" + header.getReqSeq());
            return new HashMap<Boolean, String>() {{
                put(Boolean.FALSE, ResultCodeConstant.REPEAT_TRANS_SEQUENCE_NO);
            }};
        }
        Map<Boolean, List<String>> accountMap = accountValidator.isValidMerchantAccount(merchantId,
                null, Arrays.asList(AccountInfoStatusEnum.NORMAL.value()));

        if (accountMap.containsKey(Boolean.FALSE)) {
            final String resultVal = accountMap.get(Boolean.FALSE).get(0);
            return new HashMap<Boolean, String>() {{
                put(Boolean.FALSE, resultVal);
            }};
        }
        validateMap.put(Boolean.TRUE, accountMap.get(Boolean.TRUE).get(0));
        return validateMap;
    }

    private Map<Boolean, String> transLimit(String accountLevel, String accountId) {

        Map<Boolean, String> limitMap = new HashMap<>();


        return limitMap;
    }
}
