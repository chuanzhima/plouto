package com.smk.pay.core.entity;

import java.util.Date;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/26 19:16
 */
public class BaseEntity {

    public String creator;

    public Date gmtCreate;

    public String modifier;

    public Date gmtModified;

    public String isDeleted;

    public BaseEntity() {
        super();
    }

    public BaseEntity(String modifier, Date gmtModified) {
        this.modifier = modifier;
        this.gmtModified = gmtModified;
    }

    public BaseEntity(String creator, Date gmtCreate, String modifier, Date gmtModified, String isDeleted) {
        this.creator = creator;
        this.gmtCreate = gmtCreate;
        this.modifier = modifier;
        this.gmtModified = gmtModified;
        this.isDeleted = isDeleted;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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
        this.modifier = modifier;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
}
