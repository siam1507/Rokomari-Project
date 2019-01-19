package com.example.newPackage;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Doctor;
import com.example.Patient;
import com.example.User;
import com.example.newPackage.DoctorRepository;
import com.example.newPackage.PatientRepository;
import com.example.newPackage.UserRepository;



@RestController
@RequestMapping("/")

public class UserController 
{
	private UserRepository userRepository;
	private DoctorRepository doctorRepository;
	private PatientRepository patientRepository;
	
	
	public UserController(UserRepository userRepository,DoctorRepository doctorRepository, PatientRepository patientRepository)
	{
		this.userRepository = userRepository;
		this.doctorRepository = doctorRepository;
		this.patientRepository = patientRepository;
	}
	
	@GetMapping("/")
	public String check()
	{
		return "Successful Connection";
	}

	@GetMapping("/users")
	public List<User> getAllUser()
	{
		List<User> users = (List<User>) this.userRepository.findAll();
		return users;
	}
	
	@GetMapping("/userById")
	public Optional<User> getUser(@RequestHeader(value="user_id") String user_id)
	{
		Optional<User> user = this.userRepository.findById(user_id);
		return user;
	}
	
@RequestMapping(value = "/register",  method=RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
	
	public User register(@RequestBody User user)
	{
		this.userRepository.insert(user);
		return user;
	}

@RequestMapping(value = "/login", method=RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)

public String login(@RequestBody User user){
   String email = user.getEmail();
   String password = user.getPassword();
   User user1 = this.userRepository.findByEmail(email);
   User user2 = this.userRepository.findByPassword(password);
   if(user1.getID().equals(user2.getID()))
   {
	   String firstName = user1.getFirstName();
	   return ("Status : logged in,\nFirst Name: "+firstName + "\nemail : "+email);
   }
   else 	   return ("Status : Not Logged in\nIncorrect username or password");

}

	
	@GetMapping("/doctorById")
	public Optional<Doctor> getDoctor(@RequestHeader(value="doctor_id") String doctor_id)
	{
		Optional<Doctor> doctor = this.doctorRepository.findById(doctor_id);
		return doctor;
	}
	
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctor()
	{
		List<Doctor> doctors = (List<Doctor>) this.doctorRepository.findAll();
		return doctors;
	}
	
	@GetMapping("/patients")
	public List<Patient> getAllPatient()
	{
		List<Patient> patients = (List<Patient>) this.patientRepository.findAll();
		return patients;
	}
	
	@GetMapping("/patientById")
	public Optional<Patient> getPatient(@RequestHeader(value="patient_id") String  patient_id)
	{
		Optional<Patient> patient = this.patientRepository.findById(patient_id);
		return patient;
	}
	
	@DeleteMapping("/delete/patients/{id}")
	public String deletePatient(@PathVariable ("id") String id)
	{
		this.patientRepository.deleteById(id);
	    return "Status : deleted";
	}
	
	@DeleteMapping("/delete/doctors/{id}")
	public String deleteDoctor(@PathVariable ("id") String id)
	{
		this.doctorRepository.deleteById(id);
	    return "Status : deleted";
	}

	
	
	@RequestMapping(value = "/insert/doctor/new",  method=RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
	
	public String  insertDoctor(@RequestBody Doctor doctor)
	{
		this.doctorRepository.insert(doctor);
		return "Inserted";
	}
	
@RequestMapping(value = "/insert/patient/new",  method=RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
	
	public String  insertPatient(@RequestBody Patient patient)
	{
		this.patientRepository.insert(patient);
		return "Inserted";
	}
	
	
	
	@RequestMapping(value = "/update/patients/{id}",  method=RequestMethod.PUT, consumes =  MediaType.APPLICATION_JSON_VALUE)

	public String updatePatient(@RequestBody Patient patient,@PathVariable("id") String id)
	{
		this.patientRepository.deleteById(id);
		this.patientRepository.save(patient);
		return "Updated";
	}
	
	@RequestMapping(value = "/update/doctors/{id}",  method=RequestMethod.PUT, consumes =  MediaType.APPLICATION_JSON_VALUE)

	public String updateDoctor(@RequestBody Doctor doctor,@PathVariable("id") String id)
	{
		this.doctorRepository.deleteById(id);
		this.doctorRepository.save(doctor);
		return "Updated";
	}
	
	
}

