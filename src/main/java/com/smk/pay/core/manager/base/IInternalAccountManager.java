package com.smk.pay.core.manager.base;

import com.smk.pay.core.dto.InternalAccountDto;

import java.math.BigDecimal;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/11 14:54
 */
public interface IInternalAccountManager {

    InternalAccountDto queryByAccountTypeIdBankId(String accountTypeId, String bankId);

    int updateAmountByTypeIdAndBankId(BigDecimal amount, String accountTypeId, String bankId);
}
