package fr.kata.order.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static final String FORMAT_DATE_FRANCAIS = "dd/MM/yyyy";

    private DateUtils() {
        // private constructor
    }

    public static LocalDate stringFormatFrancaisToLocalDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATE_FRANCAIS);
        return LocalDate.parse(dateStr, formatter);
    }
}
