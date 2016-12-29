package com.smk.pay.core.manager;

import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountFundFlowEnum;
import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.request.RequestHeader;

import java.math.BigDecimal;

/**
 * ACCOUNT_RECHARGE_COM
 * <p/>
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/29 10:08
 */
public interface IAccountRechargeManager {

    void recharge(RequestHeader header, AccountChannelEnum channelEnum,
                  String merchantId, AccountTypeEnum type, String typeValue,
                  AccountFundFlowEnum fundFlowEnum, BigDecimal amount,
                  String bankId, String companyId);

    void recharge4Merchant(RequestHeader header, AccountChannelEnum channelEnum, String merchantId, AccountFundFlowEnum fundFlowEnum, BigDecimal amount, String bankId);
}
