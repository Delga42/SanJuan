package com.albaitdevs.programasanjuan.utils;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by Delga on 25/05/2015.
 */
public class Time {
    private static Long beginningDate2015 = Long.parseLong("1435179600");
    private static Long beginningDate2016 = Long.parseLong("1467234000");
    private static Long beginningDate2017 = Long.parseLong("1498683600");
    private static Long beginningDate2018 = Long.parseLong("1530133200");

    private static Long endingDate2015 = Long.parseLong("1435644000");
    private static Long endingDate2016 = Long.parseLong("1467698400");
    private static Long endingDate2017 = Long.parseLong("1499148000");
    private static Long endingDate2018 = Long.parseLong("1530597600");

    public static Long getTime(){
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("gmt"));
        Long time = calendar.getTimeInMillis() / 1000;
        return time;
    }

    public static Long nextBeginningDate(){

        Long time = getTime();

        if (time<beginningDate2015) {
            return beginningDate2015;
        } else if (time<beginningDate2016) {
            return beginningDate2016;
        } else if (time<beginningDate2017) {
            return beginningDate2017;
        } else if (time<beginningDate2018) {
            return beginningDate2018;
        } else {
            return time;
        }

    }

    public static Long nextEndingDate(){
        Long time = getTime();

        if (time<endingDate2015) {
            return endingDate2015;
        } else if (time<endingDate2016) {
            return endingDate2016;
        } else if (time<endingDate2017) {
            return endingDate2017;
        } else if (time<endingDate2018) {
            return endingDate2018;
        } else {
            return time;
        }

    }

    public static String getRemainingDays(){
        Long secondsInDay = Long.parseLong("86400");
        Long time = Time.getTime();
        Long nextDate = Time.nextBeginningDate();

        Long days = (nextDate-time)/secondsInDay;
        return days.toString();
    }

    public static int getCurrentYear(){
        Calendar time = Calendar.getInstance();
        return time.get(Calendar.YEAR) - 1900;
    }

    public static boolean areWeOnPartiesNow (){
        Long time = getTime();

        if ( //Compare dates for the following years
                (time > beginningDate2015 && time < endingDate2015) ||
                (time > beginningDate2016 && time < endingDate2016) ||
                (time > beginningDate2017 && time < endingDate2017) ||
                (time > beginningDate2018 && time < endingDate2018)
                ){
            return true;
        } else {
            return false;
        }
    }
}
