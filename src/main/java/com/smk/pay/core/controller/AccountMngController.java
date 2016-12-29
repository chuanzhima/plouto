package com.smk.pay.core.controller;


import com.smk.pay.account.core.enums.AccountLevelEnum;
import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.request.OpenAccountRequest;
import com.smk.pay.account.core.response.RpcResponse;
import com.smk.pay.account.core.service.IAccountMngService;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.meta.ServiceResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/17 15:45
 */
@RestController
@RequestMapping("/mng")
public class AccountMngController {

    private final static Logger LOGGER = LoggerFactory.getLogger(AccountMngController.class);
    @Autowired
    private IAccountMngService accountMngService;

    @RequestMapping(value = "/alterLevel", method = RequestMethod.POST)
    public RpcResponse<String> alterLevel(@RequestParam("custId") String custId, @RequestParam("level") String level) {

        LOGGER.info("alterLevel-> param : custId={},level={}",custId, level);
        if (AccountLevelEnum.get(level) == null) {
            return new RpcResponse<>(Boolean.FALSE, ResultCodeConstant.PARAMETER_INVALID, ServiceResultCode
                    .RESULT_CODE_MAPPING.get(ResultCodeConstant.PARAMETER_INVALID));
        }
        RpcResponse<String> rpcResponse = accountMngService.alterAccountLevel(custId, AccountLevelEnum.get(level));
        LOGGER.info("alterLevel-> result : " + rpcResponse);
        return rpcResponse;
    }
}
