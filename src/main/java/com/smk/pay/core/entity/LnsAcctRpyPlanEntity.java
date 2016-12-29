package com.smk.pay.core.entity;

import java.math.BigDecimal;
import java.util.Date;

public class LnsAcctRpyPlanEntity {
    private String rpyplanno;

    private String brc;

    private String acctno;

    private String subsection;

    private BigDecimal repayterm;

    private String subctrlcode;

    private String acctflag;

    private String originalSerialNo;

    private String originalTransDate;

    private String originalTransTime;

    private String reqSerialNo;

    private String reqTransDate;

    private String reqTransTime;

    private String merchantId;

    private Date transDate;

    private String repayownbdate;

    private String repayownedate;

    private String repayintbdate;

    private String repayintedate;

    private String aheaddate;

    private String termretdate;

    private BigDecimal termretprin;

    private BigDecimal termretint;

    private BigDecimal termtxint;

    private BigDecimal noretamt;

    private BigDecimal noretint;

    private BigDecimal termfint;

    private BigDecimal termcint;

    private BigDecimal termspeint;

    private BigDecimal retintamt;

    private BigDecimal days;

    private BigDecimal termcdint;

    private BigDecimal surpluscdint;

    private BigDecimal dayfint;

    private BigDecimal balance;

    private String status;

    private String cdflag;

    private String flag;

    private BigDecimal termmcfint;

    private BigDecimal termmccint;

    private BigDecimal daymcfint;

    private BigDecimal termmccdint;

    private String modifydate;

    private String modifytime;

    private String reserve1;

    private String rivalMerchantId;

    private String businessType;

    public String getRpyplanno() {
        return rpyplanno;
    }

    public void setRpyplanno(String rpyplanno) {
        this.rpyplanno = rpyplanno == null ? null : rpyplanno.trim();
    }

    public String getBrc() {
        return brc;
    }

    public void setBrc(String brc) {
        this.brc = brc == null ? null : brc.trim();
    }

    public String getAcctno() {
        return acctno;
    }

