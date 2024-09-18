package org.example.chap10.expectedvalue.survey;

import java.util.HashMap;
import java.util.Map;

public class MemorySurveyRepository implements SurveyRepository{
    private Map<Long, Survey> map = new HashMap<>();

    @Override
    public void save(Survey survey) {
        map.put(survey.getId(), survey);
    }
}
