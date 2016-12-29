package com.smk.pay.core.manager.atom;

import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.request.RequestHeader;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/8 14:46
 */
public interface IRecharge {

    String SOURCE_TYPE_CARD = "1";
    String SOURCE_TYPE_USER_ID = "2";
    String SOURCE_TYPE_IDENTITY_ID = "0";

    void recharge(String sequence, String accountId, BigDecimal amount, String bankId,
                  String merchantId, String accDate, RequestHeader header, Date transDate,
                  AccountChannelEnum channelEnum);
}
