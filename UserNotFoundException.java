package com.anudip.TrainTicketReservationSystemProject.Exception;

public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super("User is not Registered");
		
	}

	public UserNotFoundException(String message) {
		super(message);
		
	}
	}
	
