package com.optum.casestudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optum.casestudy.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer	> {
	
}
