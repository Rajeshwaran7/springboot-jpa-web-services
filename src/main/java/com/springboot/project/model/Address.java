package com.springboot.project.model;


import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@Table(name = "address")
public class Address 
{
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long traine_id;
	  @Column(name="door_no" ,table="address") //@Pattern(regexp="(^$|[0-9]{10})") 
	   private String door_no;
	   @Column(name="land_mark",table="address")   //@Pattern(regexp = "^[A-Za-z]\\w{5,29}$")
	   private String land_mark;
	   @Column(name="street_name",table="address")  //@Pattern(regexp = "^[A-Za-z]\\w{5,29}$")
	   private String street_name;
	   @Column(name="pincode",table="address")  //@Pattern(regexp="(^$|[0-9]{6})")
	   private String pincode;
	   @Column(name="city",table="address") //@Pattern(regexp = "^[A-Za-z]\\w{5,29}$")
	   private String city;
	   @Column(name="state",table="address") // @Pattern(regexp = "^[A-Za-z]\\w{5,29}$")
	   private String  state;
	   @Column(name = "country",table="address") // @Pattern(regexp = "^[A-Za-z]\\w{5,29}$")
	   private String country;
	
	public Address()
	   {
		   
	   }
	public Address(String door_no, String land_mark, String street_name, String pincode, String city, String state,	String country ) 
	{
			super();
			this.door_no = door_no;
			this.land_mark = land_mark;
			this.street_name = street_name;
			this.pincode = pincode;
			this.city = city;
	 	    this.state = state;
			this.country = country;
			//this.traine_id=traine_id;
		
	}
	
	public String getDoor_no() {
		return door_no;
	}
	public void setDoor_no(String door_no) {
		this.door_no = door_no;
	}
	public String getLand_mark() {
		return land_mark;
	}
	public void setLand_mark(String land_mark) {
		this.land_mark = land_mark;
	}
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	  }

