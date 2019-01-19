package com.example.newPackage;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Patient;



@Repository
public interface PatientRepository extends MongoRepository <Patient, String >
{
	
		Optional<Patient> findById(String id);

}
