package com.smk.pay.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/21 10:10
 */
public class LnsAcctInfoDto implements Serializable {

    /**
     * 正常状态
     */
    public static final String STATUS_NORMAL = "1";
    /**
     * 身份证
     */
    public static final String CREDENTIAL_TYPE_ID = "1";
    /**
     * 贷款状态 - 正常
     */
    public static final String LOAN_STATUS_NORMAL = "01";
    /**
     * 是否有卡关联 - 是
     */
    public static final String CRDFLAG_YES = "1";

    /**
     * 贷款发放标识 - 已发放
     */
    public static final String ISSUE_FLAG_YES = "1";


    private String userId;

    private String businessType;

    private String acctno;

    private String acctype;

    private String acctstat;

    private String userName;

    private String papersType;

    private String papersNo;

    private String phoneNo;

    private String prdcode;

    private String corpcode;

    private String guarway;

    private String loantype;

    private String loankind;

    private String loanstatus;

    private String openbrc;

    private String profitbrc;

    private String crdflag;

    private String crdno;

    private Date beginintdate;

    private String periodunit;

    private String openterm;

    private String loanterm;

    private String gracedays;

    private String contduedate;

    private String currduedate;

    private String intrateplan;

    private String dbacct;

    private String fundsource;

    private String contrasctno;

    private BigDecimal contractamt;

    private String issueflag;

    private BigDecimal totissueamt;

    private BigDecimal normalrate;

    private BigDecimal overduerate;

    private BigDecimal overduerate1;

    private String bald;

    private String ratetype;

    private String feerate;

    private String feerate1;

    private String feerate2;

    private String feerate3;

    private String createSerialNo;

    private String cancelSerialNo;

    private Date createDate;

    private Date lastUpdateDate;

    private Date cancelDate;

    private String immediatelySum;

    private Date opendate;

    private Date enddate;

    private BigDecimal integral;

    private String userDefindMark;

    private String companyId;

    private String currentTime;

    private BigDecimal amount1;

    private BigDecimal amount2;

    private BigDecimal amount3;

    private BigDecimal amount4;

    private BigDecimal amount5;

    private BigDecimal amount6;

    private BigDecimal amount7;

    private BigDecimal amount8;

    private BigDecimal amount9;

    private BigDecimal amount10;


    public LnsAcctInfoDto() {

    }

