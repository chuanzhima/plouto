package com.smk.pay.core.factory;

import com.smk.pay.account.core.enums.AccountFundFlowEnum;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.exception.ServiceException;
import com.smk.pay.core.manager.atom.IRecharge;
import com.smk.pay.core.manager.atom.impl.RechargeGGK;
import com.smk.pay.core.manager.atom.impl.RechargeYHK;
import com.smk.pay.core.manager.atom.impl.RechargeYHK4Merchant;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/8 14:42
 */
@Component(value = "rechargeFactory")
public class RechargeFactory implements InitializingBean, ApplicationContextAware {

    private static ConcurrentHashMap<AccountFundFlowEnum, IRecharge> RECHARGE_MAP =
            new ConcurrentHashMap<>();
    private static ConcurrentHashMap<AccountFundFlowEnum, IRecharge> RECHARG_EMAP_4_MERCHANT =
            new ConcurrentHashMap<>();

    private ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public IRecharge getRechargeBean(AccountFundFlowEnum fundFlowEnum) {
        return RECHARGE_MAP.get(fundFlowEnum);
    }

    public IRecharge getRechargeBean4Merchant(AccountFundFlowEnum fundFlowEnum) {
        IRecharge recharge = RECHARG_EMAP_4_MERCHANT.get(fundFlowEnum);
        if (null == recharge)
            throw new ServiceException(ResultCodeConstant.TRANS_TYPE_INCORRECT);

        return recharge;
    }

    public void afterPropertiesSet() throws Exception {
        RECHARGE_MAP.put(AccountFundFlowEnum.YHK, context.getBean(RechargeYHK.class));
        RECHARGE_MAP.put(AccountFundFlowEnum.TPP, context.getBean(RechargeYHK.class));
        RECHARGE_MAP.put(AccountFundFlowEnum.GGK, context.getBean(RechargeGGK.class));

        RECHARG_EMAP_4_MERCHANT.put(AccountFundFlowEnum.YHK, context.getBean(RechargeYHK4Merchant.class));
    }
}
