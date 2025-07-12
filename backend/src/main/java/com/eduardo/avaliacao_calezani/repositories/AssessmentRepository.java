package com.eduardo.avaliacao_calezani.repositories;

import com.eduardo.avaliacao_calezani.entities.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
}
