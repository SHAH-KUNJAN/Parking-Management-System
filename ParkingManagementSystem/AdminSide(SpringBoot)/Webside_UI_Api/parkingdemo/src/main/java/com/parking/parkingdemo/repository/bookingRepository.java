package com.parking.parkingdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.parking.parkingdemo.entity.parkingtable;
import com.parking.parkingdemo.entity.registration;

@Repository
public interface bookingRepository  extends CrudRepository<parkingtable, Integer>{
	public parkingtable findBySlotid(int id);

	 public parkingtable deleteByUseremailid(String string);
	
	
	
}
