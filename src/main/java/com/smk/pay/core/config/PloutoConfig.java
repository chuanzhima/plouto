package com.smk.pay.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/5 10:01
 */
@Component
public class PloutoConfig {

    @Value("${error.mail.switch}")
    private String errorMailSwitch;
    @Value("${error.mail.to}")
    private String errorMailTo;
    @Value("${error.mail.from}")
    private String errorMailFrom;
    @Value("${error.mail.subject}")
    private String errorMailSubject;

    public String getErrorMailSwitch() {
        return errorMailSwitch;
    }

    public void setErrorMailSwitch(String errorMailSwitch) {
        this.errorMailSwitch = errorMailSwitch;
    }

    public String getErrorMailTo() {
        return errorMailTo;
    }

    public void setErrorMailTo(String errorMailTo) {
        this.errorMailTo = errorMailTo;
    }

    public String getErrorMailFrom() {
        return errorMailFrom;
    }

    public void setErrorMailFrom(String errorMailFrom) {
        this.errorMailFrom = errorMailFrom;
    }

    public String getErrorMailSubject() {
        return errorMailSubject;
    }

    public void setErrorMailSubject(String errorMailSubject) {
        this.errorMailSubject = errorMailSubject;
    }
}
