package org.example.chap10.expectedvalue.survey;

public class SurveyService {
    private SurveyAnswerRepository surveyAnswerRepository;

    public SurveyService(SurveyAnswerRepository surveyAnswerRepository) {
        this.surveyAnswerRepository = surveyAnswerRepository;
    }

    public void answerSurvey(SurveyAnswerRequest request) {
        SurveyAnswer surveyAnswer =
                new SurveyAnswer(request.getSurveyId(), request.getRespondentId(), request.getAnswers());

        surveyAnswerRepository.save(surveyAnswer);
    }
}
