package com.example.abc.project_management.POJOs;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {

	@SerializedName("bookingid")
	Integer bookingid;

	@SerializedName("userid")
	Integer userid;

	@SerializedName("ownerid")
	Integer ownerid;

	@SerializedName("vehicleno")
	String vehicleno;

	@SerializedName("slotid")
	Integer slotid;

	@SerializedName("entrytime")
	String entrytime;

	@SerializedName("exittime")
	String exittime;

	@SerializedName("bookingdate")
	String bookingdate;

	public Integer getBookingid() {
		return bookingid;
	}

	public void setBookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(Integer ownerid) {
		this.ownerid = ownerid;
	}

	public String getVehicleno() {
		return vehicleno;
	}

	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
	}

	public Integer getSlotid() {
		return slotid;
	}

	public void setSlotid(Integer slotid) {
		this.slotid = slotid;
	}

	public String getEntrytime() {
		return entrytime;
	}

	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
	}

	public String getExittime() {
		return exittime;
	}

	public void setExittime(String exittime) {
		this.exittime = exittime;
	}

	public String getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}
}
