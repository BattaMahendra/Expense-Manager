package com.mahi.em.repos;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mahi.em.entity.Expenses;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
	
	@Query(
			value = "select sum(expense_amount) from expenses where user_id= ?1",
			nativeQuery = true
			
			)
	public Double getTotalExpenseOfUser(int id);
	
	@Query(
			value = "select sum(expense_amount) from expenses where user_id= ?1 and expense_type=?2",
			nativeQuery = true
			
			)
	public double getTotalExpenseByType(int id, String type);
	
	@Query(
			value = "select sum(expense_amount) from expenses where user_id= ?1 and date_added between ?2 and ?3",
			nativeQuery = true
			
			)
	public double getTotalExpenseById(int id, LocalDate startDate, LocalDate endDate);
	
	@Query(
			value = "select sum(expense_amount) from expenses where user_id= ?1 and date_added=?2",
			nativeQuery = true
			
			)
	public double getExpenseByDateAndUserId(int id,LocalDate date);

}
