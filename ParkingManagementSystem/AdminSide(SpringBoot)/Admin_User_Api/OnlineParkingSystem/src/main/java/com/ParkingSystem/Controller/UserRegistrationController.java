package com.ParkingSystem.Controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ParkingSystem.Entity.ParkingOwner;
import com.ParkingSystem.Entity.user;
import com.ParkingSystem.Repository.UserRepository;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/user")
public class UserRegistrationController {
	
	@Autowired
	private UserRepository registrationRepo;
	
//	@Autowired
//	private user registrationEntity;
	
	@RequestMapping(value="/getdata", method=RequestMethod.GET)
	public List<user> getuser() {
		return (List<user>) registrationRepo.findAll();		
	}
	
	//.........................Add User.........................
	@RequestMapping(value="/add" , method=RequestMethod.POST)
	public user registrationuser(@RequestBody user reg) 
	{			
		ResponseEntity<String> response=null;
//		System.out.println(reg.getFirstname());
//		System.out.println(reg.getLastname());
//		System.out.println(reg.getLicence());
//		System.out.println(reg.getMobileno());
//		System.out.println(reg.getUseremailid());
//		System.out.println(reg.getPassword());				
		
		response = new ResponseEntity<>(HttpStatus.OK);
		System.out.println(response.toString() + HttpStatus.OK + ".......");
		return registrationRepo.save(reg);
		
	}
	
	//......................User Login..............................
	
		@RequestMapping(value="/login", method=RequestMethod.POST)
		public String userLogin(@RequestBody user reg){
			ResponseEntity<String> response=null;
			String check;
//			try
//			{
				user r = registrationRepo.findByUseremailid(reg.getUseremailid());
				System.out.println("Entered Value : " + reg.getUseremailid() + " " + reg.getPassword());
				JSONObject userJson = new JSONObject();
				if(r != null)
				{
					System.out.println(r.getPassword()+"="+reg.getPassword());
					if(r.getPassword().equals(reg.getPassword()))
					{
//						userJson.put("status","true");
//						userJson.put("msg","Login Sucessfulll...!!!");
//						userJson.put("email",loginUser.getEmailid());
//						userJson.put("password", loginUser.getPassword());
//						userJson.put("token",userService.login(loginUser));
						check = "Login";
						System.out.println("Login.......................");
					}
					else
					{
//						userJson.put("status","false");
//						userJson.put("msg","Wrong Password...!!!");
						check = "Password Wrong";
						System.out.println("Wrong Username or Password");	
					}
				}
				else
				{
//					userJson.put("status","false");
//					userJson.put("msg","User not Registered...!!!");
					check = "Emailid wrong";
					System.out.println("User Not Registered");
				}
				
				response = new ResponseEntity<>(userJson.toString(),HttpStatus.OK);
//			}
//			catch(Exception e)
//			{ 
//				response=new ResponseEntity<>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
//			}
			return check;
		}
}