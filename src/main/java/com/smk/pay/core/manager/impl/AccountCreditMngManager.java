package com.smk.pay.core.manager.impl;

import com.smk.pay.account.core.enums.AccountBizEnum;
import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountLevelEnum;
import com.smk.pay.account.core.request.OpenAccountCreditRequest;
import com.smk.pay.account.core.request.RequestHeader;
import com.smk.pay.core.constant.AccountBizConstant;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.dto.LnsAcctInfoDto;
import com.smk.pay.core.dto.LnsAcctListDto;
import com.smk.pay.core.dto.TransDetailDto;
import com.smk.pay.core.entity.AccSystemEntity;
import com.smk.pay.core.entity.LnsAcctInfoEntity;
import com.smk.pay.core.entity.LnsAcctListEntity;
import com.smk.pay.core.enums.AccountTransTypeEnum;
import com.smk.pay.core.exception.DBException;
import com.smk.pay.core.exception.ServiceException;
import com.smk.pay.core.manager.IAccountCreditMngManager;
import com.smk.pay.core.manager.base.ITransDetailManager;
import com.smk.pay.core.mapper.AccSystemEntityMapper;
import com.smk.pay.core.mapper.LnsAcctInfoEntityMapper;
import com.smk.pay.core.mapper.LnsAcctListEntityMapper;
import com.smk.pay.core.utils.BeanCopierCacheUtil;
import com.smk.pay.core.utils.StringUtil;
import com.smk.pay.core.validator.CreditValidator;
import com.smk.pay.dal.condtion.EntityCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/22 10:39
 */
@Service("accountCreditMngManager")
public class AccountCreditMngManager implements IAccountCreditMngManager {

    @Autowired
    private LnsAcctInfoEntityMapper lnsAcctInfoEntityMapper;
    @Autowired
    private LnsAcctListEntityMapper lnsAcctListEntityMapper;
    @Autowired
    private ITransDetailManager transDetailManager;
    @Autowired
    private AccSystemEntityMapper accSystemEntityMapper;
    @Autowired
    private CreditValidator creditValidator;

    @Transactional
    @Override
    public void openCredit(RequestHeader header, AccountChannelEnum channelEnum, OpenAccountCreditRequest request) {

        /**
         * 校验：
         * 1、重复交易，
         * 2、授信额度是否合法，
         * 3、是否绑定市民卡，
         * 4、卡状态，
         * 5、主账户是否存在，
         * 6、是否已开通过信用支付
         * 7、用户名&手机号&身份证是否和预付卡一致
         */
        Map<Boolean, List<String>> checkMap = creditValidator.validate(header, request);
        if (checkMap.containsKey(Boolean.FALSE)) {
            throw new ServiceException(checkMap.get(Boolean.FALSE).get(0));
        }
        String smkCard = checkMap.get(Boolean.TRUE).get(0);
        String accountId = checkMap.get(Boolean.TRUE).get(1);
        String userId = checkMap.get(Boolean.TRUE).get(2);
        String userName = checkMap.get(Boolean.TRUE).get(3);
        String accDate = this.queryAccDate();

        String sequence = StringUtil.randomSequence();
        Date openDate = new Date();

        long acctNo = lnsAcctInfoEntityMapper.selectAcctNoSequence();

        // 插入lnsacctinfo表
        LnsAcctInfoDto lnsAcctInfoDto = new LnsAcctInfoDto.Builder().businessType(AccountBizEnum.CREDIT.getValue())
                .acctno(String.valueOf(acctNo)).acctstat(LnsAcctInfoDto.STATUS_NORMAL).userId(userId)
                .userName(userName).papersType(LnsAcctInfoDto.CREDENTIAL_TYPE_ID)
                .papersNo(request.getCustCredentialNo()).phoneNo(request.getMobile())
                .loanstatus(LnsAcctInfoDto.LOAN_STATUS_NORMAL).crdflag(LnsAcctInfoDto
                        .CRDFLAG_YES).crdno(smkCard).issueflag(LnsAcctInfoDto.ISSUE_FLAG_YES).createSerialNo(sequence)
                .createDate(openDate).opendate(openDate).amount1(request.getCreditAmt()).lastUpdateDate(openDate).build();
        LnsAcctInfoEntity entity = new LnsAcctInfoEntity();
        BeanCopierCacheUtil.copy(lnsAcctInfoDto, entity, null);
        lnsAcctInfoEntityMapper.insertSelective(entity);

        // 插入lnsacctlist表
        LnsAcctListDto lnsAcctListDto = new LnsAcctListDto.Builder().transno(sequence).acctno(String.valueOf(acctNo))
                .transType(AccountTransTypeEnum.CREDIT_OPEN.key()).reqSerialNo(header.getReqSeq()).reqTransDate
                        (header.getTxDate()).reqTransTime(header.getTxTime()).accDate(accDate).transDate(openDate)
                .status(LnsAcctInfoDto.STATUS_NORMAL).channel(channelEnum.name()).businessType(AccountBizEnum.CREDIT
                        .getValue()).build();
        LnsAcctListEntity lnsAcctListEntity = new LnsAcctListEntity();
        BeanCopierCacheUtil.copy(lnsAcctListDto, lnsAcctListEntity, null);
        lnsAcctListEntityMapper.insertSelective(lnsAcctListEntity);

        // 插入trans_detail表
        TransDetailDto transDetailDto = new TransDetailDto.Builder().serialNo(sequence).transId(AccountBizConstant
                .TRANS_DETAIL_TRANS_ID_1).transType(AccountTransTypeEnum.CREDIT_OPEN.key()).userId(userId).userName
                (userName).accountId(accountId).accountClass(AccountLevelEnum.FIRST.value())
                .reqSerialNo(header.getReqSeq()).reqTransDate(header.getTxDate()).reqTransTime(header.getTxTime())
                .transDate(openDate).status(AccountBizConstant.TRANS_DETAIL_STATUS_1).accDate(accDate)
                .replacementFlag(AccountBizConstant.TRANS_DETAIL_REPLACEMENT_FLAG_0).partyMarkNo(AccountBizConstant
                        .PARTY_MARK_NO_0001).channel(channelEnum.name()).accountingTrans(AccountBizConstant
                        .TRANS_DETAIL_ACCOUNT_TRANS_0).businessType(AccountBizEnum.CREDIT.getValue()).build();
        transDetailManager.addTransDetail(transDetailDto);
    }

    private String queryAccDate() {
        List<AccSystemEntity> list;
        try {
            list = accSystemEntityMapper.selectList(new EntityCondition());
        } catch (Exception e) {
            throw new DBException(e);
        }
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultCodeConstant.ACC_SYSTEM_NO_DATA);
        }
        return list.get(0).getAccDate();
    }
}
