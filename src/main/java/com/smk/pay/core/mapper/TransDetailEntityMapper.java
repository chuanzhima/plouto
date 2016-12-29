package com.smk.pay.core.mapper;

import com.smk.pay.core.entity.TransDetailEntity;
import com.smk.pay.dal.condtion.EntityCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/20 17:01
 */
@Mapper
public interface TransDetailEntityMapper extends BaseEntityMapper<TransDetailEntity> {

    TransDetailEntity selectSumAmount(EntityCondition condition);

    List<TransDetailEntity> queryTransDetail(EntityCondition condition);

    TransDetailEntity selectOne(EntityCondition condition);

}
