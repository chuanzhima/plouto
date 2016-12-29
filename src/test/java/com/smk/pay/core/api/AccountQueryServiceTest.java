package com.smk.pay.core.api;

import com.smk.pay.account.core.enums.AccountBizEnum;
import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.response.AccountAvailable;
import com.smk.pay.account.core.response.AccountDetailResp;
import com.smk.pay.account.core.response.AccountInfo;
import com.smk.pay.account.core.response.RpcResponse;
import com.smk.pay.account.core.service.IAccountQueryService;
import com.smk.pay.core.base.BaseServiceTest;
import com.smk.pay.core.utils.DateUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;

/**
 * AccountQueryService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>11/08/2016</pre>
 */
public class AccountQueryServiceTest extends BaseServiceTest {

    @Autowired
    private IAccountQueryService accountQueryService;
    @Autowired
    private ApplicationContext context;

    @Test
    public void testDS() throws Exception {
        javax.sql.DataSource source = context.getBean(DataSource.class);
        System.out.println(source.getConnection());
        SqlSessionFactory sqlSessionFactory = context.getBean(SqlSessionFactory.class);
        System.out.println(sqlSessionFactory.getConfiguration());
    }

    @Test
    public void testQueryAccountInfo() {
        String userId = "123457";
        RpcResponse<AccountInfo> rpcResponse = accountQueryService.queryAccountInfoByUserId(userId);
        Assert.assertTrue(rpcResponse.getIsSucc());
    }

    @Test
    public void testQueryAvailableAmount() {
        String userId = "123457";
        RpcResponse<AccountAvailable> rpcResponse = accountQueryService.queryAvailableAmount(userId,
                AccountTypeEnum.ONLINE);
        Assert.assertTrue(rpcResponse.getIsSucc());
    }

    @Test
    public void testQueryAccountDetail() {
        String userId = "123457";
        String transType = "";
        String merchantId = "";
        Date fromDate = DateUtil.addMonth(new Date(), -5);
        int pageNum = 1;
        int pageSize = 20;
        RpcResponse<AccountDetailResp> rpcResponse = accountQueryService.queryAccountDetail
                (userId,
                        AccountTypeEnum
                                .ONLINE, transType,
                        AccountChannelEnum.INTERNET, merchantId, AccountBizEnum.NORMAL, fromDate, new
                                Date(), pageNum, pageSize);
        Assert.assertTrue(rpcResponse.getIsSucc());

    }

    @Test
    public void testQueryBindedAccountInfo() {
        String userId = "123457";
        RpcResponse<ArrayList<AccountInfo>> arrayListRpcResponse = accountQueryService.queryBindedAccountInfo(userId);
        Assert.assertTrue(arrayListRpcResponse.getIsSucc());
    }

}
