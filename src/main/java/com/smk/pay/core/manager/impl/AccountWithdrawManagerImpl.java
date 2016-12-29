package com.smk.pay.core.manager.impl;

import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountFundFlowEnum;
import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.request.RequestHeader;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.entity.AccSystemEntity;
import com.smk.pay.core.exception.DBException;
import com.smk.pay.core.exception.ServiceException;
import com.smk.pay.core.factory.WithdrawFactory;
import com.smk.pay.core.manager.IAccountWithdrawManager;
import com.smk.pay.core.manager.atom.IWithdraw;
import com.smk.pay.core.mapper.AccSystemEntityMapper;
import com.smk.pay.core.utils.StringUtil;
import com.smk.pay.core.validator.WithdrawValidator;
import com.smk.pay.dal.condtion.EntityCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/1 16:58
 */
@Service(value = "accountWithdrawManager")
public class AccountWithdrawManagerImpl implements IAccountWithdrawManager {

    @Autowired
    private WithdrawValidator withdrawValidator;
    @Autowired
    private AccSystemEntityMapper accSystemEntityMapper;
    @Autowired
    private WithdrawFactory withdrawFactory;

    @Transactional
    @Override
    public void withdraw(RequestHeader header, AccountChannelEnum channelEnum, String merchantId,
                         AccountTypeEnum typeEnum, String typeValue, AccountFundFlowEnum fundFlowEnum,
                         BigDecimal amount, String bankId) {

        /**
         * 校验账户是否存在及状态是否正常，不正常返回错误信息， 正常返回账户id
         */
        Map<Boolean, String> check = withdrawValidator.validate(header, typeEnum, typeValue, amount);
        if (check.containsKey(Boolean.FALSE)) {
            throw new ServiceException(check.get(Boolean.FALSE));
        }
        String accountId = check.get(Boolean.TRUE);
        List<AccSystemEntity> list;
        try {
            list = accSystemEntityMapper.selectList(new EntityCondition());
        } catch (Exception e) {
            throw new DBException(e);
        }
        if (CollectionUtils.isEmpty(list)) {
            throw new ServiceException(ResultCodeConstant.ACC_SYSTEM_NO_DATA);
        }
        String accDate = list.get(0).getAccDate();
        String sequence = StringUtil.randomSequence();
        /**
         * 根据不同的充值方式，选择不同的实现类充值
         */
        IWithdraw withdraw = withdrawFactory.getWithdrawBean(fundFlowEnum);
        withdraw.withdraw(sequence, accountId, amount, bankId, merchantId, accDate, header, new Date(), channelEnum);
    }
}
