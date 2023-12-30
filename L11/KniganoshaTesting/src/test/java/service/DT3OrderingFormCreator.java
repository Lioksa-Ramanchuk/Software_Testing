package service;

import model.DT3OrderingForm;

public class DT3OrderingFormCreator {
    public static DT3OrderingForm create() { return new DT3OrderingForm(); }
    public static DT3OrderingForm createWithCity(String city){
        var form = new DT3OrderingForm();
        form.setCity(city);
        return form;
    }
}
