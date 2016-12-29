package com.smk.pay.core.mapper;

import com.smk.pay.core.entity.OperationDetailEntity;
import com.smk.pay.dal.condtion.EntityCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/22 15:37
 */
@Mapper
public interface OperationDetailEntityMapper extends BaseEntityMapper<OperationDetailEntity> {

    List<OperationDetailEntity> queryOperationDetail(EntityCondition condition);
}
