package com.smk.pay.core.validator.base;

import com.smk.pay.account.core.enums.AccountInfoStatusEnum;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.dto.AccountInfoDto;
import com.smk.pay.core.dto.MerchantAccountInfoDto;
import com.smk.pay.core.manager.base.IAccountInfoManager;
import com.smk.pay.core.manager.base.IMerchantAccountInfoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/25 18:10
 */
@Component("accountValidator")
public class AccountValidator {

    private final static Logger LOGGER = LoggerFactory.getLogger(AccountValidator.class);
    @Autowired
    private IAccountInfoManager accountInfoManager;
    @Autowired
    private IMerchantAccountInfoManager merchantAccountInfoManager;

    public Map<Boolean, List<String>> isValidAccount(String userId, List<String>
            invalidStatus, List<String> validStatus) {

        AccountInfoDto accountInfoDto = accountInfoManager.queryMainAccountByUserId(userId);

        if (null == accountInfoDto) {
            LOGGER.warn("validAccount account not exist, userId=" + userId);
            return new HashMap<Boolean, List<String>>() {{
                put(Boolean.FALSE, Arrays.asList(ResultCodeConstant.ACCOUNT_NOT_EXIST));
            }};
        }
        return this.isValidStatus(accountInfoDto.getAccountId().toString(), accountInfoDto.getStatus(),
                accountInfoDto.getAccountClass(), invalidStatus, validStatus);
    }

    public Map<Boolean, List<String>> isValidAccountByCustId(String custId, List<String>
            invalidStatus, List<String> validStatus) {

        AccountInfoDto accountInfoDto = accountInfoManager.queryMainAccountByCustId(custId);

        if (null == accountInfoDto) {
            LOGGER.warn("validAccount account not exist, custId=" + custId);
            return new HashMap<Boolean, List<String>>() {{
                put(Boolean.FALSE, Arrays.asList(ResultCodeConstant.ACCOUNT_NOT_EXIST));
            }};
        }
        return this.isValidStatus(accountInfoDto.getAccountId().toString(), accountInfoDto.getStatus(),
                accountInfoDto.getAccountClass(), invalidStatus, validStatus);
    }

    public Map<Boolean, List<String>> isValidMerchantAccount(String merchantId, List<String>
            invalidStatus, List<String> validStatus) {
        MerchantAccountInfoDto merchantAccountInfoDto = merchantAccountInfoManager
                .queryAccountByMerchantId
                        (merchantId);
        if (null == merchantAccountInfoDto) {
            LOGGER.warn("validAccount account not exist, merchantId=" + merchantId);
            return new HashMap<Boolean, List<String>>() {{
                put(Boolean.FALSE, Arrays.asList(ResultCodeConstant.ACCOUNT_NOT_EXIST));
            }};
        }
        return this.isValidStatus(merchantAccountInfoDto.getMerAccountId(), merchantAccountInfoDto.getStatus(),
                null, invalidStatus, validStatus);
    }


    public Map<Boolean, List<String>> isValidStatus(final String accountId, final String status, final String level,
                                                    List<String>
                                                            invalidStatus,
                                                    List<String> validStatus) {

        if (!CollectionUtils.isEmpty(invalidStatus) && invalidStatus.contains(status)) {
            LOGGER.warn("isValidStatus account status invalid, accountId={},status={}", accountId, status);
            return new HashMap<Boolean, List<String>>() {{
                put(Boolean.FALSE, Arrays.asList(ResultCodeConstant.ACCOUNT_STATUS_PREFIX +
                        AccountInfoStatusEnum.valueOf(status).name()));
            }};
        }
        if (!CollectionUtils.isEmpty(validStatus) && !validStatus.contains(status)) {
            LOGGER.warn("isValidStatus account status invalid, accountId={},status={}", accountId, status);
            return new HashMap<Boolean, List<String>>() {{
                put(Boolean.FALSE, Arrays.asList(ResultCodeConstant.ACCOUNT_STATUS_INVALID));
            }};
        }
        return new HashMap<Boolean, List<String>>() {{
            put(Boolean.TRUE, Arrays.asList(accountId, status, level));
        }};
    }
}
