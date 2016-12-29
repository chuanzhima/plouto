package com.smk.pay.core.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountFundFlowEnum;
import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.request.RequestHeader;
import com.smk.pay.account.core.response.RpcResponse;
import com.smk.pay.account.core.service.IAccountRechargeService;
import com.smk.pay.core.annotations.DubboService;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.manager.IAccountRechargeManager;
import com.smk.pay.core.meta.ServiceResultCode;
import com.smk.pay.core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * 充值
 * <p/>
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/8 13:57
 */
@Service(version = "1.0.0")
public class AccountRechargeService implements IAccountRechargeService {

    @Autowired
    private IAccountRechargeManager accountRechargeManager;

    @DubboService
    public RpcResponse<String> recharge(RequestHeader header, AccountChannelEnum channelEnum,
                                        String merchantId, AccountTypeEnum typeEnum,
                                        String typeValue, AccountFundFlowEnum fundFlowEnum,
                                        BigDecimal amount, String bankId, String companyId) {

        if (StringUtil.isNull(header, channelEnum, typeEnum, amount, fundFlowEnum) || amount.compareTo(new BigDecimal
                (0)) < 0 ||
                StringUtil.isEmpty(header.getReqSeq(), header.getTxDate(), header.getTxTime(), merchantId, typeValue,
                        bankId)) {
            return new RpcResponse<>(Boolean.FALSE, ResultCodeConstant
                    .PARAMETER_INVALID, ServiceResultCode.RESULT_CODE_MAPPING.get(ResultCodeConstant
                    .PARAMETER_INVALID));
        }
        accountRechargeManager.recharge(header, channelEnum, merchantId, typeEnum, typeValue, fundFlowEnum,
                amount, bankId, companyId);

        return new RpcResponse<>(Boolean.TRUE, ResultCodeConstant.SUCCESS, ServiceResultCode.RESULT_CODE_MAPPING.get
                (ResultCodeConstant.SUCCESS));
    }

    @Override
    public RpcResponse<String> recharge4Merchant(RequestHeader header, AccountChannelEnum channelEnum,
                                                 String merchantId, AccountFundFlowEnum fundFlowEnum, BigDecimal amount,
                                                 String bankId) {
        if (StringUtil.isNull(header, channelEnum, amount, fundFlowEnum) || amount.compareTo(new BigDecimal(0)) < 0 ||
                StringUtil.isEmpty(header.getReqSeq(), header.getTxDate(), header.getTxTime(), merchantId, bankId)) {
            return new RpcResponse<>(Boolean.FALSE, ResultCodeConstant
                    .PARAMETER_INVALID, ServiceResultCode.RESULT_CODE_MAPPING.get(ResultCodeConstant
                    .PARAMETER_INVALID));
        }
        accountRechargeManager.recharge4Merchant(header, channelEnum, merchantId, fundFlowEnum, amount, bankId);

        return new RpcResponse<>(Boolean.TRUE, ResultCodeConstant.SUCCESS, ServiceResultCode.RESULT_CODE_MAPPING.get
                (ResultCodeConstant.SUCCESS));
    }
}
