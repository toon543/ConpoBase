package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dao.QuestionDAO;
import project.entity.QuestionAnswer;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Punjasin on 5/15/2015.
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
@Autowired
QuestionDAO questionDAO;
    @Override
    public List<QuestionAnswer> getQuestionAnswers() {
        return questionDAO.getQuestionList();
    }

    @Override
    public QuestionAnswer getQuestionAnswer(Long id) {
        return questionDAO.getQuestion(id);
    }

    @Override
    public QuestionAnswer addQuestionAnswer(QuestionAnswer question) {
        return questionDAO.addQuestion(question);
    }

    @Override
    public QuestionAnswer deleteQuestionAnswer(Long id) {
        QuestionAnswer q=questionDAO.getQuestion(id);
        return questionDAO.deleteQuestion(q);
    }

    @Override
    public QuestionAnswer updateQuestionAnswer(QuestionAnswer question) {
        return questionDAO.editQuestion(question);
    }
}
