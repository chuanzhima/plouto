package com.smk.pay.core.manager;

import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountFundFlowEnum;
import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.request.RequestHeader;

import java.math.BigDecimal;

/**
 * WITHDRAW_DEPOSIT_PUB
 * <p/>
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/1 16:44
 */
public interface IAccountWithdrawManager {

    void withdraw(RequestHeader header, AccountChannelEnum channelEnum, String merchantId,
                  AccountTypeEnum typeEnum, String typeValue, AccountFundFlowEnum fundFlowEnum,
                  BigDecimal amount, String bankId);
}
