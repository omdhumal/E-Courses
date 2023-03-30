package com.orenda.lifesecure.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user_details")
public class UserDetails {

	@Id
	@Column(name = "user_id")
	private int id;
	@Column(name = "user_fname")
	private String firstName;

	@Column(name = "user_mname")
	private String middleName;

	@Column(name = "user_lname")
	private String lastName;

	@Column(name = "user_type")
	private String usertype;

	@Column(name = "user_gender")
	private String gender;

	@Column(name = "user_dob")
	private Date dob;

	@Column(name = "user_prim_contact")
	private Long primaryContact;

	@Column(name = "user_alt_contact")
	private Long alternateContact;

	@Column(name = "user_email")
	private String email;

	@Column(name = "user_gov_id_image")
	private byte[] image;

	@Column(name = "user_gov_id_type")
	private String idType;

	@Column(name = "user_gov_id_number")
	private String adhaarNumber;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_perm_id")
	private PermanentAddress paddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_cur_id")
	private PermanentAddress caddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}


	public PermanentAddress getCaddress() {
		return caddress;
	}

	public void setCaddress(PermanentAddress caddress) {
		this.caddress = caddress;
	}

	public PermanentAddress getPaddress() {
		return paddress;
	}

	public void setPaddress(PermanentAddress paddress) {
		this.paddress = paddress;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Long getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(Long primaryContact) {
		this.primaryContact = primaryContact;
	}

	public Long getAlternateContact() {
		return alternateContact;
	}

	public void setAlternateContact(Long alternateContact) {
		this.alternateContact = alternateContact;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getAdhaarNumber() {
		return adhaarNumber;
	}

	public void setAdhaarNumber(String adhaarNumber) {
		this.adhaarNumber = adhaarNumber;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", usertype=" + usertype + ", gender=" + gender + ", dob=" + dob + ", primaryContact="
				+ primaryContact + ", alternateContact=" + alternateContact + ", email=" + email + ", idType=" + idType + ", adhaarNumber=" + adhaarNumber + ", paddress="
				+ paddress + ", caddress=" + caddress + "]";
	}

	



	

}
