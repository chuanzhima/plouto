package com.smk.pay.core.manager.base.impl;

import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.dto.MerchantAccountInfoDto;
import com.smk.pay.core.entity.MerchantAccountInfoEntity;
import com.smk.pay.core.exception.DBException;
import com.smk.pay.core.exception.ServiceException;
import com.smk.pay.core.manager.base.IMerchantAccountInfoManager;
import com.smk.pay.core.mapper.MerchantAccountInfoEntityMapper;
import com.smk.pay.core.utils.BeanCopierCacheUtil;
import com.smk.pay.dal.condtion.Criteria;
import com.smk.pay.dal.condtion.EntityCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 商户账户管理
 * <p/>
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/16 15:09
 */
@Component(value = "merchantAccountInfoManager")
public class MerchantAccountManagerImpl implements IMerchantAccountInfoManager {

    @Autowired
    private MerchantAccountInfoEntityMapper merchantAccountInfoEntityMapper;

    @Override
    public int updateAccountAmount(String accountId, MerchantAccountInfoDto oldAmount, MerchantAccountInfoDto newAmount) {

        try {
            newAmount.setLastUpdateDate(new Date());
            MerchantAccountInfoEntity accountInfoEntity = new MerchantAccountInfoEntity();
            Criteria criteria = new Criteria().addCriterion("MER_ACCOUNT_ID=", accountId,
                    "MER_ACCOUNT_ID");
            if (oldAmount.getAmount1() != null)
                criteria.addCriterion("AMOUNT1=", oldAmount.getAmount1(), "AMOUNT1");
            else if (oldAmount.getAmount2() != null)
                criteria.addCriterion("AMOUNT2=", oldAmount.getAmount2(), "AMOUNT2");
            else if (oldAmount.getAmount3() != null)
                criteria.addCriterion("AMOUNT3=", oldAmount.getAmount3(), "AMOUNT3");
            else if (oldAmount.getAmount4() != null)
                criteria.addCriterion("AMOUNT4=", oldAmount.getAmount4(), "AMOUNT4");
            else if (oldAmount.getAmount5() != null)
                criteria.addCriterion("AMOUNT5=", oldAmount.getAmount5(), "AMOUNT5");
            else if (oldAmount.getAmount6() != null)
                criteria.addCriterion("AMOUNT6=", oldAmount.getAmount6(), "AMOUNT6");

            BeanCopierCacheUtil.copy(newAmount, accountInfoEntity, null);
            return merchantAccountInfoEntityMapper.updateSelective(accountInfoEntity, new EntityCondition
                    ().addCriteria(criteria));
        } catch (Exception e) {
            throw new DBException(e);
        }
    }


    @Override
    public MerchantAccountInfoDto queryAccountByMerchantId(String merchantId) {
        try {
            MerchantAccountInfoEntity merchantAccountInfoEntity = merchantAccountInfoEntityMapper.selectAccountByMerchantId(merchantId);
            if (merchantAccountInfoEntity == null)
                throw new ServiceException(ResultCodeConstant.ACCOUNT_NOT_EXIST);

            MerchantAccountInfoDto merchantAccountInfoDto = new MerchantAccountInfoDto();
            BeanCopierCacheUtil.copy(merchantAccountInfoEntity, merchantAccountInfoDto, null);
            return merchantAccountInfoDto;
        } catch (ServiceException e) {
            throw new DBException(e);
        }
    }

    @Override
    public MerchantAccountInfoDto queryAccountById(String accountId) {

        try {
            MerchantAccountInfoEntity accountInfoEntity = merchantAccountInfoEntityMapper.selectByPrimaryKey(accountId);
            if (accountInfoEntity == null)
                throw new ServiceException(ResultCodeConstant.ACCOUNT_NOT_EXIST);
            MerchantAccountInfoDto accountInfoDto = new MerchantAccountInfoDto();
            BeanCopierCacheUtil.copy(accountInfoEntity, accountInfoDto, null);
            return accountInfoDto;
        } catch (Exception e) {
            throw new DBException(e);
        }
    }
}
