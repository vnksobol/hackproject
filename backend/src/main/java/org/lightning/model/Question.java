package org.lightning.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Marina Kotuseva
 */
@Entity
@Table(name = "question")
@Data
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "question_seq")
    @SequenceGenerator(name = "question_seq",
            sequenceName = "QUESTION_SEQ",
            allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "definition",
            columnDefinition = "TEXT")
    private String definition;

    public Question(String title, String definition) {

        this.title = title;
        this.definition = definition;
    }
}
