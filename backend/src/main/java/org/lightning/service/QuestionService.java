package org.lightning.service;

import java.util.List;

import org.lightning.model.Question;

/**
 * @author Marina Kotuseva
 */
public interface QuestionService {

    List<Question> getQuestions();

    Question addQuestion(String title, String definition);

    void deleteQuestion(Long id);
}
