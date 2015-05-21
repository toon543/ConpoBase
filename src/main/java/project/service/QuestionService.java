package project.service;

import project.entity.QuestionAnswer;

import java.util.List;

/**
 * Created by Punjasin on 5/15/2015.
 */
public interface QuestionService {
    List<QuestionAnswer> getQuestionAnswers();
    QuestionAnswer  getQuestionAnswer(Long id);
    QuestionAnswer  addQuestionAnswer(QuestionAnswer question);
    QuestionAnswer  deleteQuestionAnswer(Long id);
    QuestionAnswer  updateQuestionAnswer(QuestionAnswer question);


}
