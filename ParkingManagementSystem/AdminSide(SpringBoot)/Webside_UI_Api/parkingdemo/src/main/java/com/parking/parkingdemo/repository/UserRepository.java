package com.parking.parkingdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.parking.parkingdemo.entity.parkingtable;
import com.parking.parkingdemo.entity.registration;


@Repository
public interface UserRepository extends CrudRepository<registration, Integer>{

	parkingtable save(parkingtable park);
	registration findByUseremailid(String owneremailid);
	
}
