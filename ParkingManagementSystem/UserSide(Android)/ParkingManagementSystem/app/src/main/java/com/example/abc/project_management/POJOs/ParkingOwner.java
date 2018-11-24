package com.example.abc.project_management.POJOs;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ParkingOwner implements Serializable {
	
	@SerializedName("ownerid")
	Integer ownerid;

	@SerializedName("owneremailid")
	String owneremailid;

	@SerializedName("firstname")
	String firstname;

	@SerializedName("lastname")
	String lastname;

	@SerializedName("password")
	String password;

	@SerializedName("location")
	String location;

	@SerializedName("organisation")
	String  organisation;

	@SerializedName("totalslot")
	Integer totalslot;

	@SerializedName("mobileno")
	Long mobileno;

	public ParkingOwner(Integer ownerid, String owneremailid, String firstname, String lastname, String password, String location, String organisation, Integer totalslot, Long mobileno) {
		this.ownerid = ownerid;
		this.owneremailid = owneremailid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.location = location;
		this.organisation = organisation;
		this.totalslot = totalslot;
		this.mobileno = mobileno;
	}

	public void setOwnerid(Integer ownerid) {
		this.ownerid = ownerid;
	}

	public void setOwneremailid(String owneremailid) {
		this.owneremailid = owneremailid;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public void setTotalslot(Integer totalslot) {
		this.totalslot = totalslot;
	}

	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}

	public Integer getOwnerid() {
		return ownerid;
	}

	public String getOwneremailid() {
		return owneremailid;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getPassword() {
		return password;
	}

	public String getLocation() {
		return location;
	}

	public String getOrganisation() {
		return organisation;
	}

	public Integer getTotalslot() {
		return totalslot;
	}

	public Long getMobileno() {
		return mobileno;
	}
}
