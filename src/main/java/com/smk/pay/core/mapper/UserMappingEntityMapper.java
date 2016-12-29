package com.smk.pay.core.mapper;

import com.smk.pay.core.entity.UserMappingEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/1 19:52
 */
@Mapper
public interface UserMappingEntityMapper {

    UserMappingEntity getByCustId(String custId);

    void updateByIdNo(String custId, String userName, String idNo);

    int insertSelective(UserMappingEntity record);
}
