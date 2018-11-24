package com.parking.parkingdemo.entity;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class parkingtable {
	
	@Id
	private int bookingid;
	private String useremailid;
	private String vehicleno;
	private int slotid;	
	private Date entrytime;
	private Date exittime;
	private String bookingdate;
	private String location;
	private long mobileno;
	
	
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public String getUseremailid() {
		return useremailid;
	}
	public void setUseremailid(String useremailid) {
		this.useremailid = useremailid;
	}
	public String getVehicleno() {
		return vehicleno;
	}
	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
	}
	public int getSlotid() {
		return slotid;
	}
	public void setSlotid(int slotid) {
		this.slotid = slotid;
	}
	public Date getEntrytime() {
		 Date date = new Date();
		SimpleDateFormat sm = new SimpleDateFormat("hh:mm");
		String strDate = sm.format(date);
		return entrytime;
	}
	public void setEntrytime(Date entrytime) {
		this.entrytime = entrytime;
	}
	public Date getExittime() {
		return exittime;
	}
	public void setExittime(Date exittime) {
		this.exittime = exittime;
	}
	public String getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	
	
}
