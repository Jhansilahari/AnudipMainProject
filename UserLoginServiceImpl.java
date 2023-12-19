package com.anudip.TrainTicketReservationSystemProject.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.TrainTicketReservationSystemProject.Exception.UserFoundException;
import com.anudip.TrainTicketReservationSystemProject.Exception.UserNotFoundException;
import com.anudip.TrainTicketReservationSystemProject.entity.User;
import com.anudip.TrainTicketReservationSystemProject.entity.UserLogin;
import com.anudip.TrainTicketReservationSystemProject.service.UserLoginService;

import jakarta.transaction.Transactional;

import com.anudip.TrainTicketReservationSystemProject.repository.UserLoginRepository;
import com.anudip.TrainTicketReservationSystemProject.repository.UserRepository;
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserLogin> getAllRecords() throws UserNotFoundException {
        List<UserLogin> userLoginList = userLoginRepository.findAll();
        if (userLoginList.isEmpty()) {
            throw new UserNotFoundException("No records are there. Please create a user first!");
        } else {
            return userLoginList;
        }
    }    
    @Override
    public String saveUserLogin(UserLogin userLogin) throws UserNotFoundException, UserFoundException {
        // Check if the user with the provided email exists
        Optional<User> userOptional = userRepository.findByEmail(userLogin.getEmail());

        if (userOptional.isPresent()) {
            // User exists, check login credentials
            User user = userOptional.get();
            String userPassword = user.getPassword();
            String checkLoginPassword = userLogin.getPassword();

            // Checking whether login credentials are correct or not
            if (checkLoginPassword.equals(userPassword)) {
                // Check if the user login already exists
                Optional<UserLogin> existUserLogin = userLoginRepository.findByEmail(userLogin.getEmail());
                if (existUserLogin.isPresent()) {
                    throw new UserFoundException("This UserLogin already exists! Please login with another login ID");
                } else {
                    // Save the user login
                    userLoginRepository.save(userLogin);
                    return "User logged in successfully";
                }
            } else {
                throw new UserNotFoundException("Please enter a valid password.");
            }
        } else {
            throw new UserNotFoundException("Please enter a valid email");
        }
    }
    
    
    
    
    
    @Override
    public UserLogin getUserLogin(String email) throws UserNotFoundException {
        Optional<UserLogin> checkUserLogin = userLoginRepository.findByEmail(email);
        if (checkUserLogin.isPresent()) {
            return checkUserLogin.get();
        } else {
            throw new UserNotFoundException("There is no UserLogin with this email");
        }
    }

    /*@Override
    public String updateUserLogin(UserLogin userLogin) throws UserNotFoundException {
        Optional<UserLogin> checkUserLogin = userLoginRepository.findByEmail(userLogin.getEmail());

        if (checkUserLogin.isPresent()) {
            userLoginRepository.save(userLogin);
            return "User updated successfully";
        } else {
            throw new UserNotFoundException("There is no UserLogin with this email");
        }
    }
     */
    @Override
    @Transactional
    public String deleteUserLogin(String email) throws UserNotFoundException {
        Optional<UserLogin> checkUserLogin = userLoginRepository.findByEmail(email);
        if (checkUserLogin.isPresent()) {
            userLoginRepository.deleteByEmail(email);
            return "Record deleted";
        } else {
            throw new UserNotFoundException("There is no UserLogin with this email");
        }
    }
	
	 @Override
	    public String updateUserByEmail(String email, UserLogin updatedUser) {
	        UserLogin existingUser = userLoginRepository.findById(email).orElse(null);
	        if (existingUser == null) {
	            return "User not found with email: " + email;
	        }

	        // Update the properties you want to update
	        existingUser.setPassword(updatedUser.getPassword());

	        userLoginRepository.save(existingUser);
	        return "User updated successfully";
	    }
}
