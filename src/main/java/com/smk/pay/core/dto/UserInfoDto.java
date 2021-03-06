package com.smk.pay.core.dto;

import java.io.Serializable;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/21 10:16
 */
public class UserInfoDto implements Serializable {

    private static final long serialVersionUID = -2000595974221230606L;

    private String userId;

    private String userName;

    private String papersType;

    private String papersNo;

    private String status;

    private String phoneNo;

    public UserInfoDto() {
        super();
    }

    public UserInfoDto(String userId, String userName, String papersType, String papersNo) {
        this.userId = userId;
        this.userName = userName;
        this.papersType = papersType;
        this.papersNo = papersNo;
    }

    public UserInfoDto(String userId, String userName, String papersType, String papersNo, String status) {
        this.userId = userId;
        this.userName = userName;
        this.papersType = papersType;
        this.papersNo = papersNo;
        this.status = status;
    }


    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserInfoDto{");
        sb.append("papersNo='").append(papersNo).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
