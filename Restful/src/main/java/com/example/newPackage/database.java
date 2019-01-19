package com.example.newPackage;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.Doctor;
import com.example.Patient;
import com.example.User;




@Component
public class database implements CommandLineRunner {

	private UserRepository userRepository;
	private DoctorRepository doctorRepository;
	private PatientRepository patientRepository;
	
	public database (UserRepository userRepository,DoctorRepository doctorRepository, PatientRepository patientRepository)
	{
		this.userRepository = userRepository;
		this.doctorRepository = doctorRepository;
		this.patientRepository = patientRepository;
	}
	
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User obayed = new User("Obayed", "Bin Mahfuz", "siam1507@gmail.com", "01534750194", "123456789");
		
		Doctor doctor1 = new Doctor("DR. Panda", "Medicine","11-12-18");
		Doctor doctor2 = new Doctor("DR. Kabir", "Oncology","2-1-17");
		Doctor doctor3 = new Doctor("DR. Zahir", "Neuro","11-12-18");
		
		Patient patient1 = new Patient("Akhter", "01714259392", "25", "Male", "Service", "Vomiting");
		Patient patient2 = new Patient("Nasrin", "01590303033", "50", "Female", "Housewife", "Fever");
		Patient patient3 = new Patient("Mizan", "01896128389", "30", "Male", "Student", "Accident");

		
		
		this.userRepository.deleteAll();
		this.patientRepository.deleteAll();
		this.doctorRepository.deleteAll();
		
	List<User> users = Arrays.asList(obayed);
	List<Patient> patients = Arrays.asList(patient1,patient2,patient3);
	List<Doctor> doctors = Arrays.asList(doctor1,doctor2,doctor3);
	
	this.userRepository.saveAll(users);
	this.patientRepository.saveAll(patients);
	this.doctorRepository.saveAll(doctors);
	
	}
	

}
