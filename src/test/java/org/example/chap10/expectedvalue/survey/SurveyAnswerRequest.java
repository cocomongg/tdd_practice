package org.example.chap10.expectedvalue.survey;

import org.example.chap03.PayData;

import java.util.List;

public class SurveyAnswerRequest {
    private Long surveyId;
    private Long respondentId;
    private List<Integer> answers;

    public SurveyAnswerRequest() {}
    public SurveyAnswerRequest(Long surveyId, Long respondentId, List<Integer> answers) {
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

    public static Builder builder() {
        return new SurveyAnswerRequest.Builder();
    }

    public static class Builder {
        private SurveyAnswerRequest request = new SurveyAnswerRequest();

        public Builder surveyId(Long surveyId) {
            request.surveyId = surveyId;
            return this;
        }

        public Builder respondentId(Long respondentId) {
            request.respondentId = respondentId;
            return this;
        }

        public Builder answers(List<Integer> answers) {
            request.answers = answers;
            return this;
        }

        public SurveyAnswerRequest build() {
            return request;
        }
    }
}
