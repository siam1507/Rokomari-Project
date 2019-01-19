package com.example.newPackage;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Doctor;





@Repository
public interface DoctorRepository extends MongoRepository <Doctor, String >
{
	
		Optional<Doctor> findById(String id);

}
