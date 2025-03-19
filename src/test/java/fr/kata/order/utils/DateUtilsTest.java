package fr.kata.order.utils;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DateUtilsTest {

    @Test
    public void stringFormatFrancaisToLocalDate() {
        assertEquals("2021-01-01", DateUtils.stringFormatFrancaisToLocalDate("01/01/2021").toString());
    }
}