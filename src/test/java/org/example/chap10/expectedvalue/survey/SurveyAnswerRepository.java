package org.example.chap10.expectedvalue.survey;

public interface SurveyAnswerRepository {
    void save(SurveyAnswer surveyAnswer);
    SurveyAnswer findBySurveyAndRespondent(Long surveyId, Long respondentId);
}
