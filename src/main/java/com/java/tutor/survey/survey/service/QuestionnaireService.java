package com.java.tutor.survey.survey.service;

import com.java.tutor.survey.survey.entities.Question;
import com.java.tutor.survey.survey.entities.Questionnaire;
import com.java.tutor.survey.survey.repositories.QuestionnaireRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class QuestionnaireService {
    private final QuestionnaireRepository questionnaireRepository;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    public Questionnaire create(String name){
        Questionnaire q = new Questionnaire();
        q.setName(name); // -> Q1
        return questionnaireRepository.save(q);
    }

    public List<Questionnaire> getAll() {
        return questionnaireRepository.findAll();
    }

    public Questionnaire findById(Long id) {
        Optional<Questionnaire> questionnaireOptional = questionnaireRepository.findById(id);
        if (questionnaireOptional.isPresent()){
            return questionnaireOptional.get();
        }

        throw new RuntimeException("Questionnaire with id " + id + " does not exits!");
    }

    public List<Question> getAllQuestions(Long id) {
        Questionnaire questionnaire = findById(id);

        return questionnaire.getQuestions();
    }
}
