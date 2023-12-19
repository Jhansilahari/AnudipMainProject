package com.anudip.TrainTicketReservationSystemProject.Exception;

public class UserFoundException extends Exception{


	private static final long serialVersionUID = 1L;
	public UserFoundException() {
		super("This User id is already present in database");
		
	}
	public UserFoundException(String message) {
		super(message);
		
	}


}
