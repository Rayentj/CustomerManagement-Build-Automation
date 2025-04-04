package edu.miu.cs.cs489.pensionmgmt.util;

import java.time.LocalDate;

public class DateUtil {
    public static Quarter getNextQuarter(LocalDate currentDate) {
        return switch (currentDate.getMonth()) {
            case JANUARY, FEBRUARY, MARCH -> new Quarter(QuarterNumber.Q2, LocalDate.of(currentDate.getYear(), 4, 1), LocalDate.of(currentDate.getYear(), 6, 30));
            case APRIL, MAY, JUNE -> new Quarter(QuarterNumber.Q3, LocalDate.of(currentDate.getYear(), 7, 1), LocalDate.of(currentDate.getYear(), 9, 30));
            case JULY, AUGUST, SEPTEMBER -> new Quarter(QuarterNumber.Q4, LocalDate.of(currentDate.getYear(), 10, 1), LocalDate.of(currentDate.getYear(), 12, 31));
            case OCTOBER, NOVEMBER, DECEMBER -> new Quarter(QuarterNumber.Q1, LocalDate.of(currentDate.getYear() + 1, 1, 1), LocalDate.of(currentDate.getYear() + 1, 3, 31));
        };
    }
}
