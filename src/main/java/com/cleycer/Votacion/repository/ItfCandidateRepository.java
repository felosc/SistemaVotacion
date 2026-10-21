package com.cleycer.Votacion.repository;

import com.cleycer.Votacion.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItfCandidateRepository extends JpaRepository<Candidate,Long> {
}
