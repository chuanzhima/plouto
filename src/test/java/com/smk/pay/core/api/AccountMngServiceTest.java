package com.smk.pay.core.api;

import com.smk.pay.account.core.constant.AccountConstant;
import com.smk.pay.account.core.enums.AccountCardTypeEnum;
import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.request.MigrateAccountRequest;
import com.smk.pay.account.core.request.OpenAccountRequest;
import com.smk.pay.account.core.request.RequestHeader;
import com.smk.pay.account.core.response.RpcResponse;
import com.smk.pay.account.core.service.IAccountMngService;
import com.smk.pay.core.base.BaseServiceTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * AccountMngService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>11/08/2016</pre>
 */
public class AccountMngServiceTest extends BaseServiceTest {

    @Autowired
    private IAccountMngService accountMngService;

    @org.junit.Test
    public void testOpenAccount() {

        OpenAccountRequest openAccountRequest = new OpenAccountRequest("123450", "猪刚鬣3",
                AccountConstant.CREDENTIAL_TYPE_ID, "370881199612311245");
        openAccountRequest.setUserCls(OpenAccountRequest.OPEN_ACCOUNT_PERSONAL);
        RpcResponse<String> response = accountMngService.openAccount(openAccountRequest,
                AccountTypeEnum.ONLINE);
        Assert.assertNotNull(response);
    }

    @Test
    public void testMigrateAccount() {
        RequestHeader header = new RequestHeader("20161128", "181523", "333333333333333");
        String merchantId = "123456";
        MigrateAccountRequest request = new MigrateAccountRequest(AccountCardTypeEnum.HZSMK,
                "A123456", "1", "370881199012345678", new BigDecimal(12), new BigDecimal(23), new
                BigDecimal(34), new BigDecimal(45), new BigDecimal(11));
        RpcResponse<String> response = accountMngService.migrateAccount(header, merchantId,
                AccountChannelEnum.INTERNET, request);
        Assert.assertNotNull(response);
    }

    @Test
    public void testBindAccount() {

        RequestHeader header = new RequestHeader("20161128", "181523", "444444444444");
        String userId = "123457";
        String merchantId = "321";
        String cardNo = "A123456";
        RpcResponse<String> response = accountMngService.bindAccount(header, userId, cardNo,
                merchantId,
                AccountChannelEnum
                        .INTERNET);
        Assert.assertNotNull(response);
    }

}
