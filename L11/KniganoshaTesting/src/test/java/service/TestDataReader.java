package service;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import static utils.CoreUtils.coalesce;

// ResourceBundle can't get bundle on Jenkins, so local map is used.
public class TestDataReader {
    private static final ResourceBundle resourceBundle =
            ResourceBundle.getBundle(coalesce(System.getProperty("environment"), "dev"));

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }

    private static final Map<String, String> testData = new HashMap<>();

    static {
        testData.put("t3_genre", "slouniki");
        testData.put("t7_big_item_count", "999999999999999");
        testData.put("t8_text_for_count", "A");
        testData.put("t9_dt3_ordering_form.valid_name", "Name");
        testData.put("t9_dt3_ordering_form.valid_patronymic", "Patronymic");
        testData.put("t9_dt3_ordering_form.valid_surname", "Surname");
        testData.put("t9_dt3_ordering_form.valid_phone", "250000000");
        testData.put("t9_dt3_ordering_form.valid_email", "client@gmail.com");
        testData.put("t9_dt3_ordering_form.valid_city", "City");
        testData.put("t9_dt3_ordering_form.valid_street", "Street");
        testData.put("t9_dt3_ordering_form.valid_house", "1");
        testData.put("t9_delivery_type", "DT3");
        testData.put("t9_city_name", "Яр");
    }
    public static String getTestDataLocal(String key){
        return testData.get(key);
    }
}
