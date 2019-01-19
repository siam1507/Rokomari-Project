package com.example;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document (collection  = "Doctors")

public class Doctor {
	
	
	@Indexed(direction = IndexDirection.ASCENDING)
	@Id
	private String id;
	
	private String name;
	private String dept;
	private String joining;
	
	
	
	
	
	public Doctor(String name, String dept, String joining)
	{
		this.name = name;
		this.dept = dept;
		this.joining = joining;

	}
	
	public String getID()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	public String getDept()
	{
		return dept;
	}
	public String getJoining()
	{
		return joining;
	}
	
	
	

}

