package utils;

import java.util.Random;

public class StringUtils {
    public static final String ALPHANUMERICAL_ALL_CAPS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static Random random = new Random();

    public static String getRandomString(int length) {
        var sb = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            sb.append(ALPHANUMERICAL_ALL_CAPS.charAt(random.nextInt(ALPHANUMERICAL_ALL_CAPS.length())));
        }
        return sb.toString();
    }

    public static String generateRandomRepositoryNameWithPostfixLength(int postfixLength) {
        return "testRepo_".concat(getRandomString(postfixLength));
    }
}