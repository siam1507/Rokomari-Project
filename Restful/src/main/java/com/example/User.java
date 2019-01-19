package com.example;

import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document (collection  = "Users")


public class User{
	

		@Indexed(direction = IndexDirection.ASCENDING)
		@Id
		private String id;

		private String first_name;
		private String last_name;
		private String email;
		private String mobile;
		private String password;
		
		
	
		
		
		public User(String first_name, String last_name, String email,String mobile, String password )
		{
			this.first_name = first_name;
			this.last_name = last_name;
			this.email = email;
			this.mobile = mobile;
			this.password = password;
		}
		
		public String getID()
		{
			return id;
		}
		
		public String getFirstName()
		{
			return first_name;
		}
		public String getLastName()
		{
			return last_name;
		}
		public String getEmail()
		{
			return email;
		}
		public String getMoblile()
		{
			return mobile;
		}
		public String getPassword()
		{
			return password;
		}
		
		
		
		
		
		public void setID(String id)
		{
			this.id = id;
		}
		
		public void setFirstName(String first_name)
		{
			this.first_name = first_name;
		}
		
		public void setLastName(String last_name)
		{
			this.last_name = last_name;
		}
		
		public void setEmail(String email)
		{
			this.email =  email;
		}
		public void setMoblile(String mobile)
		{
			this.mobile = mobile;
		}
		
		public void setPassword(String password)
		{
			this.password = password;
		}


	
		
		
		
	}
