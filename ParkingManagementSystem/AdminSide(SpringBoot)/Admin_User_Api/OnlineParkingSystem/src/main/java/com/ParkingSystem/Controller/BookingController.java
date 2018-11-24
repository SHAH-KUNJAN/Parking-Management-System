package com.ParkingSystem.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ParkingSystem.Entity.Booking;
import com.ParkingSystem.Entity.BookingDetails;
import com.ParkingSystem.Entity.ParkingOwner;
import com.ParkingSystem.Entity.SlotDetails;
import com.ParkingSystem.Repository.BookingRepository;
import com.ParkingSystem.Repository.ParkingOwnerRepository;
import com.ParkingSystem.Repository.UserRepository;
import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/user")
public class BookingController {
	
	@Autowired
	BookingRepository bookingRepo;
	
	@Autowired
	ParkingOwnerRepository parkingOwnerRepo;
	
	@Autowired
	UserRepository userRepo;
	
//	@Autowired
//	Booking bookingEntity;
	
	@RequestMapping(value="/addBooking" , method=RequestMethod.POST)
	public Booking addBooking(@RequestBody BookingDetails bookDetails) //throws ParseException 
	{
//		BookingDetails bookingDetails = new BookingDetails();
		Booking b = new Booking();
		ParkingOwner p = new ParkingOwner();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    Date date = new Date();  
	    String strDate = formatter.format(date);
	    System.out.println(".....date : "   + strDate);
		
		
		
//		bookingDetails.getUseremailid(userRepo.findByUseremailid(bookDetails.getUseremailid()).getUserid());
//		bookingDetails.getUseremailid();
//		userRepo.findByUseremailid(bookingDetails.getUseremailid()).getUserid();
	    System.out.println(bookDetails.getVehicleno());
	    System.out.println("dasda " + bookDetails.getUseremailid());
	    int uid = userRepo.findByUseremailid(bookDetails.getUseremailid()).getUserid();
	    System.out.println("uid : " + uid);
	    int oid = parkingOwnerRepo.findByOrganisation(bookDetails.getOrganisation()).getOwnerid();	
//	    System.out.println("org : " + bookDetails.getOrganisation());
	    System.out.println("oid : " + oid);
	    
	    
	    b.setUserid(userRepo.findByUseremailid(bookDetails.getUseremailid()).getUserid());
		b.setOwnerid(parkingOwnerRepo.findByOrganisation(bookDetails.getOrganisation()).getOwnerid());
		b.setBookingdate(strDate);
		b.setSlotid(bookDetails.getSlotid());		
		b.setVehicleno(bookDetails.getVehicleno());
		b.setEntrytime(bookDetails.getEntrytime());
		b.setExittime(bookDetails.getExittime());
		
	
		
		
			
		/*b.setVehicleno(book.get("vehicleno").toString().replaceAll("\"", ""));
		b.setSlotid(Integer.parseInt(book.get("slotid").toString().replaceAll("\"", "")));		
		b.setBookingdate(book.get("bookingdate").toString().replaceAll("\"", ""));		
		b.setUserid(Integer.parseInt(book.get("userid").toString().replaceAll("\"", "")));
		
		
		String entrytimeString = book.get("entrytime").toString().replaceAll("\"", "");*/
		
//		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
//		Date date = new Date();
//		String strDate = formatter.format(date);		
						
//		System.out.println("entrytime :" + entrytimeString);
//		 Date date1=new SimpleDateFormat("hh:mm").parse(entrytimeString);  
//		java.util.Date d1 =(java.util.Date)formatter.parse(entrytimeString);
//		Date d1 = formatter.parse(entrytimeString);
//		 System.out.println("date1....." + d1);
		
		
		//b.setEntrytime(entrytimeString);
	
//		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//		Date date2 = new Date();		
//		b.setEntrytime(date2);
		
		//String exittimeString = book.get("exittime").toString().replaceAll("\"", "");
//		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
//		Date date3 = new Date();		
	//	b.setExittime(exittimeString);
		
	//	b.setOwnerid(Integer.parseInt(book.get("ownerid").toString().replaceAll("\"", "")));
	
//		ParkingOwner p = parkingOwnerRepo.findByOrganisation();
	
		return bookingRepo.save(b);		
	}	
	
	@RequestMapping(value="/slot/{slotid}",method=RequestMethod.GET)
	public Booking FindBrandByBrandName(@PathVariable  int slotid)
	{
		return bookingRepo.findBySlotid(slotid);
	}
	
	@RequestMapping(value="/getAllBooking", method=RequestMethod.GET)
	public List<Booking> getAllBooking(){
//		String date2 = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
//		System.out.println(",,,,,,,,,,,.........,,,,,,"+date2);
		return bookingRepo.findAll();	
	}
		
	@RequestMapping(value="/getByBookingDate/{bookingdate}", method=RequestMethod.GET)
	public Booking getByEntrydate(@PathVariable String bookingdate)
	{
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = new Date();
//		System.out.println(formatter.format(date));
//		System.out.println("........................."+java.time.LocalDate.now());		
//		bookingdate = formatter.format(date); 
//		System.out.println("........"+date);		
		
		bookingdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		System.out.println(bookingdate);
		
		
		return bookingRepo.findByBookingdate(bookingdate);	
	}
	
/*	@RequestMapping(value="/Organisation/{organisation}",method=RequestMethod.GET)
	public List<Booking> getBookingSlot(@PathVariable  String organisation)
	{
		return bookingRepo.findByOwnerid(parkingOwnerRepo.findByOrganisation(organisation).getOwnerid());
		
//		return bookingRepo.findBySlotid(slotid);
	} */
	
	/*update time starts from here*/
	
	
	
	/*@RequestMapping(value="/updatetime" , method=RequestMethod.POST)
	public Booking updatetime(@RequestBody BookingDetails booking) {
		Booking b = new Booking();
		ParkingOwner p = new ParkingOwner();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    Date date = new Date();  
	    String strDate = formatter.format(date);
	    System.out.println(".....date : "   + strDate);
		return
	}*/
}
