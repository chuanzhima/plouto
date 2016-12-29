package com.smk.pay.core.api;

import com.smk.pay.account.core.enums.AccountBizEnum;
import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.request.RequestHeader;
import com.smk.pay.account.core.response.RpcResponse;
import com.smk.pay.account.core.service.IAccountConsumeService;
import com.smk.pay.core.base.BaseServiceTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * AccountConsumeService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>11/29/2016</pre>
 */
public class AccountConsumeServiceTest extends BaseServiceTest {
    @Autowired
    private IAccountConsumeService accountConsumeService;

    @org.junit.Test
    public void testConsume() {

        RequestHeader header = new RequestHeader("20161201", "095612", "20161201095612123");
        String merchantId = "123";
        String userId = "100002611";
        BigDecimal amount = new BigDecimal(500);
        BigDecimal cost = new BigDecimal(100);
        RpcResponse<String> response = accountConsumeService.consume(header, AccountChannelEnum.INTERNET,
                AccountBizEnum.NORMAL,
                merchantId,
                AccountTypeEnum.ONLINE, userId, amount, cost, new HashMap<String, Object>());

        org.junit.Assert.assertNotNull(response);
    }

}
