package com.cleycer.Votacion.repository;

import com.cleycer.Votacion.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItfElectionRepository extends JpaRepository<Election,Long> {
}
