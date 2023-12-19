package com.anudip.TrainTicketReservationSystemProject.service;

import java.util.List;
import com.anudip.TrainTicketReservationSystemProject.Exception.UserFoundException;
import com.anudip.TrainTicketReservationSystemProject.Exception.UserNotFoundException;
import com.anudip.TrainTicketReservationSystemProject.entity.User;

public interface UserService {
	    
	    User saveUser(User user) throws UserFoundException;
		
	    User getUser(Long id) throws UserNotFoundException;
		
	    User updateUser(User user) throws UserNotFoundException;
		
		String deleteUser(Long id) throws UserNotFoundException;

		List<User> getAllRecords() throws UserNotFoundException;

		User getUserByEmail(String email) throws UserNotFoundException;



}
