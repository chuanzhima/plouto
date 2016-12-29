package com.smk.pay.core.manager;

import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.response.AccountCreditDetailResp;
import com.smk.pay.account.core.response.AccountCreditInfo;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/22 10:38
 */
@Service("accountCreditQueryManager")
public interface IAccountCreditQueryManager {

    AccountCreditInfo queryAccountCreditInfo(AccountTypeEnum typeEnum, String value);

    AccountCreditDetailResp queryAccountCreditDetail(Date transFromDate, Date transToDate, String cardNumber, String
            idNo, String type, int pageNum, int pageSize);


//    int queryAccountCreditDetailCount(Date transFromDate, Date transToDate, String cardNumber, String idNo, String
//            type);
}
