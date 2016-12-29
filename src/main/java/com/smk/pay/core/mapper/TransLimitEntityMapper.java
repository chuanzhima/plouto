package com.smk.pay.core.mapper;

import com.smk.pay.core.entity.TransLimitEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/26 14:38
 */
@Mapper
public interface TransLimitEntityMapper extends BaseEntityMapper<TransLimitEntity> {

    List<TransLimitEntity> selectByTransType(@Param("transType") String transType);

}
