package com.mahi.em.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.mahi.em.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value="select budget from user where user_id=?1",
			nativeQuery = true
			)
	public Optional<Double> findBudgetByUserId(int id);
}
