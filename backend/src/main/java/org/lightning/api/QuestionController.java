package org.lightning.api;

import java.util.List;

import org.lightning.model.Question;
import org.lightning.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marina Kotuseva
 */
@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    /**
     * Получить все вопросы
     * 
     * @return ответ
     */
    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getQuestions() {

        return ResponseEntity.ok().body(questionService.getQuestions());
    }

    /**
     * Создать новый вопрос
     * 
     * @param title
     *            заголовок
     * @param definition
     *            описание
     * @return созданный вопрос
     */
    @PostMapping("/create")
    public ResponseEntity<Question> createQuestion(@RequestParam(value = "title") String title,
            @RequestParam(value = "definition") String definition) {

        return ResponseEntity.ok().body(questionService.addQuestion(title, definition));
    }

    /**
     * Удалить вопрос
     * 
     * @param id
     *            ИД вопроса
     * @return ответ
     */
    @DeleteMapping("/questions/{id}")
    public HttpStatus deleteQuestion(@PathVariable String id) {

        questionService.deleteQuestion(Long.parseLong(id));
        return HttpStatus.OK;
    }
}
