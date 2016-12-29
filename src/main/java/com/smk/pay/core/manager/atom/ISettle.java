package com.smk.pay.core.manager.atom;

import com.smk.pay.account.core.enums.AccountBizEnum;
import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.request.RequestHeader;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/19 20:38
 */
public interface ISettle {

    void settle(String sequence, String accountId, BigDecimal amount, String bankId,
                String merchantId, String accDate, RequestHeader header, Date transDate,
                AccountChannelEnum channelEnum, AccountBizEnum bizEnum);
}
