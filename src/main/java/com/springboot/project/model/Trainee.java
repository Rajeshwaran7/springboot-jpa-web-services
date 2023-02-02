package com.springboot.project.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import lombok.Data;


@Data
@Entity
@Table(name="trainee")
public class Trainee 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long traine_id;
	@Column @Pattern(regexp = "^[\\p{L} .'-]+$")
	private String name;
	@Column  @Pattern(regexp="(^$|[0-9]{10})") 
	private String mobileNumber;
	
	@Column  @Pattern(regexp = "^(((0[1-9]|[12][0-9]|30)[-/]?(0[13-9]|1[012])|31[-/]?(0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-/]?02)[-/]?[0-9]{4}|29[-/]?02[-/]?([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$")
	private String dateOfBirth;
	
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="traine_id",referencedColumnName = "traine_id")
	private Address address;
	public Trainee()
	{}
	public Trainee(String name, String mobileNumber, String dateOfBirth, Address address) 
	{
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.address=address;
	}

	
	public Long getTraineId()
    {
		return traine_id;
    }
	public void setTraineId(Long traineId) 
	{
		this.traine_id = traineId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getMobileNumber() 
	{
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) 
	{
		this.mobileNumber = mobileNumber;
	}
	public String getDateOfBirth()
	{
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) 
	{
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
