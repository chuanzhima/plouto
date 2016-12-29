package com.smk.pay.core.manager.base;

import com.smk.pay.core.dto.MerchantAccountInfoDto;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/21 18:25
 */
public interface IMerchantAccountInfoManager {

    int updateAccountAmount(String accountId, MerchantAccountInfoDto oldAmount, MerchantAccountInfoDto newAmount);

    MerchantAccountInfoDto queryAccountByMerchantId(String merchantId);

    MerchantAccountInfoDto queryAccountById(String accountId);
}
