package com.smk.pay.core.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.request.OpenAccountCreditRequest;
import com.smk.pay.account.core.request.RequestHeader;
import com.smk.pay.account.core.response.RpcResponse;
import com.smk.pay.account.core.service.IAccountCreditMngService;
import com.smk.pay.core.annotations.DubboService;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.manager.IAccountCreditMngManager;
import com.smk.pay.core.meta.ServiceResultCode;
import com.smk.pay.core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * 信用管理服务
 * <p/>
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/21 9:59
 */
@Service(version = "1.0.0")
public class AccountCreditMngService implements IAccountCreditMngService {

    @Autowired
    private IAccountCreditMngManager accountCreditMngManager;

    /**
     * 开通信用服务
     *
     * @param header
     * @param channelEnum
     * @param request
     */
    @DubboService
    @Override
    public RpcResponse<String> openAccountCredit(RequestHeader header, AccountChannelEnum channelEnum,
                                                 OpenAccountCreditRequest request) {

        // 基本空值校验
        if (StringUtil.isNull(header, channelEnum, request, request.getCreditAmt()) || StringUtil.isEmpty(header.getReqSeq(),
                header.getTxDate(), header.getTxTime(), request.getCustCredentialType(), request.getCustCredentialNo(),
                request.getCustId(), request.getCustName(), request.getMobile()) || request.getCreditAmt().compareTo
                (new BigDecimal(0)) <= 0) {
            return new RpcResponse<>(Boolean.FALSE, ResultCodeConstant
                    .PARAMETER_INVALID, ServiceResultCode.RESULT_CODE_MAPPING.get(ResultCodeConstant
                    .PARAMETER_INVALID));
        }
        accountCreditMngManager.openCredit(header, channelEnum, request);
        return new RpcResponse<>(Boolean.TRUE, ResultCodeConstant.SUCCESS, ServiceResultCode.RESULT_CODE_MAPPING.get
                (ResultCodeConstant.SUCCESS));
    }


}
