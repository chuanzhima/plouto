package com.smk.pay.core.entity;

import java.math.BigDecimal;

public class PubRateInfoEntity {
    private String merchantId;

    private String businessType;

    private String rateunit;

    private BigDecimal rateterm;

    private String eftdate;

    private BigDecimal rate;

    private BigDecimal rate1;

    private String ratetype;

    private String tbdesc;

    private BigDecimal freedays;

    private String status;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public String getRateunit() {
        return rateunit;
    }

    public void setRateunit(String rateunit) {
        this.rateunit = rateunit == null ? null : rateunit.trim();
    }

    public BigDecimal getRateterm() {
        return rateterm;
    }

    public void setRateterm(BigDecimal rateterm) {
        this.rateterm = rateterm;
    }

    public String getEftdate() {
        return eftdate;
    }

    public void setEftdate(String eftdate) {
        this.eftdate = eftdate == null ? null : eftdate.trim();
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate1() {
        return rate1;
    }

    public void setRate1(BigDecimal rate1) {
        this.rate1 = rate1;
    }

    public String getRatetype() {
        return ratetype;
    }

    public void setRatetype(String ratetype) {
        this.ratetype = ratetype == null ? null : ratetype.trim();
    }

    public String getTbdesc() {
        return tbdesc;
    }

    public void setTbdesc(String tbdesc) {
        this.tbdesc = tbdesc == null ? null : tbdesc.trim();
    }

    public BigDecimal getFreedays() {
        return freedays;
    }

    public void setFreedays(BigDecimal freedays) {
        this.freedays = freedays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}