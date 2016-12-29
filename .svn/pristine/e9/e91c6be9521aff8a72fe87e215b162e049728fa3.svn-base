package com.smk.pay.core.api;

import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.response.AccountCreditDetailResp;
import com.smk.pay.account.core.response.AccountCreditInfo;
import com.smk.pay.account.core.response.RpcResponse;
import com.smk.pay.account.core.service.IAccountCreditQueryService;
import com.smk.pay.core.base.BaseServiceTest;
import com.smk.pay.core.utils.DateUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * AccountCreditQueryService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12/22/2016</pre>
 */
public class AccountCreditQueryServiceTest extends BaseServiceTest {

    @Autowired
    private IAccountCreditQueryService accountCreditQueryService;

    @Test
    public void testQueryAccountCreditInfo() {

        String custId = "100002885";
        RpcResponse<AccountCreditInfo> response = accountCreditQueryService.queryAccountCreditInfo(AccountTypeEnum
                .ONLINE, custId);
        Assert.assertNotNull(response);
    }

    @Test
    public void testQueryAccountCreditDetail() {

        Date fromDate = DateUtil.addMonth(new Date(), -200);
        Date toDate = new Date();
        String cardNumber = "A29639425";
        String idNo = "";
        String type = "";
        int pageNum = 1;
        int pageSize = 20;

        RpcResponse<AccountCreditDetailResp> rpcResponse =
                accountCreditQueryService.queryAccountCreditDetail(fromDate, toDate, cardNumber, idNo, type, pageNum, pageSize);

        Assert.assertNotNull(rpcResponse);
    }


}
