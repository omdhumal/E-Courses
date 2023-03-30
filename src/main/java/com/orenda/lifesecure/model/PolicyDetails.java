package com.orenda.lifesecure.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_policy_details")
public class PolicyDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "policy_id")
	private int policyId;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "policy_type")
	private String policyType;

	@Column(name = "policy_sdate")
	private Date policyStartDate;

	@Column(name = "policy_edate")
	private Date policyEndDate;

	@Column(name = "policy_pamount")
	private double premiumAmount;

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public Date getPolicyStartDate() {
		return policyStartDate;
	}

	public void setPolicyStartDate(Date policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	public Date getPolicyEndDate() {
		return policyEndDate;
	}

	public void setPolicyEndDate(Date policyEndDate) {
		this.policyEndDate = policyEndDate;
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "PolicyDetails [policyId=" + policyId + ", customerId=" + customerId + ", policyType=" + policyType
				+ ", policyStartDate=" + policyStartDate + ", policyEndDate=" + policyEndDate + ", premiumAmount="
				+ premiumAmount + "]";
	}

}