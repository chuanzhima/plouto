package com.smk.pay.core.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/26 13:31
 */
public final class DateUtil {

    public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE = "yyyy-MM-dd";
    public static final String DATE_MILLS_COMPACT = "yyyyMMddHHmmssSSS";


    public static String formatDate(Date date, String pattern) {
        if (date == null)
            return "";
        return new SimpleDateFormat(pattern).format(date);
    }

    public static Date addMonth(Date fromDate, int monthCount) {

        if (null == fromDate) {
            fromDate = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fromDate);
        calendar.add(Calendar.MONTH, monthCount);
        return calendar.getTime();
    }

    public static Date thisYear() {

        Calendar calendar = Calendar.getInstance();
        calendar.get(Calendar.YEAR);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

}
