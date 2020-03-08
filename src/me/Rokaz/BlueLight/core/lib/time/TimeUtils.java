package me.Rokaz.BlueLight.core.lib.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtils {
    public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
    public static String getCurrentTime() {
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        return format.format(new Date());
    }
    public static String addHoursToTime(Integer hours) {
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR_OF_DAY, hours);
        return format.format(cal.getTime());
    }
}
