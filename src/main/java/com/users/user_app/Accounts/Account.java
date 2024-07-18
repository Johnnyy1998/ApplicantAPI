package com.users.user_app.Accounts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.users.user_app.Applicants.Applicant;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Account {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Applicant applicant;
	
	
	@GeneratedValue//(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	@Size(min = 3, message = "BankCode should have at leas 3 characters")
	private String bankCode;
	private Integer accNumber;
	private Integer balance;
	
	public Account(String bankCode, Integer accNumber, Integer balance) {
		this.bankCode = bankCode;
		this.accNumber = accNumber;
		this.balance = balance;
	}
	
	public Account() {
		
	}
	
	public String getBankCode() {
		return this.bankCode;
	}
	public Integer getAccNumber() {
		return this.accNumber;
	}
	public Integer getBalance() {
		return this.balance;
	}
	public Integer getID() {
		return this.id;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public void setAccNumber(Integer accNumber) {
		this.accNumber = accNumber;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	

	@Override
	public String toString() {
		return "Account [bankCode=" + bankCode + ", accNumber=" + accNumber + ", balance=" + balance + "]";
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	

}
