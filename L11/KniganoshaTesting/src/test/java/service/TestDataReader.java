package service;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import static utils.CoreUtils.coalesce;

// ResourceBundle can't get bundle on Jenkins, so local map is used.
public class TestDataReader {
    private static final Map<String, String> testData = new HashMap<>();

    static {
        testData.put("dt3_ordering_form.valid_name", "Name");
        testData.put("dt3_ordering_form.valid_patronymic", "Patronymic");
        testData.put("dt3_ordering_form.valid_surname", "Surname");
        testData.put("dt3_ordering_form.valid_phone", "250000000");
        testData.put("dt3_ordering_form.valid_email", "client@gmail.com");
        testData.put("dt3_ordering_form.valid_city", "City");
        testData.put("dt3_ordering_form.valid_street", "Street");
        testData.put("dt3_ordering_form.valid_house", "1");
        testData.put("t3_genre", "slouniki");
        testData.put("t7_big_item_count", "999999999999999");
        testData.put("t8_text_for_count", "A");
        testData.put("t9_delivery_type", "DT3");
        testData.put("t9_valid_city", "Aa");
        testData.put("t10_delivery_type", "DT3");
        testData.put("t10_long_street", "a".repeat(160));
    }
    public static String getTestDataLocal(String key){
        return testData.get(key);
    }
}
