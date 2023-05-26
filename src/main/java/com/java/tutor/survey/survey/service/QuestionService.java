package com.java.tutor.survey.survey.service;

import com.java.tutor.survey.survey.entities.Question;
import com.java.tutor.survey.survey.entities.Questionnaire;
import com.java.tutor.survey.survey.repositories.QuestionRepository;
import com.java.tutor.survey.survey.repositories.QuestionnaireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionnaireRepository questionnaireRepository;

    public Question create(String question, Long questionnaireId){
        Optional<Questionnaire> questionnaire = questionnaireRepository.findById(questionnaireId);
        if (questionnaire.isPresent()){
            Question q = new Question();
            q.setQuestionnaire(questionnaire.get());
            q.setText(question);
            return questionRepository.save(q);
        }else {
            throw new RuntimeException("Invalid Questionnaire");
        }
    }

    public Question findById(Long id) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        if (questionOptional.isPresent()){
            return questionOptional.get();
        }

        throw new RuntimeException("Questionnaire with id " + id + " does not exits!");
    }

    public List<Question> getAll(){
        return questionRepository.findAll();
    }
}
