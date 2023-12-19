package com.anudip.TrainTicketReservationSystemProject.service;
import java.util.List;

import com.anudip.TrainTicketReservationSystemProject.Exception.UserFoundException;
import com.anudip.TrainTicketReservationSystemProject.Exception.UserNotFoundException;
import com.anudip.TrainTicketReservationSystemProject.entity.UserLogin;

public interface UserLoginService {
    List<UserLogin> getAllRecords() throws UserNotFoundException;



    UserLogin getUserLogin(String email) throws UserNotFoundException;

    //String updateUserLogin(UserLogin userLogin) throws UserNotFoundException;

    String deleteUserLogin(String email) throws UserNotFoundException;



	String saveUserLogin(UserLogin userLogin) throws UserNotFoundException, UserFoundException;
	
    String updateUserByEmail(String email, UserLogin updatedUser);



}
