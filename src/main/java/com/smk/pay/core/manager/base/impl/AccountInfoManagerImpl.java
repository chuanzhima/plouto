package com.smk.pay.core.manager.base.impl;

import com.smk.pay.account.core.enums.AccountInfoStatusEnum;
import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.dto.AccountInfoDto;
import com.smk.pay.core.entity.AccountInfoEntity;
import com.smk.pay.core.entity.UserMappingEntity;
import com.smk.pay.core.exception.DBException;
import com.smk.pay.core.exception.ServiceException;
import com.smk.pay.core.manager.base.IAccountInfoManager;
import com.smk.pay.core.manager.base.IUserInfoManager;
import com.smk.pay.core.mapper.AccountInfoEntityMapper;
import com.smk.pay.core.mapper.UserMappingEntityMapper;
import com.smk.pay.core.utils.BeanCopierCacheUtil;
import com.smk.pay.core.utils.StringUtil;
import com.smk.pay.dal.condtion.Criteria;
import com.smk.pay.dal.condtion.EntityCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 个人账户管理
 * <p/>
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/25 14:17
 */
@Component(value = "accountInfoManager")
public class AccountInfoManagerImpl implements IAccountInfoManager {

    @Autowired
    private AccountInfoEntityMapper accountInfoEntityMapper;
    @Autowired
    private UserMappingEntityMapper userMappingEntityMapper;
    @Autowired
    private IUserInfoManager userInfoManager;


