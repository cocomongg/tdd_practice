package org.example.chap10.expectedvalue.survey;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MemorySurveyAnswerRepository implements SurveyAnswerRepository{
    Map<Long, SurveyAnswer> map = new HashMap<>();

    @Override
    public void save(SurveyAnswer surveyAnswer) {
        map.put(surveyAnswer.getSurveyId(), surveyAnswer);
    }

    @Override
    public SurveyAnswer findBySurveyAndRespondent(Long surveyId, Long respondentId) {
        SurveyAnswer surveyAnswer = map.get(surveyId);
        if(Objects.equals(surveyAnswer.getRespondentId(), respondentId)) {
            return surveyAnswer;
        }

        throw new RuntimeException("not found");
    }
}
