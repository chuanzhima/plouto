package com.smk.pay.core.mapper;

import com.smk.pay.dal.condtion.EntityCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/19 14:44
 */
public interface BaseEntityMapper<T> {

    int count(EntityCondition condition);

    int delete(EntityCondition condition);

    int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectList(EntityCondition condition);

    T selectByPrimaryKey(String primaryKey);

    int updateSelective(@Param("record") T record, @Param("condition") EntityCondition condition);

    int update(@Param("record") T record, @Param("condition") EntityCondition condition);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
