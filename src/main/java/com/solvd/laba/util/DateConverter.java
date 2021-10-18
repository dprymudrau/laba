package com.solvd.laba.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.datetime.FastDateFormat;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateConverter {
    private static final Logger LOGGER = LogManager.getLogger(DateConverter.class);

    public static Date getSqlDate(String dateSeparatedByDash) {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd");
        try {
            java.util.Date date = fastDateFormat.parse(dateSeparatedByDash);
            return new Date(date.getTime());
        } catch (ParseException e) {
            LOGGER.error(e);
        }
        return null;
    }

    public static java.util.Date getUtilDate(String dateSeparatedByDash) {
//        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
//            java.util.Date date = fastDateFormat.parse(dateSeparatedByDash);
            java.util.Date date = simpleDateFormat.parse(dateSeparatedByDash);
            return date;
        } catch (ParseException e) {
            LOGGER.error(e);
        }
        return null;
    }

    public static Date convertToSqlDate(java.util.Date date) {
        return new Date(date.getTime());
    }
}
