package com.orenda.lifesecure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_address_current")
public class CurrentAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_cur_id")
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

	@OneToOne(mappedBy = "caddress")
	private UserDetails userdetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "CurrentAddress [id=" + id + ", address=" + address + ", landMark=" + landMark + ", addArea=" + addArea
				+ ", state=" + state + ", district=" + district + ", tahsil=" + tahsil + ", village=" + village
				+ ", pincode=" + pincode + ", userdetails=" + userdetails + "]";
	}

}
