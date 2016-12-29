package com.smk.pay.core.manager.base.impl;

import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.dto.InternalAccountDto;
import com.smk.pay.core.entity.InternalAccountEntity;
import com.smk.pay.core.exception.DBException;
import com.smk.pay.core.exception.ServiceException;
import com.smk.pay.core.manager.base.IInternalAccountManager;
import com.smk.pay.core.mapper.InternalAccountEntityMapper;
import com.smk.pay.core.utils.BeanCopierCacheUtil;
import com.smk.pay.dal.condtion.Criteria;
import com.smk.pay.dal.condtion.EntityCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/11 15:06
 */
@Component(value = "internalAccountManager")
public class InternalAccountManagerImpl implements IInternalAccountManager {
    @Autowired
    private InternalAccountEntityMapper internalAccountEntityMapper;

    public InternalAccountDto queryByAccountTypeIdBankId(String accountTypeId, String bankId) {

        InternalAccountDto internalAccountDto = new InternalAccountDto();
        try {
            List<InternalAccountEntity> internalAccountEntityList = internalAccountEntityMapper
                    .selectList(new EntityCondition()
                            .addCriteria(new
                                    Criteria()
                                    .addCriterion("ACCOUNT_TYPE_ID=", accountTypeId, "ACCOUNT_TYPE_ID").addCriterion
                                            ("BANK_ID=", bankId, "BANK_ID")));
            if (CollectionUtils.isEmpty(internalAccountEntityList)) {
                throw new ServiceException(ResultCodeConstant.INTERNAL_ACCOUNT_DATA_EXCEPTION);
            }
            BeanCopierCacheUtil.copy(internalAccountEntityList.get(0), internalAccountDto, null);
            return internalAccountDto;
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    public int updateAmountByPK(BigDecimal amount, String internalAccountId) {
        try {
            return internalAccountEntityMapper.updateAmountByPK(internalAccountId, amount);
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    public int updateAmountByTypeIdAndBankId(BigDecimal amount, String accountTypeId, String bankId) {
        try {
            return internalAccountEntityMapper.updateAmountByTypeIdAndBankId(amount, accountTypeId,
                    bankId);
        } catch (Exception e) {
            throw new DBException(e);
        }
    }
}
