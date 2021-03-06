package com.smk.pay.core.manager.base.impl;

import com.smk.pay.core.dto.MerchantTransDetailDto;
import com.smk.pay.core.entity.MerchantTransDetailEntity;
import com.smk.pay.core.exception.DBException;
import com.smk.pay.core.manager.base.IMerchantTransDetailManager;
import com.smk.pay.core.mapper.MerchantTransDetailEntityMapper;
import com.smk.pay.core.utils.BeanCopierCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/19 20:02
 */
@Component(value = "merchantTransDetailManager")
public class MerchantTransDetailManagerImpl implements IMerchantTransDetailManager {

    @Autowired
    private MerchantTransDetailEntityMapper merchantTransDetailEntityMapper;

    @Override
    public int addTransDetail(MerchantTransDetailDto transDetailDto) {
        try {
            MerchantTransDetailEntity transDetailEntity = new MerchantTransDetailEntity();
            BeanCopierCacheUtil.copy(transDetailDto, transDetailEntity, null);
            return merchantTransDetailEntityMapper.insertSelective(transDetailEntity);
        } catch (Exception e) {
            throw new DBException(e);
        }
    }
}
