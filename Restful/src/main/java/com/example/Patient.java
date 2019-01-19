package com.example;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection  = "Patient")


public class Patient{
	

		@Indexed(direction = IndexDirection.ASCENDING)
		@Id
		private String id;
		
		private String name;
		private String mobile;
		private String age;
		private String gender;
		private String occupation;
		private String symptom_summary;
		
		
		
		
		
		public Patient(String name, String mobile, String age,String gender, String occupation, String symptom_summary )
		{
			this.name = name;
			this.mobile =mobile;
			this.age = age;
			this.gender = gender;
			this.occupation = occupation;
			this.symptom_summary = symptom_summary;
		}
		
		public String getID()
		{
			return id;
		}
		
		public String getName()
		{
			return name;
		}
		public String getMoblile()
		{
			return mobile;
		}
		public String getAge()
		{
			return age;
		}
		public String getGender()
		{
			return gender;
		}
		
		public String getOccupaton()
		{
			return occupation;
		}
		
		public String getSymptom()
		{
			return symptom_summary;
		}
		
		
		
	}
