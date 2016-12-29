package com.smk.pay.core.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/26 14:40
 */
public class AccountTaskInfoDto implements Serializable {

    private static final long serialVersionUID = 8886199712408784739L;

    private String creator;

    private Date gmtCreate;

    private String modifier;

    private Date gmtModifier;

    private String isDeleted;
    /**
     * AccountTaskEnum.Status
     */
    private String status;
    /**
     * AccountTaskEnum
     */
    private String type;

    private String accountId;

    private String property;

    private String id;

    private String source;

    public AccountTaskInfoDto() {
        super();
    }

    public AccountTaskInfoDto(String status, String type, String accountId, String property) {
        this.status = status;
        this.type = type;
        this.accountId = accountId;
        this.property = property;
    }

    public AccountTaskInfoDto(String creator, Date gmtCreate, String modifier, Date gmtModifier,
                              String isDeleted, String status, String type,
                              String accountId, String property, String source) {
        this.creator = creator;
        this.gmtCreate = gmtCreate;
        this.modifier = modifier;
        this.gmtModifier = gmtModifier;
        this.isDeleted = isDeleted;
        this.status = status;
        this.type = type;
        this.accountId = accountId;
        this.property = property;
        this.source = source;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Date getGmtModifier() {
        return gmtModifier;
    }

    public void setGmtModifier(Date gmtModifier) {
        this.gmtModifier = gmtModifier;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property == null ? null : property.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
