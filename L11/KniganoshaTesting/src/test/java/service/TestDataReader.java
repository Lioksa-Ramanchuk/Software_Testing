package service;

import java.util.ResourceBundle;

import static utils.StringUtils.coalesce;

public class TestDataReader {
    private static final ResourceBundle resourceBundle =
            ResourceBundle.getBundle(coalesce(System.getProperty("environment"), "dev"));
    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
