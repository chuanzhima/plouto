package com.smk.pay.core.manager.atom;

import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.request.RequestHeader;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/15 10:41
 */
public interface IConsume {

    void consume(String sequence, String accDate, Date transDate, RequestHeader header,
                 AccountChannelEnum channelEnum, String merchantId, String accountId,
                 BigDecimal amount, BigDecimal cost, Map<String, Object> extraParam);
}
