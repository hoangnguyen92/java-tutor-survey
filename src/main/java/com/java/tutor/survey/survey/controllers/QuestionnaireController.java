package com.java.tutor.survey.survey.controllers;

import com.java.tutor.survey.survey.entities.Question;
import com.java.tutor.survey.survey.entities.Questionnaire;
import com.java.tutor.survey.survey.service.QuestionService;
import com.java.tutor.survey.survey.service.QuestionnaireService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/questionnaires")
public class QuestionnaireController {

    private QuestionnaireService questionnaireService;
    public QuestionnaireController(QuestionnaireService questionnaireService){
        this.questionnaireService = questionnaireService;
    }

    record QuestionnaireRequest (String name){}
    @PostMapping
    public Questionnaire create(@RequestBody QuestionnaireRequest request){
        return questionnaireService.create(request.name());
    }

    @GetMapping
    public List<Questionnaire> getAll(){
        return questionnaireService.getAll();
    }

    @GetMapping("/{id}")
    public Questionnaire getById(@PathVariable Long id){
        return questionnaireService.findById(id);
    }

    @GetMapping("/{id}/questions")
    public List<Question> getAllQuestions(@PathVariable Long id){
        return questionnaireService.getAllQuestions(id);
    }
}
