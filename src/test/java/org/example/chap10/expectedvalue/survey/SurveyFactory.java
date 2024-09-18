package org.example.chap10.expectedvalue.survey;

public class SurveyFactory {
    public static Survey createApprovedSurvey(Long id) {
        return new Survey(id);
    }
}
