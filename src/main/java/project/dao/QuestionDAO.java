package project.dao;

import project.entity.QuestionAnswer;

import java.util.List;

/**
 * Created by Punjasin on 5/15/2015.
 */
public interface QuestionDAO {
    List<QuestionAnswer> getQuestionList();
QuestionAnswer getQuestion(Long id);
    QuestionAnswer addQuestion(QuestionAnswer q);
    QuestionAnswer editQuestion(QuestionAnswer q);
    QuestionAnswer deleteQuestion(QuestionAnswer q);



}
