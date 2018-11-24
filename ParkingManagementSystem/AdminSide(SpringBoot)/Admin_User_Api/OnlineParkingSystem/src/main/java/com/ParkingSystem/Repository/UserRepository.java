package com.ParkingSystem.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ParkingSystem.Entity.user;

@Repository
public interface UserRepository extends CrudRepository<user, Integer>{
	user save(user reg);
	user findByUseremailid(String useremailid);
}