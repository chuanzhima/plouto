package com.smk.pay.core.entity;

import java.math.BigDecimal;

public class InternalAccountModifyDetailEntity {
    private String serialNo;

    private String internalAccountId;

    private BigDecimal amount;

    private String amountDir;

    private String accDate;

    public InternalAccountModifyDetailEntity() {

    }

    public InternalAccountModifyDetailEntity(String serialNo, String internalAccountId, BigDecimal amount, String amountDir, String accDate) {
        this.serialNo = serialNo;
        this.internalAccountId = internalAccountId;
        this.amount = amount;
        this.amountDir = amountDir;
        this.accDate = accDate;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public String getInternalAccountId() {
        return internalAccountId;
    }

    public void setInternalAccountId(String internalAccountId) {
        this.internalAccountId = internalAccountId == null ? null : internalAccountId.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAmountDir() {
        return amountDir;
    }

    public void setAmountDir(String amountDir) {
        this.amountDir = amountDir == null ? null : amountDir.trim();
    }

    public String getAccDate() {
        return accDate;
    }

    public void setAccDate(String accDate) {
        this.accDate = accDate == null ? null : accDate.trim();
    }
}