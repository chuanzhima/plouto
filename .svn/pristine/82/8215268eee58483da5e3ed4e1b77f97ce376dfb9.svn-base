package com.smk.pay.core.enums;

/**
 * 参考trans_function表
 * <p/>
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/11/10 17:27
 */
public enum AccountTransTypeEnum {

    RECHARGE("01", "账户充值"),

    CONSUME("04", "消费"),

    OPEN_ACCOUNT("09", "开户"),

    WITHDRAW("10", "提现"),

    ALTER_ACCOUNT_LEVEL("11", "变更账户等级"),

    // 对应原来的用户注册
    ONLINE_USER_OPEN_ACCOUNT("12", "互联网用户开户"),

    PREPAID_CARD_BIND("15", "预付卡绑定"),

    INTERNAL_TRANSFER("23", "内部转账"),

    TRANS_REVERSE("26", "冲正"),

    PREPAID_CARD_MOVE("36", "预付卡迁移"),

    PREPAID_CARD_RELATE("41", "预付卡关联"),

    MERCHANT_RECHARGE("45", "对公账户充值"),

    MERCHANT_SETTLE("47", "对公账户结算"),

    CREDIT_OPEN("49", "信用开通"),

    PRIVATE_2_PUBLIC_TRANSFER("52", "私对公转账");

    private String key;

    private String value;

    AccountTransTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static AccountTransTypeEnum get(String key) {
        AccountTransTypeEnum[] transTypeEnums = AccountTransTypeEnum.values();
        for (AccountTransTypeEnum transTypeEnum : transTypeEnums) {
            if (transTypeEnum.key().equals(key)) {
                return transTypeEnum;
            }
        }
        return null;
    }

    public String key() {
        return this.key;
    }

    public String value() {
        return this.value;
    }
}
