package com.java.tutor.survey.survey.repositories;

import com.java.tutor.survey.survey.entities.Question;
import com.java.tutor.survey.survey.entities.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
