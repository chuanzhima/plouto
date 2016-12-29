package com.smk.pay.core.manager.impl;

import com.smk.pay.account.core.enums.AccountBizEnum;
import com.smk.pay.account.core.enums.AccountChannelEnum;
import com.smk.pay.account.core.enums.AccountTypeEnum;
import com.smk.pay.account.core.request.RequestHeader;
import com.smk.pay.core.constant.ResultCodeConstant;
import com.smk.pay.core.entity.AccSystemEntity;
import com.smk.pay.core.exception.DBException;
import com.smk.pay.core.exception.ServiceException;
import com.smk.pay.core.factory.ConsumeFactory;
import com.smk.pay.core.manager.IAccountConsumeManager;
import com.smk.pay.core.manager.atom.IConsume;
import com.smk.pay.core.mapper.AccSystemEntityMapper;
import com.smk.pay.core.utils.StringUtil;
import com.smk.pay.core.validator.ConsumeValiator;
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
 * Date 2016/11/30 11:49
 */
@Service(value = "accountConsumeManager")
public class AccountConsumeManagerImpl implements IAccountConsumeManager {

    @Autowired
    private ConsumeValiator consumeValiator;
    @Autowired
    private ConsumeFactory consumeFactory;
    @Autowired
    private AccSystemEntityMapper accSystemEntityMapper;

    @Transactional
    @Override
    public void consume(RequestHeader header, AccountChannelEnum channelEnum, AccountBizEnum bizEnum, String merchantId,
                        AccountTypeEnum typeEnum, String typeValue, BigDecimal amount, BigDecimal cost,
                        Map<String, Object> extraParam) {

        /**
         * 校验账户是否存在及状态是否正常，不正常返回错误信息， 正常返回账户id
         */
        Map<Boolean, String> check = consumeValiator.validate(header, typeEnum, typeValue, amount);
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
         * 根据不同的业务类型，选择不同的消费实现类
         */
        IConsume consume = consumeFactory.getConsumeBean(bizEnum);
        consume.consume(sequence, accDate, new Date(), header, channelEnum, merchantId, accountId, amount,
                cost, extraParam);
    }
}
