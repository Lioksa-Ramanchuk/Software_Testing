package utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CoreUtils {
    public static <T> T coalesce(T one, T two) {
        return one != null ? one : two;
    }

    public static String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}