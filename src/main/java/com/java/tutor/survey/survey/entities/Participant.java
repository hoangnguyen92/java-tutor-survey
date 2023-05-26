package com.java.tutor.survey.survey.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Participant")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Participant {
    @Id
    @GeneratedValue
    private Long id;
    private String fname;
    private String lname;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Participant_Questionnaire",
            joinColumns = { @JoinColumn(name = "participant_id") },
            inverseJoinColumns = { @JoinColumn(name = "questionnaire_id") }
    )
    Set<Questionnaire> questionnaires = new HashSet<>();
}
