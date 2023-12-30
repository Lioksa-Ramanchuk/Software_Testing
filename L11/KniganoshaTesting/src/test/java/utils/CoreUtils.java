package utils;

public class CoreUtils {
    public static <T> T coalesce(T one, T two) {
        return one != null ? one : two;
    }
}