package com.smk.pay.core.mapper;

import com.smk.pay.core.entity.O2oAmountDetailEntity;
import com.smk.pay.dal.condtion.EntityCondition;
import org.apache.ibatis.annotations.Mapper;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/14 13:48
 */
@Mapper
public interface O2oAmountDetailEntityMapper extends BaseEntityMapper<O2oAmountDetailEntity> {


    int querySumAmount(EntityCondition entityCondition);
}
