package services;

import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	List<User> users = new ArrayList<>();
	
	public UserService () {
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Iterable<User> getUsers () {
		return userRepository.findAll();
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String addUser (@RequestBody User user) {
		if (user != null) {
			userRepository.save(user);
		}
		return "saved";
	}
	
	@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
	public String updateUser (@RequestBody User user, @PathVariable long userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		
		if(!userOptional.isPresent())
			return "no such user";
		
		user.setUserId(userId);
		userRepository.save(user);
		
		return "updated";
	}

}
