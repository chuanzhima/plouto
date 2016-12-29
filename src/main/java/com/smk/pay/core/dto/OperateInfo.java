package com.smk.pay.core.dto;

import java.util.Date;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/26 20:02
 */
public class OperateInfo {

    public String operator;

    public Date operateDate;

    public OperateInfo(String operator, Date operateDate) {
        this.operator = operator;
        this.operateDate = operateDate;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }
}
