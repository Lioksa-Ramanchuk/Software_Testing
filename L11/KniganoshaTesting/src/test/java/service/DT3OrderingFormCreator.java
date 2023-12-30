package service;

import model.DT3OrderingForm;

public class DT3OrderingFormCreator {
    public static DT3OrderingForm create() { return new DT3OrderingForm(); }
    public static DT3OrderingForm createWithCity(String city){
        var form = create();
        form.setCity(city);
        return form;
    }
    public static DT3OrderingForm createWithStreet(String street){
        var form = create();
        form.setStreet(street);
        return form;
    }
}