    public void setAcctno(String acctno) {
        this.acctno = acctno == null ? null : acctno.trim();
    }

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection == null ? null : subsection.trim();
    }

    public BigDecimal getRepayterm() {
        return repayterm;
    }

    public void setRepayterm(BigDecimal repayterm) {
        this.repayterm = repayterm;
    }

    public String getSubctrlcode() {
        return subctrlcode;
    }

    public void setSubctrlcode(String subctrlcode) {
        this.subctrlcode = subctrlcode == null ? null : subctrlcode.trim();
    }

    public String getAcctflag() {
        return acctflag;
    }

    public void setAcctflag(String acctflag) {
        this.acctflag = acctflag == null ? null : acctflag.trim();
    }

    public String getOriginalSerialNo() {
        return originalSerialNo;
    }

    public void setOriginalSerialNo(String originalSerialNo) {
        this.originalSerialNo = originalSerialNo == null ? null : originalSerialNo.trim();
    }

    public String getOriginalTransDate() {
        return originalTransDate;
    }

    public void setOriginalTransDate(String originalTransDate) {
        this.originalTransDate = originalTransDate == null ? null : originalTransDate.trim();
    }

    public String getOriginalTransTime() {
        return originalTransTime;
    }

    public void setOriginalTransTime(String originalTransTime) {
        this.originalTransTime = originalTransTime == null ? null : originalTransTime.trim();
    }

    public String getReqSerialNo() {
        return reqSerialNo;
    }

    public void setReqSerialNo(String reqSerialNo) {
        this.reqSerialNo = reqSerialNo == null ? null : reqSerialNo.trim();
    }

    public String getReqTransDate() {
        return reqTransDate;
    }

    public void setReqTransDate(String reqTransDate) {
        this.reqTransDate = reqTransDate == null ? null : reqTransDate.trim();
    }

    public String getReqTransTime() {
        return reqTransTime;
    }

    public void setReqTransTime(String reqTransTime) {
        this.reqTransTime = reqTransTime == null ? null : reqTransTime.trim();
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getRepayownbdate() {
        return repayownbdate;
    }

    public void setRepayownbdate(String repayownbdate) {
        this.repayownbdate = repayownbdate == null ? null : repayownbdate.trim();
    }

    public String getRepayownedate() {
        return repayownedate;
    }

    public void setRepayownedate(String repayownedate) {
        this.repayownedate = repayownedate == null ? null : repayownedate.trim();
    }

    public String getRepayintbdate() {
        return repayintbdate;
    }

    public void setRepayintbdate(String repayintbdate) {
        this.repayintbdate = repayintbdate == null ? null : repayintbdate.trim();
    }

    public String getRepayintedate() {
        return repayintedate;
    }

    public void setRepayintedate(String repayintedate) {
        this.repayintedate = repayintedate == null ? null : repayintedate.trim();
    }

    public String getAheaddate() {
        return aheaddate;
    }

    public void setAheaddate(String aheaddate) {
        this.aheaddate = aheaddate == null ? null : aheaddate.trim();
    }

    public String getTermretdate() {
        return termretdate;
    }

    public void setTermretdate(String termretdate) {
        this.termretdate = termretdate == null ? null : termretdate.trim();
    }

    public BigDecimal getTermretprin() {
        return termretprin;
    }

    public void setTermretprin(BigDecimal termretprin) {
        this.termretprin = termretprin;
    }

    public BigDecimal getTermretint() {
        return termretint;
    }

    public void setTermretint(BigDecimal termretint) {
        this.termretint = termretint;
    }

    public BigDecimal getTermtxint() {
        return termtxint;
    }

    public void setTermtxint(BigDecimal termtxint) {
        this.termtxint = termtxint;
    }

    public BigDecimal getNoretamt() {
        return noretamt;
    }

    public void setNoretamt(BigDecimal noretamt) {
        this.noretamt = noretamt;
    }

    public BigDecimal getNoretint() {
        return noretint;
    }

    public void setNoretint(BigDecimal noretint) {
        this.noretint = noretint;
    }

    public BigDecimal getTermfint() {
        return termfint;
    }

    public void setTermfint(BigDecimal termfint) {
        this.termfint = termfint;
    }

    public BigDecimal getTermcint() {
        return termcint;
    }

    public void setTermcint(BigDecimal termcint) {
        this.termcint = termcint;
    }

    public BigDecimal getTermspeint() {
        return termspeint;
    }

    public void setTermspeint(BigDecimal termspeint) {
        this.termspeint = termspeint;
    }

    public BigDecimal getRetintamt() {
        return retintamt;
    }

    public void setRetintamt(BigDecimal retintamt) {
        this.retintamt = retintamt;
    }

    public BigDecimal getDays() {
        return days;
    }

    public void setDays(BigDecimal days) {
        this.days = days;
    }

    public BigDecimal getTermcdint() {
        return termcdint;
    }

    public void setTermcdint(BigDecimal termcdint) {
        this.termcdint = termcdint;
    }

    public BigDecimal getSurpluscdint() {
        return surpluscdint;
    }

    public void setSurpluscdint(BigDecimal surpluscdint) {
        this.surpluscdint = surpluscdint;
    }

    public BigDecimal getDayfint() {
        return dayfint;
    }

    public void setDayfint(BigDecimal dayfint) {
        this.dayfint = dayfint;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCdflag() {
        return cdflag;
    }

    public void setCdflag(String cdflag) {
        this.cdflag = cdflag == null ? null : cdflag.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public BigDecimal getTermmcfint() {
        return termmcfint;
    }

    public void setTermmcfint(BigDecimal termmcfint) {
        this.termmcfint = termmcfint;
    }

    public BigDecimal getTermmccint() {
        return termmccint;
    }

    public void setTermmccint(BigDecimal termmccint) {
        this.termmccint = termmccint;
    }

    public BigDecimal getDaymcfint() {
        return daymcfint;
    }

    public void setDaymcfint(BigDecimal daymcfint) {
        this.daymcfint = daymcfint;
    }

    public BigDecimal getTermmccdint() {
        return termmccdint;
    }

    public void setTermmccdint(BigDecimal termmccdint) {
        this.termmccdint = termmccdint;
    }

    public String getModifydate() {
        return modifydate;
    }

    public void setModifydate(String modifydate) {
        this.modifydate = modifydate == null ? null : modifydate.trim();
    }

    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime == null ? null : modifytime.trim();
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    public String getRivalMerchantId() {
        return rivalMerchantId;
    }

    public void setRivalMerchantId(String rivalMerchantId) {
        this.rivalMerchantId = rivalMerchantId == null ? null : rivalMerchantId.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }
}