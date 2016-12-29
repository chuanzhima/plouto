package com.smk.pay.core.utils;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/21 11:08
 */
public final class BeanCopierCacheUtil {

    private static ConcurrentHashMap<String, BeanCopier> BEAN_COPIER_MAP = new
            ConcurrentHashMap<String, BeanCopier>();

    public static void copy(Object srcObj, Object destObj, Converter converter) {

        Class<?> srcCls = srcObj.getClass();
        Class<?> destCls = destObj.getClass();

        String key = srcCls.getName() + destCls.getName();
        BeanCopier beanCopier;
        if (!BEAN_COPIER_MAP.containsKey(key)) {
            beanCopier = BeanCopier.create(srcCls, destCls, converter != null);
            BEAN_COPIER_MAP.put(key, beanCopier);
        } else {
            beanCopier = BEAN_COPIER_MAP.get(key);
        }
        beanCopier.copy(srcObj, destObj, converter);
    }

}
