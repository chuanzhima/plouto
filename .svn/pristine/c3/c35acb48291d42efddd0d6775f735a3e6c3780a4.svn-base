package com.smk.pay.core.manager;

import com.smk.pay.account.core.enums.AccountBizEnum;
import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.response.AccountDetailResp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/23 19:26
 */
public interface IAccountQueryManager {

    /**
     * 查询账户可用余额
     *
     * @param value
     * @param typeEnum
     * @return
     */
    Map<String, BigDecimal> queryAvailableAmount(String value, AccountTypeEnum typeEnum);

    /**
     * 查询账户变更记录
     *
     * @param value
     * @param typeEnum
     * @param transType
     * @param channelEnum
     * @param merchantId
     * @param bizEnum
     * @param fromDate
     * @param toDate
     * @param pageNum
     * @param pageSize
     * @return
     */
    AccountDetailResp queryAccountDetail(String value, AccountTypeEnum typeEnum, String transType,
                                         AccountChannelEnum channelEnum, String merchantId,
                                         AccountBizEnum bizEnum, Date fromDate, Date toDate,
                                         int pageNum, int pageSize);


}
