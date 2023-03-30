package com.orenda.lifesecure.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_login")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "login_id")
	private int id;
	@Column(name = "user_email")
	private String email;

	@Column(name = "user_password")
	private String password;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "updated_time")
	private Date updateTime;

	@Column(name = "pass_valid_from")
	private LocalDate passwordValidFrom;

	@Column(name = "pass_valid_till")
	private LocalDate passwordValidTill;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public LocalDate getPasswordValidFrom() {
		return passwordValidFrom;
	}

	public void setPasswordValidFrom(LocalDate passwordValidFrom) {
		this.passwordValidFrom = passwordValidFrom;
	}

	public LocalDate getPasswordValidTill() {
		return passwordValidTill;
	}

	public void setPasswordValidTill(LocalDate passwordValidTill) {
		this.passwordValidTill = passwordValidTill;
	}

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", isActive=" + isActive
				+ ", updateTime=" + updateTime + ", passwordValidFrom=" + passwordValidFrom + ", passwordValidTill="
				+ passwordValidTill + "]";
	}

}
