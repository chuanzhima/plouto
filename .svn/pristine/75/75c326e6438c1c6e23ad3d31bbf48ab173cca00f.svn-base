package com.smk.pay.core.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ImpostorEntity extends BaseEntity {
    private Integer id;

    private String name;

    private String credentialType;

    private String credentialNo;

    private String phone;

    private String email;

    private String address;

    private String gender;

    private BigDecimal age;

    public ImpostorEntity() {
        super();
    }

    public ImpostorEntity(String modifier, Date gmtModified) {
        super(modifier, gmtModified);
    }

    public ImpostorEntity(String creator, Date gmtCreate, String modifier, Date gmtModified, String isDeleted) {
        super(creator, gmtCreate, modifier, gmtModified, isDeleted);
    }

    public ImpostorEntity(String name, String credentialType, String credentialNo, String phone,
                          String email, String address, String gender, BigDecimal age) {
        this.name = name;
        this.credentialType = credentialType;
        this.credentialNo = credentialNo;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.age = age;
    }

    public ImpostorEntity(String creator, Date gmtCreate, String modifier, Date gmtModified,
                          String isDeleted, String name, String credentialType, String credentialNo,
                          String phone, String email, String address, String gender, BigDecimal age) {
        super(creator, gmtCreate, modifier, gmtModified, isDeleted);
        this.name = name;
        this.credentialType = credentialType;
        this.credentialNo = credentialNo;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCredentialType() {
        return credentialType;
    }

    public void setCredentialType(String credentialType) {
        this.credentialType = credentialType == null ? null : credentialType.trim();
    }

    public String getCredentialNo() {
        return credentialNo;
    }

    public void setCredentialNo(String credentialNo) {
        this.credentialNo = credentialNo == null ? null : credentialNo.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }
}