package org.lightning.service;

import java.util.Collections;
import java.util.List;

import org.lightning.model.Question;
import org.lightning.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

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

        List<Question> all = questionRepository.findAll();
        Collections.shuffle(all);
        return all;
    }

    @Override
    public Question addQuestion(String title, String definition) {

//        if (!StringUtils.isEmpty(title) && !StringUtils.isEmpty(definition)) {
            return questionRepository.save(new Question(title, definition));
//        }
//        throw new RuntimeException("Не все поля заполнены!");

    }

    @Override
    public void deleteQuestion(Long id) {

        questionRepository.deleteById(id);
    }
}
