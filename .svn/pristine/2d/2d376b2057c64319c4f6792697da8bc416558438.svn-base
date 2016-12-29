package com.smk.pay.core.manager.atom;

import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.request.RequestHeader;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/16 15:53
 */
public interface IWithdraw {

    void withdraw(String sequence, String accountId, BigDecimal amount, String bankId, String merchantId, String accDate,
                  RequestHeader header, Date transDate, AccountChannelEnum channelEnum);
}
