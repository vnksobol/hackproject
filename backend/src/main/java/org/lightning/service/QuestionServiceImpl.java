package org.lightning.service;

import java.util.List;

import org.lightning.model.Question;
import org.lightning.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Marina Kotuseva
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> getQuestions() {

        return questionRepository.findAll();
    }

    @Override
    public Question addQuestion(String title, String definition) {

        return questionRepository.save(new Question(title, definition));
    }

    @Override
    public void deleteQuestion(Long id) {

        questionRepository.deleteById(id);
    }
}
