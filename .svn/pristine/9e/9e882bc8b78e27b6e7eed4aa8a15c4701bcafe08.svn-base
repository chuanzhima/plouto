package com.smk.pay.core.manager.impl;

import com.smk.pay.account.core.enums.AccountBizEnum;
import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountFundFlowEnum;
import com.smk.pay.account.core.request.RequestHeader;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.entity.AccSystemEntity;
import com.smk.pay.core.exception.DBException;
import com.smk.pay.core.exception.ServiceException;
import com.smk.pay.core.factory.RechargeFactory;
import com.smk.pay.core.factory.SettleFactory;
import com.smk.pay.core.manager.IAccountSettleManager;
import com.smk.pay.core.manager.atom.IRecharge;
import com.smk.pay.core.manager.atom.ISettle;
import com.smk.pay.core.mapper.AccSystemEntityMapper;
import com.smk.pay.core.utils.StringUtil;
import com.smk.pay.core.validator.RechargeValidator;
import com.smk.pay.core.validator.SettleValidator;
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
 * Date 2016/12/19 20:57
 */
@Service("accountSettleManager")
public class AccountSettleManagerImpl implements IAccountSettleManager {

    @Autowired
    private SettleValidator settleValidator;
    @Autowired
    private RechargeValidator rechargeValidator;
    @Autowired
    private SettleFactory settleFactory;
    @Autowired
    private RechargeFactory rechargeFactory;
    @Autowired
    private AccSystemEntityMapper accSystemEntityMapper;

    @Transactional
    @Override
    public void settle4Merchant(RequestHeader header, AccountChannelEnum channelEnum, String merchantId,
                                AccountFundFlowEnum fundFlowEnum, BigDecimal amount, String bankId,
                                AccountBizEnum bizEnum) {

        Map<Boolean, String> check = settleValidator.validate4Merchant(header, merchantId);

        if (check.containsKey(Boolean.FALSE)) {
            throw new ServiceException(check.get(Boolean.FALSE));
        }
        String accountId = check.get(Boolean.TRUE);
        String accDate = this.queryAccDate();
        /**
         * 根据不同的充值方式，选择不同的实现类充值
         */
        ISettle settle = settleFactory.getSettleBean(fundFlowEnum);
        settle.settle(StringUtil.randomSequence(), accountId, amount, bankId, merchantId, accDate, header, new Date()
                , channelEnum, bizEnum);
    }

    @Transactional
    @Override
    public void agentPay(RequestHeader header, AccountChannelEnum channelEnum, String merchantId,
                         AccountFundFlowEnum fundFlowEnum, BigDecimal amount, String bankId, AccountBizEnum bizEnum) {

        Map<Boolean, String> check = rechargeValidator.validate4Merchant(header, merchantId);

        if (check.containsKey(Boolean.FALSE)) {
            throw new ServiceException(check.get(Boolean.FALSE));
        }
        String merchantAccountId = check.get(Boolean.TRUE);
        String accDate = this.queryAccDate();
        String sequence = StringUtil.randomSequence();
        // 先充值后结算
        IRecharge recharge = rechargeFactory.getRechargeBean4Merchant(fundFlowEnum);
        recharge.recharge(sequence, merchantAccountId, amount, bankId, merchantId, accDate, header, new Date(), channelEnum);

        this.settle4Merchant(header, channelEnum, merchantId, fundFlowEnum, amount, bankId, bizEnum);
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
