package com.smk.pay.core.mapper;

import com.smk.pay.core.entity.LnsAcctInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/14 21:06
 */
@Mapper
public interface LnsAcctInfoEntityMapper extends BaseEntityMapper<LnsAcctInfoEntity> {
    long selectAcctNoSequence();

    // 通过用户id和业务类型查询
    LnsAcctInfoEntity selectByUserIdAndType(String userId, String businessType);
}
