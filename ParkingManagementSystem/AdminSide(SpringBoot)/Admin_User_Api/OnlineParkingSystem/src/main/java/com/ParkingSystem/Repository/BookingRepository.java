package com.ParkingSystem.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ParkingSystem.Entity.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer>{	
	
	List<Booking> findAll();
	Booking save(Booking booking);
	Booking findByBookingdate(String bookingdate);
	Booking findBySlotid(int id);
//	List<Booking> findByOwnerid(int ownerid);
	List<Booking> findByOwnerid(int ownerid);
}
