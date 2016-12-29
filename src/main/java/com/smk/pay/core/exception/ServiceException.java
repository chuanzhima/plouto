package com.smk.pay.core.exception;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/19 15:59
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 2117696342602045628L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
