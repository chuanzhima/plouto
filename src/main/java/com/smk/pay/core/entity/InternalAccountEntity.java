package com.smk.pay.core.entity;

import java.math.BigDecimal;
import java.util.Date;

public class InternalAccountEntity {
    private String internalAccountId;

    private String accountName;

    private String accountTypeId;

    private String bankAccountId;

    private String bankAccountName;

    private String status;

    private BigDecimal amount1;

    private BigDecimal amount2;

    private String parentAccountId;

    private String organizationId;

    private String bankId;

    private Date createDate;

    private Date lastUpdateDate;

    private Date cancelDate;

    private String immediatelySum;

    private String partyMarkNo;

    private String entityBy;

    private String modifyBy;

    private String cancelBy;

    private String approveBy;

    private String purposeType;

    private String createSerialNo;

    private String cancelSerialNo;

    public String getInternalAccountId() {
        return internalAccountId;
    }

    public void setInternalAccountId(String internalAccountId) {
        this.internalAccountId = internalAccountId == null ? null : internalAccountId.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(String accountTypeId) {
        this.accountTypeId = accountTypeId == null ? null : accountTypeId.trim();
    }

    public String getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(String bankAccountId) {
        this.bankAccountId = bankAccountId == null ? null : bankAccountId.trim();
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName == null ? null : bankAccountName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getParentAccountId() {
        return parentAccountId;
    }

    public void setParentAccountId(String parentAccountId) {
        this.parentAccountId = parentAccountId == null ? null : parentAccountId.trim();
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId == null ? null : organizationId.trim();
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId == null ? null : bankId.trim();
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
        this.immediatelySum = immediatelySum == null ? null : immediatelySum.trim();
    }

    public String getPartyMarkNo() {
        return partyMarkNo;
    }

    public void setPartyMarkNo(String partyMarkNo) {
        this.partyMarkNo = partyMarkNo == null ? null : partyMarkNo.trim();
    }

    public String getEntityBy() {
        return entityBy;
    }

    public void setEntityBy(String entityBy) {
        this.entityBy = entityBy == null ? null : entityBy.trim();
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    public String getCancelBy() {
        return cancelBy;
    }

    public void setCancelBy(String cancelBy) {
        this.cancelBy = cancelBy == null ? null : cancelBy.trim();
    }

    public String getApproveBy() {
        return approveBy;
    }

    public void setApproveBy(String approveBy) {
        this.approveBy = approveBy == null ? null : approveBy.trim();
    }

    public String getPurposeType() {
        return purposeType;
    }

    public void setPurposeType(String purposeType) {
        this.purposeType = purposeType == null ? null : purposeType.trim();
    }

    public String getCreateSerialNo() {
        return createSerialNo;
    }

    public void setCreateSerialNo(String createSerialNo) {
        this.createSerialNo = createSerialNo == null ? null : createSerialNo.trim();
    }

    public String getCancelSerialNo() {
        return cancelSerialNo;
    }

    public void setCancelSerialNo(String cancelSerialNo) {
        this.cancelSerialNo = cancelSerialNo == null ? null : cancelSerialNo.trim();
    }
}