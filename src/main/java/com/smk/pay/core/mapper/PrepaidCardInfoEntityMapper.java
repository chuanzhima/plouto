package com.smk.pay.core.mapper;

import com.smk.pay.core.entity.PrepaidCardInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/20 17:00
 */
@Mapper
public interface PrepaidCardInfoEntityMapper extends BaseEntityMapper<PrepaidCardInfoEntity> {

    PrepaidCardInfoEntity selectByCardNo(String cardNo);

    PrepaidCardInfoEntity selectByUserIdAndCardType(@Param("userId") String userId, @Param("cardType") String cardType);
}
