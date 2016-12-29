package com.smk.pay.core.manager;

import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountLevelEnum;
import com.smk.pay.account.core.request.MigrateAccountRequest;
import com.smk.pay.account.core.request.OpenAccountRequest;
import com.smk.pay.account.core.request.RequestHeader;

import java.util.Map;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/23 19:26
 */
public interface IAccountMngManager {

    /**
     * open account
     *
     * @param openAccountRequest
     * @return
     */
    Map<Boolean, String> openAccount(OpenAccountRequest openAccountRequest);

    /**
     * alter account level
     *
     * @param custId
     * @param levelEnum
     * @return
     */
    String alterAccountLevel(String custId, AccountLevelEnum levelEnum);


    /**
     * migrate account
     *
     * @param header
     * @param channelEnum
     * @param merchantId
     * @param accountRequest
     */
    void migrateAccount(RequestHeader header, AccountChannelEnum channelEnum, String merchantId,
                        MigrateAccountRequest accountRequest);

    /**
     * bind account
     *
     * @param header
     * @param userId
     * @param cardNo
     * @param merchantId
     * @param channelEnum
     */
    void bindAccount(RequestHeader header, String userId, String cardNo, String merchantId,
                     AccountChannelEnum channelEnum);
}
