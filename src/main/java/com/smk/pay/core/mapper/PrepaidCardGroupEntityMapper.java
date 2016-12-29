package com.smk.pay.core.mapper;

import com.smk.pay.core.entity.PrepaidCardGroupEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/20 17:00
 */
@Mapper
public interface PrepaidCardGroupEntityMapper extends BaseEntityMapper<PrepaidCardGroupEntity> {


    int updateStatusByCardIdStatus(String cardId, String oldStatus, String newStatus);

    PrepaidCardGroupEntity queryGroupByCardNo(String cardNo);

    /**
     * 卡关联后，根据卡账户id查找主账户id
     *
     * @param cardAccountId
     * @return
     */
    String selectMainAccountIdByCardAccountId(String cardAccountId);

}
