package service;

import org.jetbrains.annotations.NotNull;

import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));
    public static @NotNull String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
