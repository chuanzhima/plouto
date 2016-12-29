package com.smk.pay.core.manager;

import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.request.OpenAccountCreditRequest;
import com.smk.pay.account.core.request.RequestHeader;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/22 10:37
 */
public interface IAccountCreditMngManager {

    void openCredit(RequestHeader header, AccountChannelEnum channelEnum,
                    OpenAccountCreditRequest request);
}
