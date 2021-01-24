package org.chengtc.TTJJcrawler.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static Calendar startDate = Calendar.getInstance();
    private static Calendar endDate = Calendar.getInstance();

    /**
     * 计算两个时间相差多少个年
     *
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    public static int yearsBetween(String start, String end) throws ParseException {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.setTime(sdf.parse(start));
        endDate.setTime(sdf.parse(end));
        return (endDate.get(Calendar.YEAR) - startDate.get(Calendar.YEAR));
    }
    public static int yearsBetweenNow(String start) throws ParseException {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.setTime(sdf.parse(start));
        endDate.setTime(new Date());
        return (endDate.get(Calendar.YEAR) - startDate.get(Calendar.YEAR));
    }
}
