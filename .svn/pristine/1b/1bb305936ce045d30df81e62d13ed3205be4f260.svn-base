package com.smk.pay.core.manager.atom.impl;

import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountFundFlowEnum;
import com.smk.pay.account.core.enums.AccountLevelEnum;
import com.smk.pay.account.core.request.RequestHeader;
import com.smk.pay.core.constant.AccountBizConstant;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.dto.InternalAccountDto;
import com.smk.pay.core.dto.MerchantAccountInfoDto;
import com.smk.pay.core.dto.MerchantTransDetailDto;
import com.smk.pay.core.dto.TransDetailDto;
import com.smk.pay.core.entity.InvoiceInfoEntity;
import com.smk.pay.core.entity.MerchantLimitsEntity;
import com.smk.pay.core.enums.AccountTransTypeEnum;
import com.smk.pay.core.exception.ServiceException;
import com.smk.pay.core.manager.atom.IRecharge;
import com.smk.pay.core.manager.base.IInternalAccountManager;
import com.smk.pay.core.manager.base.IMerchantAccountInfoManager;
import com.smk.pay.core.manager.base.IMerchantTransDetailManager;
import com.smk.pay.core.manager.base.ITransDetailManager;
import com.smk.pay.core.mapper.InvoiceInfoEntityMapper;
import com.smk.pay.core.mapper.MerchantLimitsEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/15 10:32
 */
@Component(value = "rechargeYHK4Merchant")
public class RechargeYHK4Merchant implements IRecharge {

    @Autowired
    private MerchantLimitsEntityMapper merchantLimitsEntityMapper;
    @Autowired
    private IMerchantAccountInfoManager merchantAccountInfoManager;
    @Autowired
    private IInternalAccountManager internalAccountManager;
    @Autowired
    private ITransDetailManager transDetailManager;
    @Autowired
    private IMerchantTransDetailManager merchantTransDetailManager;
    @Autowired
    private InvoiceInfoEntityMapper invoiceInfoEntityMapper;


    @Override
    public void recharge(String sequence, String accountId, BigDecimal amount, String bankId, String merchantId,
                         String accDate, RequestHeader header, Date transDate, AccountChannelEnum channelEnum) {

        MerchantAccountInfoDto merchantAccountInfoDto = merchantAccountInfoManager.queryAccountById(accountId);
        MerchantLimitsEntity merchantLimitsEntity = merchantLimitsEntityMapper.selectByMerchantId(merchantId);

        MerchantAccountInfoDto newAccount = new MerchantAccountInfoDto();
        newAccount.setAmount1(merchantAccountInfoDto.getAmount1().add(amount));
        MerchantAccountInfoDto oldAccount = new MerchantAccountInfoDto();
        oldAccount.setAmount1(merchantAccountInfoDto.getAmount1());

        if (null != merchantLimitsEntity) {
            BigDecimal useLimit = merchantLimitsEntity.getUseLimit();
            MerchantLimitsEntity entity = new MerchantLimitsEntity();
            entity.setMerchantId(merchantId);
            if (useLimit.compareTo(amount) > 0) {
                entity.setUseLimit(useLimit.subtract(amount));
            } else {
                entity.setUseLimit(new BigDecimal(0));
            }
            merchantLimitsEntityMapper.updateByPrimaryKeySelective(entity);
        }
        int count = merchantAccountInfoManager.updateAccountAmount(accountId, oldAccount, newAccount);
        if (count != 1)
            throw new ServiceException(ResultCodeConstant.SYSTEM_ERROR_CONCURRENT);

        internalAccountManager.updateAmountByTypeIdAndBankId(amount,
                AccountBizConstant.ACCOUNT_TYPE_KEY_YHSFKZH, bankId);

        TransDetailDto transDetailDto = new TransDetailDto.Builder().serialNo(sequence)
                .transId(AccountBizConstant.TRANS_DETAIL_TRANS_ID_1).transType
                        (AccountTransTypeEnum.MERCHANT_RECHARGE.key()).sourceOfFunds
                        (AccountFundFlowEnum.YHK.name()).accountId(accountId).accountClass
                        (AccountLevelEnum.SECOND.value()).accountCl(AccountBizConstant
                        .YHK_AMOUNT_COLUMN).reqSerialNo(header.getReqSeq()).reqTransDate
                        (header.getTxDate()).reqTransTime(header.getTxTime()).transDate
                        (transDate).status(AccountBizConstant.TRANS_DETAIL_STATUS_1)
                .replacementFlag(AccountBizConstant.TRANS_DETAIL_REPLACEMENT_FLAG_0)
                .partyMarkNo(AccountBizConstant.PARTY_MARK_NO_0001).amount1(amount).amount11
                        (merchantAccountInfoDto.getAmount1().add(amount)).userDefindMark(AccountBizConstant
                        .TRANS_DETAIL_USER_DEFIND_MARK_0).channel(channelEnum.name())
                .merchantId(merchantId).accDate(accDate).build();

        transDetailManager.addTransDetail(transDetailDto);

        MerchantTransDetailDto merchantTransDetailDto = new MerchantTransDetailDto.Builder().serialNo(sequence)
                .transId(AccountBizConstant.TRANS_DETAIL_TRANS_ID_1).transType(AccountTransTypeEnum.MERCHANT_RECHARGE
                        .key()).sourceOfFunds(AccountFundFlowEnum.YHK.name()).accountId(accountId).accountClass
                        (AccountLevelEnum.SECOND.value()).accountCl(AccountBizConstant.YHK_AMOUNT_COLUMN).reqSerialNo
                        (header.getReqSeq()).reqTransDate(header.getTxDate()).reqTransTime(header.getTxTime())
                .transDate(transDate).status(AccountBizConstant.TRANS_DETAIL_STATUS_1).accDate(accDate).partyMarkNo
                        (AccountBizConstant.PARTY_MARK_NO_0001).amount1(amount).amount11(merchantAccountInfoDto.
                        getAmount1().add(amount)).userDefindMark(AccountBizConstant.TRANS_DETAIL_USER_DEFIND_MARK_0).
                        channel(channelEnum.name()).merchantId(merchantId).build();
        merchantTransDetailManager.addTransDetail(merchantTransDetailDto);

        InternalAccountDto internalAccountDto = internalAccountManager.queryByAccountTypeIdBankId
                (AccountBizConstant.ACCOUNT_TYPE_KEY_YHSFKZH, bankId);

        InvoiceInfoEntity invoiceInfoEntity = new InvoiceInfoEntity(null, AccountBizConstant
                .INVOICE_INFO_DEBIT_ACCOUNT_TYPE_1106, AccountBizConstant
                .INVOICE_INFO_CREDIT_ACCOUNT_TYPE_2901, AccountTransTypeEnum.MERCHANT_RECHARGE.key(),
                sequence, internalAccountDto.getInternalAccountId(), accountId, AccountBizConstant
                .INVOICE_INFO_DEBIT_ORG_ID_0001, AccountBizConstant
                .INVOICE_INFO_CREDIT_ORG_ID_0001, transDate, AccountBizConstant
                .INVOICE_INFO_SOURCE_OF_FUNDS_2, amount, AccountBizConstant
                .INVOICE_INFO_STATUS_1, AccountBizConstant.PARTY_MARK_NO_0001, accDate);

        invoiceInfoEntityMapper.insertSelective(invoiceInfoEntity);
    }
}
