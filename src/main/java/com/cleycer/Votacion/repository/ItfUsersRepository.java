package com.cleycer.Votacion.repository;

import com.cleycer.Votacion.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItfUsersRepository extends JpaRepository<Users,Long> {

}
