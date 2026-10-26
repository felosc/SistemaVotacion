package com.cleycer.Votacion.repository;

import org.springframework.stereotype.Repository;
import com.cleycer.Votacion.model.Votes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItfVotesRepository extends JpaRepository<Votes, Long> {

}