    @Override
    public String addAccount(AccountInfoDto accountInfoDto) {
        AccountInfoEntity accountInfoEntity = new AccountInfoEntity();
        try {
            BeanCopierCacheUtil.copy(accountInfoDto, accountInfoEntity, null);
            accountInfoEntityMapper.insertSelective(accountInfoEntity);
            return String.valueOf(accountInfoEntity.getAccountId());
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    @Override
    public int updateAccountStatus(String accountId, String oldStatus, String newStatus) {
        AccountInfoEntity accountInfoEntity = new AccountInfoEntity();
        accountInfoEntity.setStatus(newStatus);

        Criteria criteria = new Criteria().addCriterion("ACCOUNT_ID=", accountId, "ACCOUNT_ID").addCriterion
                ("STATUS=", oldStatus, "STATUS");
        try {
            int count = accountInfoEntityMapper.updateSelective(accountInfoEntity, new EntityCondition().addCriteria
                    (criteria));
            if (count != 1)
                throw new ServiceException(ResultCodeConstant.SYSTEM_ERROR_CONCURRENT);
            return count;
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    @Override
    public int updateAccountLevel(String accountId, String oldLevel, String newLevel) {
        try {
            AccountInfoEntity accountInfoEntity = new AccountInfoEntity();
            accountInfoEntity.setLastUpdateDate(new Date());
            accountInfoEntity.setAccountClass(newLevel);
            int count = accountInfoEntityMapper.updateSelective(accountInfoEntity, new EntityCondition
                    ().addCriteria(new Criteria().addCriterion("ACCOUNT_ID=", accountId,
                    "ACCOUNT_ID").addCriterion("ACCOUNT_CLASS=", oldLevel, "ACCOUNT_CLASS")));

            if (count != 1) {
                throw new ServiceException(ResultCodeConstant.SYSTEM_ERROR_CONCURRENT);
            }
            return count;
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    @Override
    public int updateAccountAmount(String accountId, AccountInfoDto oldAmount, AccountInfoDto newAmount) {
        try {

            newAmount.setLastUpdateDate(new Date());
            AccountInfoEntity accountInfoEntity = new AccountInfoEntity();
            Criteria criteria = new Criteria().addCriterion("ACCOUNT_ID=", accountId,
                    "ACCOUNT_ID");
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
            int updateCount = accountInfoEntityMapper.updateSelective(accountInfoEntity, new EntityCondition
                    ().addCriteria(criteria));
            if (updateCount != 1) {
                throw new ServiceException(ResultCodeConstant.SYSTEM_ERROR_CONCURRENT);
            }

            return updateCount;
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    @Override
    public int updateAccountAmountAndStatus(String accountId, String newStatus, AccountInfoDto newAmount) {
        newAmount.setLastUpdateDate(new Date());
        AccountInfoEntity accountInfoEntity = new AccountInfoEntity();
        BeanCopierCacheUtil.copy(newAmount, accountInfoEntity, null);
        accountInfoEntity.setStatus(newStatus);

        Criteria criteria = new Criteria().addCriterion("ACCOUNT_ID=", accountId,
                "ACCOUNT_ID");
        try {
            int count = accountInfoEntityMapper.updateSelective(accountInfoEntity, new EntityCondition
                    ().addCriteria(criteria));
            if (count != 1) {
                throw new ServiceException(ResultCodeConstant.SYSTEM_ERROR_CONCURRENT);
            }
            return count;
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    @Override
    public int updateUserId(String accountId, String newUserId) {

        try {
            AccountInfoEntity accountInfoEntity = new AccountInfoEntity();
            accountInfoEntity.setLastUpdateDate(new Date());
            accountInfoEntity.setUserId(newUserId);
            int count = accountInfoEntityMapper.updateSelective(accountInfoEntity, new EntityCondition
                    ().addCriteria(new Criteria().addCriterion("ACCOUNT_ID=", accountId,
                    "ACCOUNT_ID")));
            if (count != 1) {
                throw new ServiceException(ResultCodeConstant.SYSTEM_ERROR_CONCURRENT);
            }
            return count;
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    @Override
    public AccountInfoDto queryMainAccountByCustId(String custId) {
        String userId = userInfoManager.getUserIdByCustId(custId);
        if (StringUtil.isEmpty(userId))
            return null;
        return this.queryMainAccountByUserId(userId);
    }

    @Override
    public AccountInfoDto queryMainAccountByUserId(String userId) {
        Criteria criteria = new Criteria();
        criteria.addCriterion("USER_ID = ", userId, "USER_ID")
                .addCriterion("ACCOUNT_TYPE = ", AccountTypeEnum.ONLINE.value(), "ACCOUNT_TYPE");

        AccountInfoDto accountInfoDto = null;
        try {
            List<AccountInfoEntity> accountInfoEntityList = accountInfoEntityMapper.selectList(new
                    EntityCondition()
                    .addCriteria(criteria));
            if (CollectionUtils.isEmpty(accountInfoEntityList)) {
                return accountInfoDto;
            }
            accountInfoDto = new AccountInfoDto.Builder().build();
            AccountInfoEntity accountInfoEntity = accountInfoEntityList.get(0);
            BeanCopierCacheUtil.copy(accountInfoEntity, accountInfoDto, null);
        } catch (Exception e) {
            throw new DBException(e);
        }
        return accountInfoDto;
    }

    @Override
    public List<AccountInfoDto> queryAccountsByUserId(String userId, boolean includeBinded) {

        UserMappingEntity userMappingEntity = userMappingEntityMapper.getByCustId(userId);
        if (userMappingEntity == null)
            throw new ServiceException(ResultCodeConstant.USER_MAPPING_NOT_EXIST);

        List<AccountInfoDto> accountInfoDtoList = new ArrayList<>();
        List<String> status = Arrays.asList(AccountInfoStatusEnum.NORMAL.value());
        if (includeBinded) {
            status = Arrays.asList(AccountInfoStatusEnum.NORMAL.value(), AccountInfoStatusEnum.BINDED.value());
        }
        try {
            List<AccountInfoEntity> accountInfoEntityList = accountInfoEntityMapper.selectCardAccountByUserId
                    (status, userMappingEntity.getUserId());
            for (AccountInfoEntity entity : accountInfoEntityList) {
                AccountInfoDto accountInfoDto = new AccountInfoDto.Builder().build();
                BeanCopierCacheUtil.copy(entity, accountInfoDto, null);
                accountInfoDtoList.add(accountInfoDto);
            }
            return accountInfoDtoList;
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    @Override
    public AccountInfoDto queryAccountById(String accountId) {
        try {
            AccountInfoEntity accountInfoEntity = accountInfoEntityMapper.selectByPrimaryKey(accountId);
            if (accountInfoEntity == null)
                throw new ServiceException(ResultCodeConstant.ACCOUNT_NOT_EXIST);
            AccountInfoDto accountInfoDto = new AccountInfoDto.Builder().build();
            BeanCopierCacheUtil.copy(accountInfoEntity, accountInfoDto, null);
            return accountInfoDto;
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

    @Override
    public AccountInfoDto queryCardAccountByCardNo(String cardNo) {
        try {
            AccountInfoDto accountInfoDto = new AccountInfoDto.Builder().build();
            AccountInfoEntity accountInfoEntity = accountInfoEntityMapper.selectCardAccountByCardNo(cardNo);
            if (accountInfoEntity == null)
                throw new ServiceException(ResultCodeConstant.CARD_NOT_EXIST);
            BeanCopierCacheUtil.copy(accountInfoEntity, accountInfoDto, null);
            return accountInfoDto;
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new DBException(e);
        }
    }

}
