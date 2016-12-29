package com.smk.pay.core.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.response.AccountCreditDetailResp;
import com.smk.pay.account.core.response.AccountCreditInfo;
import com.smk.pay.account.core.response.RpcResponse;
import com.smk.pay.account.core.service.IAccountCreditQueryService;
import com.smk.pay.core.annotations.DubboService;
import com.smk.pay.core.constant.AccountBizConstant;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.manager.IAccountCreditQueryManager;
import com.smk.pay.core.meta.ServiceResultCode;
import com.smk.pay.core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 信用查询服务
 * <p/>
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/21 9:57
 */
@Service(version = "1.0.0")
public class AccountCreditQueryService implements IAccountCreditQueryService {

    @Autowired
    private IAccountCreditQueryManager accountCreditQueryManager;

    @DubboService
    @Override
    public RpcResponse<AccountCreditInfo> queryAccountCreditInfo(AccountTypeEnum typeEnum, String value) {

        if (null == typeEnum || StringUtil.isEmpty(value)) {
            return new RpcResponse<>(Boolean.FALSE, ResultCodeConstant
                    .PARAMETER_INVALID, ServiceResultCode.RESULT_CODE_MAPPING.get(ResultCodeConstant
                    .PARAMETER_INVALID));
        }
        AccountCreditInfo creditInfo = accountCreditQueryManager.queryAccountCreditInfo(typeEnum, value);
        return new RpcResponse<>(creditInfo, Boolean.TRUE);
    }

    @DubboService
    @Override
    public RpcResponse<AccountCreditDetailResp> queryAccountCreditDetail(Date transFromDate, Date transToDate,
                                                                         String cardNumber, String idNo, String type,
                                                                         int pageNum, int pageSize) {
        if (StringUtil.isNull(transFromDate, transToDate) || (StringUtil.isEmpty(cardNumber) && StringUtil.isEmpty
                (idNo)) || pageNum < 1 || pageSize < 0)
            return new RpcResponse<>(Boolean.FALSE, ResultCodeConstant
                    .PARAMETER_INVALID, ServiceResultCode.RESULT_CODE_MAPPING.get(ResultCodeConstant
                    .PARAMETER_INVALID));

        if (pageSize > AccountBizConstant.MAX_PAGE_SIZE) {
            return new RpcResponse<>(Boolean.FALSE, ResultCodeConstant.QUERY_RECORDS_TOO_MUCH,
                    ServiceResultCode.RESULT_CODE_MAPPING.get(ResultCodeConstant
                            .QUERY_RECORDS_TOO_MUCH));
        }
        AccountCreditDetailResp creditDetailResp = accountCreditQueryManager.queryAccountCreditDetail(transFromDate,
                transToDate, cardNumber, idNo, type, pageNum, pageSize);
        return new RpcResponse<>(creditDetailResp, Boolean.TRUE);
    }
}
