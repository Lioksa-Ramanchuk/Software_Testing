package model;

import lombok.*;
import service.TestDataReader;

@AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode @ToString
public class DT3OrderingForm {
    @Getter @Setter
    private String name = TestDataReader.getTestDataLocal("dt3_ordering_form.valid_name");
    @Getter @Setter
    private String patronymic = TestDataReader.getTestDataLocal("dt3_ordering_form.valid_patronymic");
    @Getter @Setter
    private String surname = TestDataReader.getTestDataLocal("dt3_ordering_form.valid_surname");
    @Getter @Setter
    private String phone = TestDataReader.getTestDataLocal("dt3_ordering_form.valid_phone");
    @Getter @Setter
    private String email = TestDataReader.getTestDataLocal("dt3_ordering_form.valid_email");
    @Getter @Setter
    private String city = TestDataReader.getTestDataLocal("dt3_ordering_form.valid_city");
    @Getter @Setter
    private String postIndex = null;
    @Getter @Setter
    private String street = TestDataReader.getTestDataLocal("dt3_ordering_form.valid_street");
    @Getter @Setter
    private String house = TestDataReader.getTestDataLocal("dt3_ordering_form.valid_house");
    @Getter @Setter
    private String corpus = null;
    @Getter @Setter
    private String apartment = null;
    @Getter @Setter
    private String additional = null;
}
