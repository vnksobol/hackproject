package org.lightning.repo;

import org.lightning.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marina Kotuseva
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
