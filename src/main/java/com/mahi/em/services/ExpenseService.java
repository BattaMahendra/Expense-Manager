package com.mahi.em.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahi.em.entity.Expenses;
import com.mahi.em.entity.User;
import com.mahi.em.repos.ExpensesRepository;
import com.mahi.em.repos.UserRepository;

@Service
public class ExpenseService {
	
	
	
	private UserRepository uRepo;
	
	public ExpenseService(UserRepository uRepo) {
		super();
		this.uRepo = uRepo;
	}



	@Autowired
	ExpensesRepository expensesRepo;
	
//	@Autowired
//	private UserRepository uRepo;
	
	
	
	public Expenses addExpense(Expenses expense) {
		
		User u1=new User();
		
		double budget=uRepo.findById(
				
				expense.getUser().getId())
				
				
				
				.get().getBudget();
		
		
		double changedBudget=budget-expense.getExpenseAmount();
		
		u1=uRepo.getById(expense.getUser().getId());
		
//		u1=uRepo.getById(expense.getUser().getId());
		
		u1.setBudget(changedBudget);
		
		expense.setUser(u1);
		
		
		return expensesRepo.save(expense);
		
		
		
		
	}
	
}
