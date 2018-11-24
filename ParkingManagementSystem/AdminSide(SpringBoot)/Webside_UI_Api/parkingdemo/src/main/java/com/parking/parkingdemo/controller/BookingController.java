package com.parking.parkingdemo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.parking.parkingdemo.entity.parkingtable;
import com.parking.parkingdemo.entity.registration;
import com.parking.parkingdemo.repository.UserRepository;
import com.parking.parkingdemo.repository.bookingRepository;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class BookingController {
	
	parkingtable p = new parkingtable();
	
	@Autowired
	private UserRepository registrationrepo;
	
	@Autowired
	private bookingRepository bookrepo;
	
	@RequestMapping(value="/book" , method=RequestMethod.POST)
	public parkingtable booking(@RequestBody parkingtable park) {
	
		return registrationrepo.save(park);
	}	
	
	@GetMapping(value="/getallbooking")
	public List<parkingtable> getallbooking() {
		System.out.println("entry time ::"+p.getEntrytime()); 
		
		return (List<parkingtable>) bookrepo.findAll();
		 
	}
	
	@RequestMapping(value="/{slotid}",method=RequestMethod.GET)
	public parkingtable FindBrandByBrandName(@PathVariable  int slotid)
	{
	
		return bookrepo.findBySlotid(slotid);
	}
	
	@RequestMapping(value="/latest/{currentdate}", method = RequestMethod.GET)
	public List<parkingtable> getlatestbooking(Date todaydate){
	  	
		return null;	
	}
	
	@RequestMapping(value="/delete/{useremailid}",method=RequestMethod.GET)
	public void delete(@PathVariable String useremailid) {
		
		
		List<parkingtable> pp = new ArrayList<>();
		System.out.println( );
		Iterator ite=pp.iterator();
		while(ite.hasNext())
		{
			parkingtable pt=(parkingtable)ite.next();
			
			
			
		}
		
		bookrepo.deleteByUseremailid("mihir@gmail.com");
		
	}	
}
