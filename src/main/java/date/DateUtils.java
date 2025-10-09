package date;

public class DateUtils {

    // Phương thức trả về số ngày trong một tháng của năm
    public static int dayInMonth(int year, int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31; // Các tháng có 31 ngày
            case 4: case 6: case 9: case 11:
                return 30; // Các tháng có 30 ngày
            case 2:
                return (isLeapYear(year)) ? 29 : 28; // Tháng 2 có 28 hoặc 29 ngày
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
    }

    // Kiểm tra năm nhuận
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    // Phương thức kiểm tra tính hợp lệ của ngày tháng năm
    public static boolean checkDate(int year, int month, int day) {

        if (year < 1) {
            throw new IllegalArgumentException("Invalid year: " + year);
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
        int daysInMonth = dayInMonth(year, month); // Lấy số ngày trong tháng

        if (day < 1 || day > daysInMonth){
            throw new IllegalArgumentException("Invalid day: " + day);
        }
        return false;
    }
}
