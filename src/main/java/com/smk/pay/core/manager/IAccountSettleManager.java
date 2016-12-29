package com.smk.pay.core.manager;

import com.smk.pay.account.core.enums.AccountBizEnum;
import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountFundFlowEnum;
import com.smk.pay.account.core.request.RequestHeader;

import java.math.BigDecimal;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/19 20:56
 */
public interface IAccountSettleManager {

    void settle4Merchant(RequestHeader header, AccountChannelEnum channelEnum, String merchantId,
                         AccountFundFlowEnum fundFlowEnum, BigDecimal amount, String bankId,
                         AccountBizEnum bizEnum);

    void agentPay(RequestHeader header, AccountChannelEnum channelEnum, String merchantId,
                  AccountFundFlowEnum fundFlowEnum, BigDecimal amount, String bankId,
                  AccountBizEnum bizEnum);
}
