package org.example.chap10.expectedvalue.survey;

import java.util.List;

public class SurveyAnswer {
    private Long surveyId;
    private Long respondentId;
    private List<Integer> answers;

    public SurveyAnswer(Long surveyId, Long respondentId, List<Integer> answers) {
        this.surveyId = surveyId;
        this.respondentId = respondentId;
        this.answers = answers;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public Long getRespondentId() {
        return respondentId;
    }

    public List<Integer> getAnswers() {
        return answers;
    }
}
