package com.anudip.TrainTicketReservationSystemProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity             
@Table(name = "users")   
public class User  {

	    @Id                   
	    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	    @Column(name = "user_id")
	    private Long id;

	    @Column(name = "name")
	    private String name;
	    
	    
	    @Column(name = "email", nullable = false, unique = true)
	    private String email;

	    @Column(name="ph_no")
	    private String phoneNo;

	    @Column(name = "address")
	    private String address;

	    @Column(name = "password")
	    private String password;


	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    // Default constructor
	    public User() {
	    }

	    // Parameterized constructor
	    public User(Long id, String name, String email, String phoneNo, String address, String password) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.phoneNo = phoneNo;
	        this.address = address;
	        this.password = password;
	        
	    }

	    @Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", address="
					+ address + ", password=" + password + "]";
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}

		public void setAddress(String address) {
			this.address = address;
		}

	    public void setPassword1(String password) {
	        this.password = password;
	    }
		public String getName() {
	        return name;
	    }
		
		 public String getEmail() {
		        return email;
		    }
		 public String getPhoneNo() {
		        return phoneNo;
		    }
		 public String getAddress() {
		        return address;
		    }
		 
		public void setId(Long id) {
			this.id = id;
			}
		

		public Long getId() {
			return id;
		}	
		
	}
