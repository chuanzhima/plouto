package com.smk.pay.core.mapper;

import com.smk.pay.core.entity.AccountInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 账户信息Mapper接口类
 */
@Mapper
public interface AccountInfoEntityMapper extends BaseEntityMapper<AccountInfoEntity> {

    AccountInfoEntity selectCardAccountByCardNo(String cardNo);

    /**
     * 查询卡号和账户信息
     * 注意，为了避免重新定义返回map,暂时将不常用的字段user_defind_mark映射成卡号放置其中
     *
     * @param statusList
     * @param userId
     * @return
     */
    List<AccountInfoEntity> selectCardAccountByUserId(@Param("status") List<String> statusList, @Param("userId") String
            userId);

}