package com.smk.pay.core.api;

import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.request.OpenAccountCreditRequest;
import com.smk.pay.account.core.request.RequestHeader;
import com.smk.pay.account.core.response.RpcResponse;
import com.smk.pay.account.core.service.IAccountCreditMngService;
import com.smk.pay.core.base.BaseServiceTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * AccountCreditMngService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12/23/2016</pre>
 */
public class AccountCreditMngServiceTest extends BaseServiceTest {
    @Autowired
    private IAccountCreditMngService accountCreditMngService;

    @Test
    public void testOpenAccountCredit() {

        RequestHeader header = new RequestHeader("20161223", "1103", "2016122311031235");
        OpenAccountCreditRequest request = new OpenAccountCreditRequest("苏梅容1", "100001920", "1", "33041919810121084",
                "15858287030", new BigDecimal(9527));

        RpcResponse<String> rpcResponse = accountCreditMngService.openAccountCredit(header, AccountChannelEnum
                .INTERNET, request);

        Assert.assertNotNull(rpcResponse);
    }



}
