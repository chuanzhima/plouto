package com.smk.pay.core.manager;

import com.smk.pay.account.core.enums.AccountBizEnum;
import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.request.RequestHeader;

import java.math.BigDecimal;
import java.util.Map;

/**
 * ACCOUNT_DIRECTION_PAYMENT_COM
 * <p/>
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/30 11:19
 */
public interface IAccountConsumeManager {

    void consume(RequestHeader header, AccountChannelEnum channelEnum, AccountBizEnum bizEnum, String merchantId,
                 AccountTypeEnum typeEnum, String typeValue, BigDecimal amount, BigDecimal cost,
                 Map<String, Object> extraParam);
}
