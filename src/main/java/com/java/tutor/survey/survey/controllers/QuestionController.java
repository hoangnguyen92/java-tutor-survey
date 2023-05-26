package com.java.tutor.survey.survey.controllers;

import com.java.tutor.survey.survey.entities.Question;
import com.java.tutor.survey.survey.entities.Questionnaire;
import com.java.tutor.survey.survey.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private QuestionService questionService;
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    record QuestionRequest(Long questionnaireId, String text){}
    @PostMapping
    public Question create(@RequestBody QuestionRequest questionRequest){
        return questionService.create(questionRequest.text(), questionRequest.questionnaireId());
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable Long id){
        return questionService.findById(id);
    }

    @GetMapping
    public List<Question> getAllQuestions(){
        return questionService.getAll();
    }
}
