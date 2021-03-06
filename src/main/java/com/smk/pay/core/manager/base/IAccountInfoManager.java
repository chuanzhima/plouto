package com.smk.pay.core.manager.base;

import com.smk.pay.core.dto.AccountInfoDto;

import java.util.List;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/25 14:14
 */
public interface IAccountInfoManager {

    /**
     * 添加账户
     *
     * @param t
     * @return
     */
    String addAccount(AccountInfoDto t);

    /**
     * 更新账户状态
     *
     * @param accountId
     * @param oldStatus
     * @param newStatus
     * @return
     */
    int updateAccountStatus(String accountId, String oldStatus, String newStatus);


    /**
     * 更新账户级别
     *
     * @param accountId
     * @param oldLevel
     * @param newLevel
     * @return
     */
    int updateAccountLevel(String accountId, String oldLevel, String newLevel);

    /**
     * 更新金额
     *
     * @param accountId
     * @param oldAmount
     * @param newAmount
     * @return
     */
    int updateAccountAmount(String accountId, AccountInfoDto oldAmount, AccountInfoDto newAmount);

    /**
     * 更新状态和金额
     *
     * @param accountId
     * @param newStatus
     * @param newAmount
     * @return
     */
    int updateAccountAmountAndStatus(String accountId, String newStatus, AccountInfoDto newAmount);

    /**
     * 更新关联用户
     *
     * @param accountId
     * @param newUserId
     * @return
     */
    int updateUserId(String accountId, String newUserId);


    /**
     * 查询主账户信息
     *
     * @param userId 账户系统用户id
     * @return
     */
    AccountInfoDto queryMainAccountByUserId(String userId);

    /**
     * 查询主账户信息
     *
     * @param custId 用户系统用户id
     * @return
     */
    AccountInfoDto queryMainAccountByCustId(String custId);

    /**
     * 根据账户id查询账户信息
     *
     * @param accountId
     * @return
     */
    AccountInfoDto queryAccountById(String accountId);

    /**
     * 根据卡号查询账户信息
     * 如果绑定了市民卡，则会找到对应的主账户，即同queryMainAccountByUserId接口
     *
     * @param cardNo
     * @return
     */
    AccountInfoDto queryCardAccountByCardNo(String cardNo);

    /**
     * 根据用户id查询所有账户
     * 一个用户id可以绑定一个市民卡和多个其它卡，只有绑定市民卡才会做资金归集，其它卡不做归集
     *
     * @param userId
     * @param includeBinded 是否包含已经绑定的杭州市民卡
     * @return
     */
    List<AccountInfoDto> queryAccountsByUserId(String userId, boolean includeBinded);

}
