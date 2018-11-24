package com.ParkingSystem.Controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ParkingSystem.Entity.Booking;
import com.ParkingSystem.Entity.ParkingOwner;
import com.ParkingSystem.Entity.SlotDetails;
import com.ParkingSystem.Repository.BookingRepository;
import com.ParkingSystem.Repository.ParkingOwnerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/ParkingOwner")
public class ParkingOwnerController {

	@Autowired
	private ParkingOwnerRepository parkingOwnerRepo;
	
//	@Autowired
//	private ParkingOwner parkingOwnerEntiry;
	
	@Autowired
	private BookingRepository bookingRepo;
	
	//.......................Add Owner...............................
	@RequestMapping(value="/addOwner", method=RequestMethod.POST)
	public ParkingOwner addParkingOwner(@RequestBody JsonNode parkingOwner) 
	{
		ParkingOwner owner = new ParkingOwner();
//		owner.setTotalslot(parkingOwner.get("totalslot"));
		owner.setFirstname(parkingOwner.get("firstname").toString().replaceAll("\"", ""));
		owner.setLastname(parkingOwner.get("lastname").toString().replaceAll("\"", ""));
		owner.setOwneremailid(parkingOwner.get("owneremailid").toString().replaceAll("\"", ""));
		owner.setPassword(parkingOwner.get("password").toString().replaceAll("\"", ""));
		owner.setLocation(parkingOwner.get("location").toString().replaceAll("\"", ""));
		owner.setOrganisation(parkingOwner.get("organisation").toString().replaceAll("\"", ""));
		owner.setMobileno(Long.parseLong(parkingOwner.get("mobileno").toString().replaceAll("\"", "")));
		owner.setTotalslot(Integer.parseInt(parkingOwner.get("totalslot").toString().replaceAll("\"", "")));
		
		System.out.println(owner.getFirstname());
		System.out.println(owner.getLastname());
		System.out.println(owner.getLocation());
		System.out.println(owner.getMobileno());
		System.out.println(owner.getOwneremailid());
		System.out.println(owner.getPassword());
		System.out.println(owner.getTotalslot());
		System.out.println(owner.getOrganisation());
		
		return parkingOwnerRepo.save(owner);
	}
	
//	......................findByOwnerEmailId..............................
	@RequestMapping(value="/findByOwnerEmailid/{owneremailid}", method=RequestMethod.GET)
	public ParkingOwner findByOwnerEmailId(@PathVariable String owneremailid) {
		System.out.println("..............."+owneremailid);
		return parkingOwnerRepo.findByOwneremailid(owneremailid);		
	}

//	......................findAllByOrganisation..............................	
	@RequestMapping(value="/Organisation/{organisation}", method=RequestMethod.POST , produces = {MediaType.APPLICATION_JSON_VALUE})
	public SlotDetails findByOrganisation(@PathVariable String organisation) {
//		System.out.println("..............."+organisation);
		
		SlotDetails slotDetails = new SlotDetails();
		
		ParkingOwner p = parkingOwnerRepo.findByOrganisation(organisation);
		
		slotDetails.setOwner(p);
		
//		Integer slot = p.getTotalslot();
//		
//		System.out.println("OWID : " + p.getOwnerid());
//				
//		int[] slotid = new int[slot+1];
//		List<Integer> l = new ArrayList<Integer>(); 
//		l.add(0, slot);
		
		List<Booking> b = bookingRepo.findByOwnerid(p.getOwnerid());
		
		slotDetails.setBooking(b);
		
//		for(int i=0;i<b.size();i++)
//		{
//			Booking bb=b.get(i);
//			slotid[i] =bb.getSlotid(); 
//			l.add(i+1, slotid[i]);
////			System.out.println("...,,,," + slotid[i]);
//		}
//				for(int s : l) {
//					System.out.println("====" + s);
//				}
//		System.out.println("........slot : " + slot);
		return slotDetails;
	}
	

	
	//......................Owner Login..............................	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<String> ownerLogin(@RequestBody ParkingOwner parkingowner){
		ResponseEntity<String> response=null;
//		try
//		{
			ParkingOwner po = parkingOwnerRepo.findByOwneremailid(parkingowner.getOwneremailid());
			System.out.println("Entered Value : " + parkingowner.getOwneremailid() + " " + parkingowner.getPassword());
			JSONObject userJson = new JSONObject();
			if(po != null)
			{
				System.out.println(po.getPassword()+"="+parkingowner.getPassword());
				if(po.getPassword().equals(parkingowner.getPassword()))
				{
					userJson.put("status","true");
					userJson.put("msg","Login Sucessfulll...!!!");
					userJson.put("email",parkingowner.getOwneremailid());
					userJson.put("password", parkingowner.getPassword());					
					System.out.println("Login.......................");
				}
				else
				{
					userJson.put("status","false");
					userJson.put("msg","Wrong Password...!!!");
					System.out.println("Wrong Username or Password");	
				}
			}
			else
			{
				userJson.put("status","false");
				userJson.put("msg","User not Registered...!!!");
				System.out.println("User Not Registered");
			}
			
			response = new ResponseEntity<>(userJson.toString(),HttpStatus.OK);
//		}
//		catch(Exception e)
//		{ 
//			response=new ResponseEntity<>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		return response;
	}
}
