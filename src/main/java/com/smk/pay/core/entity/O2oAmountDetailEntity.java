package com.smk.pay.core.entity;

import java.math.BigDecimal;
import java.util.Date;

public class O2oAmountDetailEntity {
    private String serialNo;

    private Date transDate;

    private String accountId;

    private String transType;

    private String direction;

    private BigDecimal amount;

    private String status;

    public O2oAmountDetailEntity() {

    }

    public O2oAmountDetailEntity(String serialNo, Date transDate, String accountId, String transType,
                                 String direction, BigDecimal amount, String status) {
        this.serialNo = serialNo;
        this.transDate = transDate;
        this.accountId = accountId;
        this.transType = transType;
        this.direction = direction;
        this.amount = amount;
        this.status = status;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}