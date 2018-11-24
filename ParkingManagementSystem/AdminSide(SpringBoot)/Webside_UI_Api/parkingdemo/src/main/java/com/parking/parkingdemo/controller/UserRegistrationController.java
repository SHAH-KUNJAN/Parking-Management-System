package com.parking.parkingdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parking.parkingdemo.entity.registration;
import com.parking.parkingdemo.repository.UserRepository;

import net.minidev.json.JSONObject;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserRegistrationController {
	
	@Autowired
	private UserRepository registrationrepo;
	
	@RequestMapping(value="/getdata", method=RequestMethod.GET)
	public List<registration> getuser() {
		return (List<registration>) registrationrepo.findAll();		
	}
	
	@RequestMapping(value="/add" , method=RequestMethod.POST)
		public registration registrationuser(@RequestBody registration reg) {
		
			return registrationrepo.save(reg);
	}	
	
	@RequestMapping(value="/alluser" , method=RequestMethod.GET)
	public List<registration> getalluser() {
	
		return (List<registration>) registrationrepo.findAll();
	}	
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<String> ownerLogin(@RequestBody registration parkingowner){
		ResponseEntity<String> response=null;
//		try
//		{
			registration po = registrationrepo.findByUseremailid(parkingowner.getUseremailid());
			System.out.println("Entered Value : " + parkingowner.getUseremailid()+ " " + parkingowner.getPassword());
			JSONObject userJson = new JSONObject();
			if(po != null)
			{
				System.out.println(po.getPassword()+"="+parkingowner.getPassword());
				if(po.getPassword().equals(parkingowner.getPassword()))
				{
					userJson.put("status","true");
					userJson.put("msg","Login Sucessfulll...!!!");
					userJson.put("email",parkingowner.getUseremailid());
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
