package com.java.tutor.survey.survey.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Questionnaire")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Questionnaire {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="questionnaire")
    private List<Question> questions;

    @ManyToMany(mappedBy = "questionnaires")
    private Set<Participant> participants = new HashSet<>();
}
