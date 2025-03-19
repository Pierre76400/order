package fr.kata.order.utils;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    void stringFormatFrancaisToLocalDate() {
        assertEquals("2021-01-01", DateUtils.stringFormatFrancaisToLocalDate("01/01/2021").toString());
    }
}