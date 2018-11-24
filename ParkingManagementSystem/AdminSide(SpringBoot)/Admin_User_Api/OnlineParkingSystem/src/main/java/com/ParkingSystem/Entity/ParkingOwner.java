package com.ParkingSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parkingowner")
public class ParkingOwner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int ownerid;	
		
	String owneremailid;
	String firstname;
	String lastname;	
	String password;
	String location;
	String  organisation;
	int totalslot;
	long mobileno;
	
	public int getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}
	public String getOwneremailid() {
		return owneremailid;
	}
	public void setOwneremailid(String owneremailid) {
		this.owneremailid = owneremailid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getTotalslot() {
		return totalslot;
	}
	public void setTotalslot(int totalslot) {
		this.totalslot = totalslot;
	}
	
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	
}
