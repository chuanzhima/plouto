package com.smk.pay.core.factory;

import com.smk.pay.account.core.enums.AccountFundFlowEnum;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.exception.ServiceException;
import com.smk.pay.core.manager.atom.ISettle;
import com.smk.pay.core.manager.atom.impl.SettleYHK4Merchant;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/19 20:32
 */
@Component(value = "settleFactory")
public class SettleFactory implements InitializingBean, ApplicationContextAware {

    private static ConcurrentHashMap<AccountFundFlowEnum, ISettle> SETTLE_MAP_4_MERCHANT =
            new ConcurrentHashMap<>();

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public ISettle getSettleBean(AccountFundFlowEnum fundFlowEnum) {
        ISettle settle = SETTLE_MAP_4_MERCHANT.get(fundFlowEnum);
        if (null == settle)
            throw new ServiceException(ResultCodeConstant.TRANS_TYPE_INCORRECT);
        return settle;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        SETTLE_MAP_4_MERCHANT.put(AccountFundFlowEnum.YHK, context.getBean(SettleYHK4Merchant.class));
    }

}
