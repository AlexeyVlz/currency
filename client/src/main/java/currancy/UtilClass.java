package currancy;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UtilClass {

    public static LocalDate toLocalDate(String value) {
        return LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
