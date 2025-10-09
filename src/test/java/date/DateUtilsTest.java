package date;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateUtilsTest {

    // Kiểm thử số ngày trong tháng cho các trường hợp hợp lệ
    @Test
    void testDayInMonth_ValidCase() {
        assertEquals(31, DateUtils.dayInMonth(2021, 1)); // Tháng 1 có 31 ngày
        assertEquals(28, DateUtils.dayInMonth(2021, 2)); // Tháng 2 có 28 ngày
        assertEquals(29, DateUtils.dayInMonth(2020, 2)); // Tháng 2 năm nhuận có 29 ngày
        assertEquals(30, DateUtils.dayInMonth(2021, 4)); // Tháng 4 có 30 ngày
    }

    // Kiểm thử tính hợp lệ của ngày tháng năm
    @Test
    void testCheckDate_ValidCase() {
        assertTrue(DateUtils.checkDate(2021, 2, 28)); // Ngày hợp lệ: 28 tháng 2
        assertTrue(DateUtils.checkDate(2020, 2, 29)); // Ngày hợp lệ năm nhuận: 29 tháng 2
        assertTrue(DateUtils.checkDate(2021, 4, 30)); // Ngày hợp lệ: 30 tháng 4
    }

    @Test
    void testCheckDate_ValidDayForMonthOfLeapYear(){
        assertThrows(IllegalArgumentException.class, () ->DateUtils.checkDate(2021, 2, 29));
    }

    @Test
    void testCheckDate_InvalidCase() {// Case này muốn passed thì phải ném ra một ngoại lệ IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> DateUtils.checkDate(2021, 2, 30)); // Ngày không hợp lệ: 30 tháng 2
        assertThrows(IllegalArgumentException.class, () -> DateUtils.checkDate(2021, 4, 31)); // Ngày không hợp lệ: 31 tháng 4
    }

    // Java
    @Test
    void testDayInMonth_InvalidMonth() {
        assertThrows(IllegalArgumentException.class, () -> DateUtils.dayInMonth(2021, 0));
        assertThrows(IllegalArgumentException.class, () -> DateUtils.dayInMonth(2021, 13));
    }

    @Test
    void testCheckDate_InvalidMonth() {
        assertThrows(IllegalArgumentException.class, () -> DateUtils.checkDate(2021, 0, 10));
        assertThrows(IllegalArgumentException.class, () -> DateUtils.checkDate(2021, 13, 10));
    }

    @Test
    void testCheckDate_InvalidDay() {
        assertThrows(IllegalArgumentException.class, () -> DateUtils.checkDate(2021, 1, 0));
        assertThrows(IllegalArgumentException.class, () -> DateUtils.checkDate(2021, 1, 32));
    }
}
