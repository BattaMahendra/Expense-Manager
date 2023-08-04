package com.mahi.em.entity;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(
		
		uniqueConstraints = @UniqueConstraint(
				name="userName_unique",
				columnNames = "userName"
				)
		)
public class User {
	
	public User() {
		super();
	}
	public User(int id, String userName, String password, double budget) {
		super();
		this.userId = id;
		this.userName = userName;
		this.password = password;
		this.budget = budget;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	
	@Column(nullable=false)
	@NotNull(message = "the username should not be null")
	String userName;
	
	@NotBlank
	String password;
	
	@Min(0)
	double budget;
	
//	@OneToMany(mappedBy = "user")
//	private List<Expenses> expenses; 
	
	
	
	public int getId() {
		return userId;
	}
	public void setId(int id) {
		this.userId = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}

}
