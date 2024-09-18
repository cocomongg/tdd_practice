package org.example.chap10.expectedvalue;

import org.example.chap10.expectedvalue.survey.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurveyTest {
    private List<Integer> answers = Arrays.asList(1, 2, 3, 4);
    private Long respondentId = 100L;
    private SurveyRepository surveyRepository = new MemorySurveyRepository();
    private SurveyAnswerRepository memoryRepository = new MemorySurveyAnswerRepository();
    private SurveyService svc = new SurveyService(this.memoryRepository);

    @DisplayName("답변에 성공하면 결과 저장함")
    @Test
    void saveAnswerSuccessfullyUsingField() {
        Survey survey = SurveyFactory.createApprovedSurvey(1L);
        surveyRepository.save(survey);

        SurveyAnswerRequest surveyAnswer = SurveyAnswerRequest.builder()
                .surveyId(survey.getId())
                .respondentId(respondentId)
                .answers(answers)
                .build();

        svc.answerSurvey(surveyAnswer);

        SurveyAnswer savedAnswer =
                memoryRepository.findBySurveyAndRespondent(survey.getId(), respondentId);

        assertAll(
                () -> assertEquals(respondentId, savedAnswer.getRespondentId()),
                () -> assertEquals(answers.size(), savedAnswer.getAnswers().size()),
                () -> assertEquals(answers.get(0), savedAnswer.getAnswers().get(0)),
                () -> assertEquals(answers.get(1), savedAnswer.getAnswers().get(1)),
                () -> assertEquals(answers.get(2), savedAnswer.getAnswers().get(2)),
                () -> assertEquals(answers.get(2), savedAnswer.getAnswers().get(3))
        );
    }

    @DisplayName("답변에 성공하면 결과 저장함")
    @Test
    void saveAnswerSuccessfullyUsingValue() {
        Survey survey = SurveyFactory.createApprovedSurvey(1L);
        surveyRepository.save(survey);

        SurveyAnswerRequest surveyAnswer = SurveyAnswerRequest.builder()
                .surveyId(1L)
                .respondentId(100L)
                .answers(Arrays.asList(1, 2, 3, 4))
                .build();

        svc.answerSurvey(surveyAnswer);

        SurveyAnswer savedAnswer =
                memoryRepository.findBySurveyAndRespondent(1L, 100L);

        assertAll(
                () -> assertEquals(100L, savedAnswer.getRespondentId()),
                () -> assertEquals(4, savedAnswer.getAnswers().size()),
                () -> assertEquals(1, savedAnswer.getAnswers().get(0)),
                () -> assertEquals(2, savedAnswer.getAnswers().get(1)),
                () -> assertEquals(3, savedAnswer.getAnswers().get(2)),
                () -> assertEquals(4, savedAnswer.getAnswers().get(3))
        );
    }
}
