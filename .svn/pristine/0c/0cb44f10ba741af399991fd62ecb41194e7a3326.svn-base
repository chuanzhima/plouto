package com.smk.pay.core.entity;

public class PrepaidCardGroupEntity extends PrepaidCardGroupEntityKey {
    private String status;

    public PrepaidCardGroupEntity(String prepaidCardId, String userDefindMark, String prepaidAccountId, String status) {
        super(prepaidCardId, userDefindMark, prepaidAccountId);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}