    private LnsAcctInfoDto(Builder builder) {
        setUserId(builder.userId);
        setBusinessType(builder.businessType);
        setAcctno(builder.acctno);
        setAcctype(builder.acctype);
        setAcctstat(builder.acctstat);
        setUserName(builder.userName);
        setPapersType(builder.papersType);
        setPapersNo(builder.papersNo);
        setPhoneNo(builder.phoneNo);
        setPrdcode(builder.prdcode);
        setCorpcode(builder.corpcode);
        setGuarway(builder.guarway);
        setLoantype(builder.loantype);
        setLoankind(builder.loankind);
        setLoanstatus(builder.loanstatus);
        setOpenbrc(builder.openbrc);
        setProfitbrc(builder.profitbrc);
        setCrdflag(builder.crdflag);
        setCrdno(builder.crdno);
        setBeginintdate(builder.beginintdate);
        setPeriodunit(builder.periodunit);
        setOpenterm(builder.openterm);
        setLoanterm(builder.loanterm);
        setGracedays(builder.gracedays);
        setContduedate(builder.contduedate);
        setCurrduedate(builder.currduedate);
        setIntrateplan(builder.intrateplan);
        setDbacct(builder.dbacct);
        setFundsource(builder.fundsource);
        setContrasctno(builder.contrasctno);
        setContractamt(builder.contractamt);
        setIssueflag(builder.issueflag);
        setTotissueamt(builder.totissueamt);
        setNormalrate(builder.normalrate);
        setOverduerate(builder.overduerate);
        setOverduerate1(builder.overduerate1);
        setBald(builder.bald);
        setRatetype(builder.ratetype);
        setFeerate(builder.feerate);
        setFeerate1(builder.feerate1);
        setFeerate2(builder.feerate2);
        setFeerate3(builder.feerate3);
        setCreateSerialNo(builder.createSerialNo);
        setCancelSerialNo(builder.cancelSerialNo);
        setCreateDate(builder.createDate);
        setLastUpdateDate(builder.lastUpdateDate);
        setCancelDate(builder.cancelDate);
        setImmediatelySum(builder.immediatelySum);
        setOpendate(builder.opendate);
        setEnddate(builder.enddate);
        setIntegral(builder.integral);
        setUserDefindMark(builder.userDefindMark);
        setCompanyId(builder.companyId);
        setCurrentTime(builder.currentTime);
        setAmount1(builder.amount1);
        setAmount2(builder.amount2);
        setAmount3(builder.amount3);
        setAmount4(builder.amount4);
        setAmount5(builder.amount5);
        setAmount6(builder.amount6);
        setAmount7(builder.amount7);
        setAmount8(builder.amount8);
        setAmount9(builder.amount9);
        setAmount10(builder.amount10);
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getAcctno() {
        return acctno;
    }

    public void setAcctno(String acctno) {
        this.acctno = acctno;
    }

    public String getAcctype() {
        return acctype;
    }

    public void setAcctype(String acctype) {
        this.acctype = acctype;
    }

    public String getAcctstat() {
        return acctstat;
    }

    public void setAcctstat(String acctstat) {
        this.acctstat = acctstat;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPapersType() {
        return papersType;
    }

    public void setPapersType(String papersType) {
        this.papersType = papersType;
    }

    public String getPapersNo() {
        return papersNo;
    }

    public void setPapersNo(String papersNo) {
        this.papersNo = papersNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPrdcode() {
        return prdcode;
    }

    public void setPrdcode(String prdcode) {
        this.prdcode = prdcode;
    }

    public String getCorpcode() {
        return corpcode;
    }

    public void setCorpcode(String corpcode) {
        this.corpcode = corpcode;
    }

    public String getGuarway() {
        return guarway;
    }

    public void setGuarway(String guarway) {
        this.guarway = guarway;
    }

    public String getLoantype() {
        return loantype;
    }

    public void setLoantype(String loantype) {
        this.loantype = loantype;
    }

    public String getLoankind() {
        return loankind;
    }

    public void setLoankind(String loankind) {
        this.loankind = loankind;
    }

    public String getLoanstatus() {
        return loanstatus;
    }

    public void setLoanstatus(String loanstatus) {
        this.loanstatus = loanstatus;
    }

    public String getOpenbrc() {
        return openbrc;
    }

    public void setOpenbrc(String openbrc) {
        this.openbrc = openbrc;
    }

    public String getProfitbrc() {
        return profitbrc;
    }

    public void setProfitbrc(String profitbrc) {
        this.profitbrc = profitbrc;
    }

    public String getCrdflag() {
        return crdflag;
    }

    public void setCrdflag(String crdflag) {
        this.crdflag = crdflag;
    }

    public String getCrdno() {
        return crdno;
    }

    public void setCrdno(String crdno) {
        this.crdno = crdno;
    }

    public Date getBeginintdate() {
        return beginintdate;
    }

    public void setBeginintdate(Date beginintdate) {
        this.beginintdate = beginintdate;
    }

    public String getPeriodunit() {
        return periodunit;
    }

    public void setPeriodunit(String periodunit) {
        this.periodunit = periodunit;
    }

    public String getOpenterm() {
        return openterm;
    }

    public void setOpenterm(String openterm) {
        this.openterm = openterm;
    }

    public String getLoanterm() {
        return loanterm;
    }

    public void setLoanterm(String loanterm) {
        this.loanterm = loanterm;
    }

    public String getGracedays() {
        return gracedays;
    }

    public void setGracedays(String gracedays) {
        this.gracedays = gracedays;
    }

    public String getContduedate() {
        return contduedate;
    }

    public void setContduedate(String contduedate) {
        this.contduedate = contduedate;
    }

    public String getCurrduedate() {
        return currduedate;
    }

    public void setCurrduedate(String currduedate) {
        this.currduedate = currduedate;
    }

    public String getIntrateplan() {
        return intrateplan;
    }

    public void setIntrateplan(String intrateplan) {
        this.intrateplan = intrateplan;
    }

    public String getDbacct() {
        return dbacct;
    }

    public void setDbacct(String dbacct) {
        this.dbacct = dbacct;
    }

    public String getFundsource() {
        return fundsource;
    }

    public void setFundsource(String fundsource) {
        this.fundsource = fundsource;
    }

    public String getContrasctno() {
        return contrasctno;
    }

    public void setContrasctno(String contrasctno) {
        this.contrasctno = contrasctno;
    }

    public BigDecimal getContractamt() {
        return contractamt;
    }

    public void setContractamt(BigDecimal contractamt) {
        this.contractamt = contractamt;
    }

    public String getIssueflag() {
        return issueflag;
    }

    public void setIssueflag(String issueflag) {
        this.issueflag = issueflag;
    }

    public BigDecimal getTotissueamt() {
        return totissueamt;
    }

    public void setTotissueamt(BigDecimal totissueamt) {
        this.totissueamt = totissueamt;
    }

    public BigDecimal getNormalrate() {
        return normalrate;
    }

    public void setNormalrate(BigDecimal normalrate) {
        this.normalrate = normalrate;
    }

    public BigDecimal getOverduerate() {
        return overduerate;
    }

    public void setOverduerate(BigDecimal overduerate) {
        this.overduerate = overduerate;
    }

    public BigDecimal getOverduerate1() {
        return overduerate1;
    }

    public void setOverduerate1(BigDecimal overduerate1) {
        this.overduerate1 = overduerate1;
    }

    public String getBald() {
        return bald;
    }

    public void setBald(String bald) {
        this.bald = bald;
    }

    public String getRatetype() {
        return ratetype;
    }

    public void setRatetype(String ratetype) {
        this.ratetype = ratetype;
    }

    public String getFeerate() {
        return feerate;
    }

    public void setFeerate(String feerate) {
        this.feerate = feerate;
    }

    public String getFeerate1() {
        return feerate1;
    }

    public void setFeerate1(String feerate1) {
        this.feerate1 = feerate1;
    }

    public String getFeerate2() {
        return feerate2;
    }

    public void setFeerate2(String feerate2) {
        this.feerate2 = feerate2;
    }

    public String getFeerate3() {
        return feerate3;
    }

    public void setFeerate3(String feerate3) {
        this.feerate3 = feerate3;
    }

    public String getCreateSerialNo() {
        return createSerialNo;
    }

    public void setCreateSerialNo(String createSerialNo) {
        this.createSerialNo = createSerialNo;
    }

    public String getCancelSerialNo() {
        return cancelSerialNo;
    }

    public void setCancelSerialNo(String cancelSerialNo) {
        this.cancelSerialNo = cancelSerialNo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getImmediatelySum() {
        return immediatelySum;
    }

    public void setImmediatelySum(String immediatelySum) {
        this.immediatelySum = immediatelySum;
    }

    public Date getOpendate() {
        return opendate;
    }

    public void setOpendate(Date opendate) {
        this.opendate = opendate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    public String getUserDefindMark() {
        return userDefindMark;
    }

    public void setUserDefindMark(String userDefindMark) {
        this.userDefindMark = userDefindMark;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public BigDecimal getAmount1() {
        return amount1;
    }

    public void setAmount1(BigDecimal amount1) {
        this.amount1 = amount1;
    }

    public BigDecimal getAmount2() {
        return amount2;
    }

    public void setAmount2(BigDecimal amount2) {
        this.amount2 = amount2;
    }

    public BigDecimal getAmount3() {
        return amount3;
    }

    public void setAmount3(BigDecimal amount3) {
        this.amount3 = amount3;
    }

    public BigDecimal getAmount4() {
        return amount4;
    }

    public void setAmount4(BigDecimal amount4) {
        this.amount4 = amount4;
    }

    public BigDecimal getAmount5() {
        return amount5;
    }

    public void setAmount5(BigDecimal amount5) {
        this.amount5 = amount5;
    }

    public BigDecimal getAmount6() {
        return amount6;
    }

    public void setAmount6(BigDecimal amount6) {
        this.amount6 = amount6;
    }

    public BigDecimal getAmount7() {
        return amount7;
    }

    public void setAmount7(BigDecimal amount7) {
        this.amount7 = amount7;
    }

    public BigDecimal getAmount8() {
        return amount8;
    }

    public void setAmount8(BigDecimal amount8) {
        this.amount8 = amount8;
    }

    public BigDecimal getAmount9() {
        return amount9;
    }

    public void setAmount9(BigDecimal amount9) {
        this.amount9 = amount9;
    }

    public BigDecimal getAmount10() {
        return amount10;
    }

    public void setAmount10(BigDecimal amount10) {
        this.amount10 = amount10;
    }

    public static final class Builder {
        private String userId;
        private String businessType;
        private String acctno;
        private String acctype;
        private String acctstat;
        private String userName;
        private String papersType;
        private String papersNo;
        private String phoneNo;
        private String prdcode;
        private String corpcode;
        private String guarway;
        private String loantype;
        private String loankind;
        private String loanstatus;
        private String openbrc;
        private String profitbrc;
        private String crdflag;
        private String crdno;
        private Date beginintdate;
        private String periodunit;
        private String openterm;
        private String loanterm;
        private String gracedays;
        private String contduedate;
        private String currduedate;
        private String intrateplan;
        private String dbacct;
        private String fundsource;
        private String contrasctno;
        private BigDecimal contractamt;
        private String issueflag;
        private BigDecimal totissueamt;
        private BigDecimal normalrate;
        private BigDecimal overduerate;
        private BigDecimal overduerate1;
        private String bald;
        private String ratetype;
        private String feerate;
        private String feerate1;
        private String feerate2;
        private String feerate3;
        private String createSerialNo;
        private String cancelSerialNo;
        private Date createDate;
        private Date lastUpdateDate;
        private Date cancelDate;
        private String immediatelySum;
        private Date opendate;
        private Date enddate;
        private BigDecimal integral;
        private String userDefindMark;
        private String companyId;
        private String currentTime;
        private BigDecimal amount1;
        private BigDecimal amount2;
        private BigDecimal amount3;
        private BigDecimal amount4;
        private BigDecimal amount5;
        private BigDecimal amount6;
        private BigDecimal amount7;
        private BigDecimal amount8;
        private BigDecimal amount9;
        private BigDecimal amount10;

        public Builder() {
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder businessType(String businessType) {
            this.businessType = businessType;
            return this;
        }

        public Builder acctno(String acctno) {
            this.acctno = acctno;
            return this;
        }

        public Builder acctype(String acctype) {
            this.acctype = acctype;
            return this;
        }

        public Builder acctstat(String acctstat) {
            this.acctstat = acctstat;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder papersType(String papersType) {
            this.papersType = papersType;
            return this;
        }

        public Builder papersNo(String papersNo) {
            this.papersNo = papersNo;
            return this;
        }

        public Builder phoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public Builder prdcode(String prdcode) {
            this.prdcode = prdcode;
            return this;
        }

        public Builder corpcode(String corpcode) {
            this.corpcode = corpcode;
            return this;
        }

        public Builder guarway(String guarway) {
            this.guarway = guarway;
            return this;
        }

        public Builder loantype(String loantype) {
            this.loantype = loantype;
            return this;
        }

        public Builder loankind(String loankind) {
            this.loankind = loankind;
            return this;
        }

        public Builder loanstatus(String loanstatus) {
            this.loanstatus = loanstatus;
            return this;
        }

        public Builder openbrc(String openbrc) {
            this.openbrc = openbrc;
            return this;
        }

        public Builder profitbrc(String profitbrc) {
            this.profitbrc = profitbrc;
            return this;
        }

        public Builder crdflag(String crdflag) {
            this.crdflag = crdflag;
            return this;
        }

        public Builder crdno(String crdno) {
            this.crdno = crdno;
            return this;
        }

        public Builder beginintdate(Date beginintdate) {
            this.beginintdate = beginintdate;
            return this;
        }

        public Builder periodunit(String periodunit) {
            this.periodunit = periodunit;
            return this;
        }

        public Builder openterm(String openterm) {
            this.openterm = openterm;
            return this;
        }

        public Builder loanterm(String loanterm) {
            this.loanterm = loanterm;
            return this;
        }

        public Builder gracedays(String gracedays) {
            this.gracedays = gracedays;
            return this;
        }

        public Builder contduedate(String contduedate) {
            this.contduedate = contduedate;
            return this;
        }

        public Builder currduedate(String currduedate) {
            this.currduedate = currduedate;
            return this;
        }

        public Builder intrateplan(String intrateplan) {
            this.intrateplan = intrateplan;
            return this;
        }

        public Builder dbacct(String dbacct) {
            this.dbacct = dbacct;
            return this;
        }

        public Builder fundsource(String fundsource) {
            this.fundsource = fundsource;
            return this;
        }

        public Builder contrasctno(String contrasctno) {
            this.contrasctno = contrasctno;
            return this;
        }

        public Builder contractamt(BigDecimal contractamt) {
            this.contractamt = contractamt;
            return this;
        }

        public Builder issueflag(String issueflag) {
            this.issueflag = issueflag;
            return this;
        }

        public Builder totissueamt(BigDecimal totissueamt) {
            this.totissueamt = totissueamt;
            return this;
        }

        public Builder normalrate(BigDecimal normalrate) {
            this.normalrate = normalrate;
            return this;
        }

        public Builder overduerate(BigDecimal overduerate) {
            this.overduerate = overduerate;
            return this;
        }

        public Builder overduerate1(BigDecimal overduerate1) {
            this.overduerate1 = overduerate1;
            return this;
        }

        public Builder bald(String bald) {
            this.bald = bald;
            return this;
        }

        public Builder ratetype(String ratetype) {
            this.ratetype = ratetype;
            return this;
        }

        public Builder feerate(String feerate) {
            this.feerate = feerate;
            return this;
        }

        public Builder feerate1(String feerate1) {
            this.feerate1 = feerate1;
            return this;
        }

        public Builder feerate2(String feerate2) {
            this.feerate2 = feerate2;
            return this;
        }

        public Builder feerate3(String feerate3) {
            this.feerate3 = feerate3;
            return this;
        }

        public Builder createSerialNo(String createSerialNo) {
            this.createSerialNo = createSerialNo;
            return this;
        }

        public Builder cancelSerialNo(String cancelSerialNo) {
            this.cancelSerialNo = cancelSerialNo;
            return this;
        }

        public Builder createDate(Date createDate) {
            this.createDate = createDate;
            return this;
        }

        public Builder lastUpdateDate(Date lastUpdateDate) {
            this.lastUpdateDate = lastUpdateDate;
            return this;
        }

        public Builder cancelDate(Date cancelDate) {
            this.cancelDate = cancelDate;
            return this;
        }

        public Builder immediatelySum(String immediatelySum) {
            this.immediatelySum = immediatelySum;
            return this;
        }

        public Builder opendate(Date opendate) {
            this.opendate = opendate;
            return this;
        }

        public Builder enddate(Date enddate) {
            this.enddate = enddate;
            return this;
        }

        public Builder integral(BigDecimal integral) {
            this.integral = integral;
            return this;
        }

        public Builder userDefindMark(String userDefindMark) {
            this.userDefindMark = userDefindMark;
            return this;
        }

        public Builder companyId(String companyId) {
            this.companyId = companyId;
            return this;
        }

        public Builder currentTime(String currentTime) {
            this.currentTime = currentTime;
            return this;
        }

        public Builder amount1(BigDecimal amount1) {
            this.amount1 = amount1;
            return this;
        }

        public Builder amount2(BigDecimal amount2) {
            this.amount2 = amount2;
            return this;
        }

        public Builder amount3(BigDecimal amount3) {
            this.amount3 = amount3;
            return this;
        }

        public Builder amount4(BigDecimal amount4) {
            this.amount4 = amount4;
            return this;
        }

        public Builder amount5(BigDecimal amount5) {
            this.amount5 = amount5;
            return this;
        }

        public Builder amount6(BigDecimal amount6) {
            this.amount6 = amount6;
            return this;
        }

        public Builder amount7(BigDecimal amount7) {
            this.amount7 = amount7;
            return this;
        }

        public Builder amount8(BigDecimal amount8) {
            this.amount8 = amount8;
            return this;
        }

        public Builder amount9(BigDecimal amount9) {
            this.amount9 = amount9;
            return this;
        }

        public Builder amount10(BigDecimal amount10) {
            this.amount10 = amount10;
            return this;
        }

        public LnsAcctInfoDto build() {
            return new LnsAcctInfoDto(this);
        }
    }
}
