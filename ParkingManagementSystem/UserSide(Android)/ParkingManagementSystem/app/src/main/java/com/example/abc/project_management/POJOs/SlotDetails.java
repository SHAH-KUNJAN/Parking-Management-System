package com.example.abc.project_management.POJOs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SlotDetails {

	@SerializedName("owner")
	ParkingOwner Owner;

	@SerializedName("booking")
	List<Booking> booking;
	
	public ParkingOwner getOwner() {
		return Owner;
	}
	public void setOwner(ParkingOwner owner) {
		Owner = owner;
	}
	public List<Booking> getBooking() {
		return booking;
	}
	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}
	
}
