package com.smk.pay.core.api;

import com.smk.pay.account.core.request.RequestHeader;
import com.smk.pay.account.core.response.RpcResponse;
import com.smk.pay.account.core.service.IAccountReverseService;
import com.smk.pay.core.base.BaseServiceTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * AccountReverseService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12/23/2016</pre>
 */
public class AccountReverseServiceTest extends BaseServiceTest {

    @Autowired
    private IAccountReverseService accountReverseService;

    @Test
    public void testReverse() {

        RequestHeader header = new RequestHeader("20161227","141812","201612271418121111");
        String originalSeq = "201612271053531113";
        String originalDate = "20161227";
        String originalTime = "105353";
        Map<String, Object> extraParam = new HashMap<>();

        RpcResponse<String> rpcResponse = accountReverseService.reverse(header, originalSeq, originalDate,
                originalTime,
                extraParam);
        Assert.assertNotNull(rpcResponse);
    }


}
