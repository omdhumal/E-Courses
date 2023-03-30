package com.orenda.lifesecure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_address_permanent")
public class PermanentAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_perm_id")
	private int id;

	@Column(name = "address")
	private String address;

	@Column(name = "landmark")
	private String landMark;

	@Column(name = "add_area")
	private String addArea;

	@Column(name = "state")
	private String state;

	@Column(name = "district")
	private String district;

	@Column(name = "tahsil")
	private String tahsil;

	@Column(name = "village")
	private String village;

	@Column(name = "pincode")
	private Long pincode;

	public UserDetails getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}

	@OneToOne(mappedBy = "paddress")
	private UserDetails userdetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getAddArea() {
		return addArea;
	}

	public void setAddArea(String addArea) {
		this.addArea = addArea;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getTahsil() {
		return tahsil;
	}

	public void setTahsil(String tahsil) {
		this.tahsil = tahsil;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "PermanentAddress [id=" + id + ", address=" + address + ", landMark=" + landMark + ", addArea=" + addArea
				+ ", state=" + state + ", district=" + district + ", tahsil=" + tahsil + ", village=" + village
				+ ", pincode=" + pincode + ", userdetails=" + userdetails + "]";
	}

}
