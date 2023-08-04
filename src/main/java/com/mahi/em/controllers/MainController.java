package com.mahi.em.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahi.em.entity.Expenses;
import com.mahi.em.entity.User;
import com.mahi.em.exceptions.ResourceNotFound;
import com.mahi.em.repos.ExpensesRepository;
import com.mahi.em.repos.UserRepository;
import com.mahi.em.services.ExpenseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/app")
public class MainController {
	
	@Autowired
	ExpensesRepository expenses;
	
	@Autowired
	ExpenseService service;
	
	@Autowired
	UserRepository uRepo;
	
	@GetMapping("/u")
	public List<User> getAllUsers(){
		log.info("the users are {}", uRepo.findAll().get(0));
		return uRepo.findAll();
	}
	
	@GetMapping("/u/{id}")
	public Optional<User> getAllUserById(@PathVariable int id) throws ResourceNotFound{
		return Optional.ofNullable(uRepo.findById(id).orElseThrow(()->new ResourceNotFound("id", "user", id)));
//		User user=new User();
//		try {
//		user=uRepo.findById(id).get();
//		return user;
//		}catch(Exception ex) {
//			throw new ResourceNotFound("id", "user", id);
//		}
		
	}
	
	
	@GetMapping("/e")
	public List<Expenses> getAllExpenses(){
		return Optional.ofNullable( expenses.findAll() ).orElseThrow(()->new ResourceNotFound("expenses"));
	}
	
	@PostMapping("/pu")
	public User addUser(@Valid @RequestBody User user) {
		return uRepo.save(user);
	}
	
	@PostMapping("/pe")
	public Expenses addExpense(@RequestBody Expenses exp) {
		return service.addExpense(exp);
	}

	@GetMapping("/gE/{id}")
	public Double getAllExpenseByUserId(@PathVariable int id) {
		return Optional.ofNullable(expenses.getTotalExpenseOfUser(id)).orElseThrow(()->new ResourceNotFound("user","expenses",id));
	}
	
	@GetMapping("/gE/{id}/type/{type}")
	public double getAllExpenseByUserIdAndType(@PathVariable int id , @PathVariable String type) {
		return Optional.ofNullable(expenses.getTotalExpenseByType(id, type)).orElseThrow(()->new ResourceNotFound("type","expenses",type));
	}
	
	@GetMapping("/gE/{id}/{startDate}/{endDate}")
	public double getAllExpenseByUserIdByDate(@PathVariable int id , @PathVariable String startDate,@PathVariable String endDate) {
		
		
		
		return Optional.ofNullable( expenses.getTotalExpenseById(id, LocalDate
				.of(Integer.parseInt(startDate.substring(0, 4)), 
						Integer.parseInt(startDate.substring(5, 7)),
						Integer.parseInt(startDate.substring(8))),
				LocalDate
				.of(Integer.parseInt(endDate.substring(0, 4)), 
						Integer.parseInt(endDate.substring(5, 7)),
						Integer.parseInt(endDate.substring(8)))))
				.orElseThrow(()->new ResourceNotFound("expense"));
	}
	
	@GetMapping("/gE/{id}/{Date}")
	public double getExpenseByUserIdByDate(@PathVariable int id , @PathVariable String Date) {
		
		
		
		return Optional.ofNullable( expenses.getExpenseByDateAndUserId(id, LocalDate
				.of(Integer.parseInt(Date.substring(0, 4)), 
						Integer.parseInt(Date.substring(5, 7)),
						Integer.parseInt(Date.substring(8)))))
				.orElseThrow(()->new ResourceNotFound("expense"));
			
	}
	
//	@GetMapping("/gB/{userId}")
//	public Optional<Double> getBudgetByUserId(@PathVariable int userId) throws ResourceNotFound {
//		
//		return Optional.ofNullable(uRepo.findBudgetByUserId(userId).orElseThrow(()->{
//			new ResourceNotFound(null, null, userId));
////		}));
////		
////		try {
////			return uRepo.findBudgetByUserId(userId);
////		}catch(Exception ex){
////			throw new ResourceNotFound("ID", "Budget", userId);
////		}
//		
////		Optional<Double> budget=uRepo.findBudgetByUserId(userId);
////		if(budget.isEmpty()) {
////			throw new ResourceNotFound("ID", "Budget", userId);
////		}else {
////			return budget;
////		}
//		
//	}
	
}
