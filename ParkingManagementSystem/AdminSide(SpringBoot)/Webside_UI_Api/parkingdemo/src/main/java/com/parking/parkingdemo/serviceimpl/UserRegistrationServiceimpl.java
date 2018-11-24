/*package com.parking.parkingdemo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.parkingdemo.entity.registration;
import com.parking.parkingdemo.repository.UserRepository;
import com.parking.parkingdemo.userservice.UserRegistrationService;

@Service
public class UserRegistrationServiceimpl implements UserRegistrationService{
	@Autowired
	private UserRepository registrationRepository;
	
	
	public registration save(registration registration) {				
		return registrationRepository.save(registration);
	}
}
*/