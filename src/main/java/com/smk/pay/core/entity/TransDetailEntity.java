package com.smk.pay.core.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TransDetailEntity {

    private String serialNo;

    private String transId;

    private String transType;

    private String userId;

    private String userName;

    private String originalSerialNo;

    private String originalTransDate;

    private String originalTransTime;

    private String sourceOfFunds;

    private String accountId;

    private String accountClass;

    private String accountCl;

    private String rivalAccount;

    private String rivalAccountClass;

    private String rivalAccountCl;

    private String rivalUserId;

    private String rivalUserName;

    private String reqSerialNo;

    private String reqTransDate;

    private String reqTransTime;

    private BigDecimal cost;

    private Date transDate;

    private String status;

    private String channel;

    private String partyMarkNo;

    private String accountTypeItem;

    private String merchantId;

    private String userDefindMark;

    private BigDecimal integral;

    private BigDecimal guaranteeDeposit;

    private String accountType;

    private BigDecimal time;

    private String accDate;

    private String replacementFlag;

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

    private BigDecimal amount11;

    private BigDecimal amount12;

    private BigDecimal amount13;

    private BigDecimal amount14;

    private BigDecimal amount15;

    private BigDecimal amount16;

    private BigDecimal amount17;

    private BigDecimal amount18;

    private BigDecimal amount19;

    private BigDecimal amount20;

    private String accountingTrans;

    private String businessType;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
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

    public String getSourceOfFunds() {
        return sourceOfFunds;
    }

    public void setSourceOfFunds(String sourceOfFunds) {
        this.sourceOfFunds = sourceOfFunds == null ? null : sourceOfFunds.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getAccountClass() {
        return accountClass;
    }

    public void setAccountClass(String accountClass) {
        this.accountClass = accountClass == null ? null : accountClass.trim();
    }

    public String getAccountCl() {
        return accountCl;
    }

    public void setAccountCl(String accountCl) {
        this.accountCl = accountCl == null ? null : accountCl.trim();
    }

    public String getRivalAccount() {
        return rivalAccount;
    }

    public void setRivalAccount(String rivalAccount) {
        this.rivalAccount = rivalAccount == null ? null : rivalAccount.trim();
    }

    public String getRivalAccountClass() {
        return rivalAccountClass;
    }

    public void setRivalAccountClass(String rivalAccountClass) {
        this.rivalAccountClass = rivalAccountClass == null ? null : rivalAccountClass.trim();
    }

    public String getRivalAccountCl() {
        return rivalAccountCl;
    }

    public void setRivalAccountCl(String rivalAccountCl) {
        this.rivalAccountCl = rivalAccountCl == null ? null : rivalAccountCl.trim();
    }

    public String getRivalUserId() {
        return rivalUserId;
    }

    public void setRivalUserId(String rivalUserId) {
        this.rivalUserId = rivalUserId == null ? null : rivalUserId.trim();
    }

    public String getRivalUserName() {
        return rivalUserName;
    }

    public void setRivalUserName(String rivalUserName) {
        this.rivalUserName = rivalUserName == null ? null : rivalUserName.trim();
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getPartyMarkNo() {
        return partyMarkNo;
    }

    public void setPartyMarkNo(String partyMarkNo) {
        this.partyMarkNo = partyMarkNo == null ? null : partyMarkNo.trim();
    }

    public String getAccountTypeItem() {
        return accountTypeItem;
    }

    public void setAccountTypeItem(String accountTypeItem) {
        this.accountTypeItem = accountTypeItem == null ? null : accountTypeItem.trim();
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public String getUserDefindMark() {
        return userDefindMark;
    }

    public void setUserDefindMark(String userDefindMark) {
        this.userDefindMark = userDefindMark == null ? null : userDefindMark.trim();
    }

    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    public BigDecimal getGuaranteeDeposit() {
        return guaranteeDeposit;
    }

    public void setGuaranteeDeposit(BigDecimal guaranteeDeposit) {
        this.guaranteeDeposit = guaranteeDeposit;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    public BigDecimal getTime() {
        return time;
    }

    public void setTime(BigDecimal time) {
        this.time = time;
    }

    public String getAccDate() {
        return accDate;
    }

    public void setAccDate(String accDate) {
        this.accDate = accDate == null ? null : accDate.trim();
    }

    public String getReplacementFlag() {
        return replacementFlag;
    }

    public void setReplacementFlag(String replacementFlag) {
        this.replacementFlag = replacementFlag == null ? null : replacementFlag.trim();
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

    public BigDecimal getAmount11() {
        return amount11;
    }

    public void setAmount11(BigDecimal amount11) {
        this.amount11 = amount11;
    }

    public BigDecimal getAmount12() {
        return amount12;
    }

    public void setAmount12(BigDecimal amount12) {
        this.amount12 = amount12;
    }

    public BigDecimal getAmount13() {
        return amount13;
    }

    public void setAmount13(BigDecimal amount13) {
        this.amount13 = amount13;
    }

    public BigDecimal getAmount14() {
        return amount14;
    }

    public void setAmount14(BigDecimal amount14) {
        this.amount14 = amount14;
    }

    public BigDecimal getAmount15() {
        return amount15;
    }

    public void setAmount15(BigDecimal amount15) {
        this.amount15 = amount15;
    }

    public BigDecimal getAmount16() {
        return amount16;
    }

    public void setAmount16(BigDecimal amount16) {
        this.amount16 = amount16;
    }

    public BigDecimal getAmount17() {
        return amount17;
    }

    public void setAmount17(BigDecimal amount17) {
        this.amount17 = amount17;
    }

    public BigDecimal getAmount18() {
        return amount18;
    }

    public void setAmount18(BigDecimal amount18) {
        this.amount18 = amount18;
    }

    public BigDecimal getAmount19() {
        return amount19;
    }

    public void setAmount19(BigDecimal amount19) {
        this.amount19 = amount19;
    }

    public BigDecimal getAmount20() {
        return amount20;
    }

    public void setAmount20(BigDecimal amount20) {
        this.amount20 = amount20;
    }

    public String getAccountingTrans() {
        return accountingTrans;
    }

    public void setAccountingTrans(String accountingTrans) {
        this.accountingTrans = accountingTrans == null ? null : accountingTrans.trim();
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }
}