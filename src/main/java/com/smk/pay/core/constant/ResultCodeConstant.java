package com.smk.pay.core.constant;

/**
 * 参考channel_err_code表
 * <p/>
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/26 20:37
 */
public final class ResultCodeConstant {

    /**
     * 成功
     */
    public static final String SUCCESS = "00";
    /**
     * 参数校验失败
     */
    public static final String PARAMETER_INVALID = "01";
    /**
     * 当前账户不存在
     */
    public static final String ACCOUNT_NOT_EXIST = "16";
    /**
     * 内部账户数据异常（系统内部异常）
     */
    public static final String INTERNAL_ACCOUNT_DATA_EXCEPTION = "02";
    /**
     * 系统配置数据不存在（系统内部异常）
     */
    public static final String ACC_SYSTEM_NO_DATA = "02";
    /**
     * 线下转线上额度超限
     */
    public static final String OFFLINE_2_ONLINE_AMOUNT_EXCEED = "J7";
    /**
     * 交易流水号重复
     */
    public static final String REPEAT_TRANS_SEQUENCE_NO = "J8";
    /**
     * 无效的充值类型
     */
    public static final String INVALID_RECHARGE_TYPE = "03";
    /**
     * 余额不足
     */
    public static final String NOT_ENOUGH_BALANCE = "51";
    /**
     * 原交易不存在
     */
    public static final String ORIGINAL_TRANS_NOT_EXIST = "31";

    /**
     * 原交易已冲正
     */
    public static final String TRANS_DETAIL_STATUS_HAS_REVERSED = "H6";

    /**
     * 原交易状态不正常
     */
    public static final String TRANS_DETAIL_STATUS_INVALID = "K1";

    /**
     * 对公账户余额不足
     */
    public static final String MERCHANT_ACCOUNT_NOT_ENOUGH_BALANCE = "10";
    /**
     * 无效交易
     */
    public static final String INVALID_TRANS = "12";

    // account status related
    public static final String ACCOUNT_STATUS_PREFIX = "ACCOUNT_STATUS_";
    /**
     * 账户状态无效
     */
    public static final String ACCOUNT_STATUS_INVALID = "17";

    /**
     * 当前账户等级未变更
     */
    public static final String ACCOUNT_LEVEL_NOCHANGE = "08";
    /**
     * 内部账户余额不足
     */
    public static final String INTERNAL_ACCOUNT_NOT_ENOUGH = "09";

    /**
     * 系统处理异常
     */
    public static final String SYSTEM_ERROR = "02";
    /**
     * 并发操作失败
     */
    public static final String SYSTEM_ERROR_CONCURRENT = "04";
    /**
     * 查询记录过多
     */
    public static final String QUERY_RECORDS_TOO_MUCH = "05";
    /**
     * 该卡无法进行刮刮卡充值交易
     */
    public static final String GGK_RECHARGE_FORBIDDEN = "06";
    /**
     * 年交易金额超限
     */
    public static final String YEAR_TRANS_AMOUNT_EXCEED = "7A";
    /**
     * 用户映射关系不存在
     */
    public static final String USER_MAPPING_NOT_EXIST = "07";
    /**
     * 账户金额无法完成此交易
     */
    public static final String AMOUNT_CAN_NOT_SUPPORT_TRANS = "J9";

    /**
     * 卡号已开卡，不能重复开卡
     */
    public static final String REPEAT_ADD_CARD = "F8";

    /**
     * 卡号不存在
     */
    public static final String CARD_NOT_EXIST = "14";
    /**
     * 用户未绑定市民卡
     */
    public static final String USER_NOT_BIND_CARD = "K3";
    /**
     * 该用户已开通信用支付
     */
    public static final String USER_HAS_OPENED_CREDIT = "K4";
    /**
     * 用户名和卡中预存证件信息不一致，不能开通
     */
    public static final String USER_NAME_DIFFERENT_WITH_CARD = "K5";
    /**
     * 手机号和卡中预存证件信息不一致，不能开通
     */
    public static final String PHONE_DIFFERENT_WITH_CARD = "K6";
    /**
     * 用户证件号码和卡中预存证件信息不一致，不能绑定
     */
    public static final String ID_NO_DIFFERENT_WITH_CARD = "G7";

    /**
     * 卡状态不正常
     */
    public static final String CARD_STATUS_INVALID = "19";
    /**
     * 用户不存在
     */
    public static final String USER_NOT_EXIST = "18";
    /**
     * 交易类型不正确
     */
    public static final String TRANS_TYPE_INCORRECT = "H9";
    /**
     * 单笔交易金额超限
     */
    public static final String TRANS_LIMITS_SINGLE_TIME_AMOUNT = "7E";
    /**
     * 单日交易金额超限
     */
    public static final String TRANS_LIMITS_SINGLE_DAY_AMOUNT = "7F";
    /**
     * 单日交易次数超限
     */
    public static final String TRANS_LIMITS_SINGLE_DAY_TIMES = "7G";
    /**
     * 累计交易金额超限
     */
    public static final String TRANS_LIMITS_SUM_AMOUNT = "7H";


}
