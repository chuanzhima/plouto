package com.smk.pay.core.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountLevelEnum;
import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.request.MigrateAccountRequest;
import com.smk.pay.account.core.request.OpenAccountRequest;
import com.smk.pay.account.core.request.RequestHeader;
import com.smk.pay.account.core.response.RpcResponse;
import com.smk.pay.account.core.service.IAccountMngService;
import com.smk.pay.core.annotations.DubboService;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.manager.IAccountMngManager;
import com.smk.pay.core.meta.ServiceResultCode;
import com.smk.pay.core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 账户管理
 * <p/>
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/24 9:57
 */
@Service(version = "1.0.0")
public class AccountMngService implements IAccountMngService {

    @Autowired
    private IAccountMngManager accountMngManager;

    @DubboService
    public RpcResponse<String> openAccount(OpenAccountRequest openAccountRequest,
                                           AccountTypeEnum typeEnum) {

        // 参数空校验
        RpcResponse<String> rpcResponse = new RpcResponse<>(Boolean.FALSE);
        if (openAccountRequest == null || typeEnum == null ||
                (openAccountRequest.getUserCls().equals(OpenAccountRequest.OPEN_ACCOUNT_PERSONAL)
                        && (StringUtil.isEmpty(openAccountRequest.getCustCredentialNo(),
                        openAccountRequest.getCustCredentialType(), openAccountRequest.getCustId
                                (), openAccountRequest.getCustName())))) {
            return new RpcResponse<>(Boolean.FALSE, ResultCodeConstant
                    .PARAMETER_INVALID, ServiceResultCode.RESULT_CODE_MAPPING.get(ResultCodeConstant
                    .PARAMETER_INVALID));
        }
        if (typeEnum == AccountTypeEnum.ONLINE) {
            Map<Boolean, String> resultMap = accountMngManager.openAccount(openAccountRequest);
            if (resultMap.containsKey(Boolean.FALSE)) {
                rpcResponse = new RpcResponse<>(Boolean.FALSE, resultMap.get(Boolean.FALSE),
                        ServiceResultCode.RESULT_CODE_MAPPING.get(resultMap.get(Boolean.FALSE)));
            } else {
                rpcResponse = new RpcResponse<>(resultMap.get(Boolean.TRUE), Boolean.TRUE);
            }
        }
        return rpcResponse;
    }

    @DubboService
    public RpcResponse<String> alterAccountLevel(String custId, AccountLevelEnum levelEnum) {
        // 参数空校验
        RpcResponse<String> rpcResponse;
        if (StringUtil.isEmpty(custId) || levelEnum == null) {
            return new RpcResponse<>(Boolean.FALSE, ResultCodeConstant
                    .PARAMETER_INVALID, ServiceResultCode.RESULT_CODE_MAPPING.get(ResultCodeConstant
                    .PARAMETER_INVALID));
        }
        String result = accountMngManager.alterAccountLevel(custId, levelEnum);
        rpcResponse = new RpcResponse<>(ResultCodeConstant.SUCCESS.equals(result),
                result, ServiceResultCode.RESULT_CODE_MAPPING.get(result));

        return rpcResponse;
    }

    public RpcResponse<String> closeAccount(String value, AccountTypeEnum typeEnum) {
        // TODO
        return null;
    }

    @DubboService
    public RpcResponse<String> bindAccount(RequestHeader header, String userId, String cardNo,
                                           String merchantId, AccountChannelEnum channelEnum) {
        // 参数空校验
        if (channelEnum == null || StringUtil.isEmpty(header.getReqSeq(), header.getTxDate(),
                header.getTxTime(), userId, cardNo, merchantId))
            return new RpcResponse<>(Boolean.FALSE, ResultCodeConstant
                    .PARAMETER_INVALID, ServiceResultCode.RESULT_CODE_MAPPING.get(ResultCodeConstant
                    .PARAMETER_INVALID));

        accountMngManager.bindAccount(header, userId, cardNo, merchantId, channelEnum);
        return new RpcResponse<>(Boolean.TRUE, ResultCodeConstant.SUCCESS,
                ServiceResultCode.RESULT_CODE_MAPPING.get(ResultCodeConstant.SUCCESS));
    }

    @DubboService
    public RpcResponse<String> migrateAccount(RequestHeader header, String merchantId,
                                              AccountChannelEnum channelEnum,
                                              MigrateAccountRequest request) {
        // 参数空校验
        if (StringUtil.isNull(channelEnum, request, request.getCardType(), request
                        .getCgAmount(), request.getXjAmount(), request.getZxzjAmount(), request.getGgkAmount(),
                request.getGuaranteeAmount()) || StringUtil.isEmpty(header.getReqSeq(), header.getTxDate(),
                header.getTxTime(),
                merchantId, request.getCustCredentialType(), request.getCustCredentialNo(), request.getCardNumber())) {
            return new RpcResponse<>(Boolean.FALSE, ResultCodeConstant
                    .PARAMETER_INVALID, ServiceResultCode.RESULT_CODE_MAPPING.get(ResultCodeConstant
                    .PARAMETER_INVALID));
        }
        accountMngManager.migrateAccount(header, channelEnum, merchantId, request);
        return new RpcResponse<>(Boolean.TRUE, ResultCodeConstant.SUCCESS,
                ServiceResultCode.RESULT_CODE_MAPPING.get(ResultCodeConstant.SUCCESS));
    }
}
