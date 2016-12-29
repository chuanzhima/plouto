package com.smk.pay.core.entity;

import java.math.BigDecimal;

public class MerchantLimitsEntity {
    private String merchantId;

    private BigDecimal creditLimit;

    private BigDecimal useLimit;

    private String status;

    private String businessType;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getUseLimit() {
        return useLimit;
    }

    public void setUseLimit(BigDecimal useLimit) {
        this.useLimit = useLimit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }
}