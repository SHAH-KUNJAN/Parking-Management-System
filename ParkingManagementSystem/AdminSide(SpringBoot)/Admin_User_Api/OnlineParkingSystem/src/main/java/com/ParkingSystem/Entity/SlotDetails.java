package com.ParkingSystem.Entity;

import java.util.List;

public class SlotDetails {

	ParkingOwner Owner;
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
