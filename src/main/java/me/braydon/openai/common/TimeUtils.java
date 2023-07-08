package me.braydon.openai.common;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Braydon
 */
@UtilityClass
public final class TimeUtils {
    /**
     * Get the date at the given month and year.
     *
     * @param month the month
     * @param year  the year
     * @return the date
     * @see Date for date
     */
    @NonNull
    public static Date getDate(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1); // Y/M/D
        return calendar.getTime();
    }
}
