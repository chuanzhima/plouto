package com.smk.pay.core.api;

import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountFundFlowEnum;
import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.request.RequestHeader;
import com.smk.pay.account.core.response.RpcResponse;
import com.smk.pay.account.core.service.IAccountWithdrawService;
import com.smk.pay.core.base.BaseServiceTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * AccountWithdrawService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>11/29/2016</pre>
 */
public class AccountWithdrawServiceTest extends BaseServiceTest {
    @Autowired
    private IAccountWithdrawService accountWithdrawService;

    @org.junit.Test
    public void testWithdraw() {
        RequestHeader header = new RequestHeader("20161227", "105353", "201612271053531113");
        String merchantId = "PMPF000000";
        String userId = "100003509";
        BigDecimal amount = new BigDecimal(1000);
        String bankId = "0001";
        String cardNo = "A10036405";
        RpcResponse<String> response = accountWithdrawService.withdraw(header, AccountChannelEnum.INTERNET,
                merchantId, AccountTypeEnum.OFFLINE, cardNo, AccountFundFlowEnum.YHK, amount, bankId);
        org.junit.Assert.assertNotNull(response);
    }

}
