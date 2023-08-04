package com.mahi.em.entity;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Expenses {
	
	public Expenses() {
		super();
	}

	public Expenses(long expenseId, LocalDate dateAdded, double expenseAmount, String expenseType, User user) {
		super();
		this.expenseId = expenseId;
		this.dateAdded = dateAdded;
		this.expenseAmount = expenseAmount;
		this.expenseType = expenseType;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long expenseId;
	
	
	LocalDate dateAdded;
	
	double expenseAmount;
	
	String expenseType;
	
	@ManyToOne(
			cascade = CascadeType.MERGE
			)
	@JoinColumn(
			
			name="user_id",
			referencedColumnName = "userId"
			)
	User user;

	public long getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(long expenseId) {
		this.expenseId = expenseId;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	public double getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	

}
