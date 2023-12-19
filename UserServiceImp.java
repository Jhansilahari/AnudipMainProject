package com.anudip.TrainTicketReservationSystemProject.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anudip.TrainTicketReservationSystemProject.Exception.UserFoundException;
import com.anudip.TrainTicketReservationSystemProject.Exception.UserNotFoundException;
import com.anudip.TrainTicketReservationSystemProject.entity.User;
import com.anudip.TrainTicketReservationSystemProject.repository.UserRepository;
import com.anudip.TrainTicketReservationSystemProject.service.UserService;


@Service
public class UserServiceImpl implements UserService {  
	 
    @Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllRecords()throws UserNotFoundException {
	
		List<User> userlist=userRepository.findAll();
		if(userlist.isEmpty()) 
		{
			throw new UserNotFoundException("NO records of User are there.Please Register the User");
		}
		else
			return userlist;
	}

	@Override
	public User saveUser(User user) throws UserFoundException {
		
		Optional<User> existuser = userRepository.findById(user.getId());
		if(existuser.isPresent())
		{
			throw new UserFoundException("This User already exist!!!!");
		}
		else
			return userRepository.save(user);	
	}

	
	@Override
	public User getUser(Long id) throws UserNotFoundException{
		
		Optional<User> checkuser = userRepository.findById(id);
		if(checkuser.isPresent())
		{
			return userRepository.findById(id).get();
		}
		else
		{
			throw new UserNotFoundException("There is No User with this Userid");
		}
	}
	
	
	@Override
	public User updateUser(User user) throws UserNotFoundException{

		Optional<User> checkuser = userRepository.findById(user.getId());
		if(checkuser.isPresent())
		{
			return userRepository.save(user);
		}
		else
		{
			throw new UserNotFoundException("There is No User with this Userid");
		}
	}

	@Override
	public String deleteUser(Long id) throws UserNotFoundException{
	
		Optional<User> checkuser = userRepository.findById(id);
		if(checkuser.isPresent())
		{
			userRepository.deleteById(id);
			return " User Record deleted sucessfully";
		}
		else
		{
			throw new UserNotFoundException("There is No User with this Userid");
		}	
}

	 @Override
	    public User getUserByEmail(String email) throws UserNotFoundException {
	        return userRepository.findByEmail(email)
	                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
	    }

	
}	
