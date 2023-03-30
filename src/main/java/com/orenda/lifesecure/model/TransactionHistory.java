package com.orenda.lifesecure.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tbl_transaction_history" )
public class TransactionHistory 
{
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="trans_id")
	private int id;
	
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="transaction_status")
	private String transactionStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	@Override
	public String toString() {
		return "TransactionHistory [id=" + id + ", customerId=" + customerId + ", amount=" + amount + ", date=" + date
				+ ", transactionStatus=" + transactionStatus + "]";
	}
	

	
	

}
