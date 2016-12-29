package com.smk.pay.core.manager;

import com.smk.pay.account.core.request.RequestHeader;

import java.util.Map;

/**
 * 冲正
 * <p/>
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/12/14 15:07
 */
public interface IAccountReverseManager {

    void reverse(RequestHeader header, String originalSeq, String originalDate, String originalTime, Map<String,
            Object> extraParam);
}
