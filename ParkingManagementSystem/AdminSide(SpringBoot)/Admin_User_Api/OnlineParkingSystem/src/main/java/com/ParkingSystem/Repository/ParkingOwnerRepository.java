package com.ParkingSystem.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ParkingSystem.Entity.ParkingOwner;

@Repository
public interface ParkingOwnerRepository extends CrudRepository<ParkingOwner, String>{
	ParkingOwner save(ParkingOwner parkingOwner);
	ParkingOwner findByOwneremailid(String owneremailid);
	ParkingOwner findByOrganisation(String organisation);
}
