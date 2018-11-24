package com.ParkingSystem.Entity;

public class BookingDetails {
	
	String vehicleno;
    String entrytime;
    String exittime;
    int slotid;
    String useremailid;
    String organisation;
	public String getVehicleno() {
		return vehicleno;
	}
	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
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
	public int getSlotid() {
		return slotid;
	}
	public void setSlotid(int slotid) {
		this.slotid = slotid;
	}
	public String getUseremailid() {
		return useremailid;
	}
	public void setUseremailid(String useremailid) {
		this.useremailid = useremailid;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
}
