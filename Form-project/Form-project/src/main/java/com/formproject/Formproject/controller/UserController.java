package com.formproject.Formproject.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.formproject.Formproject.exception.UserNotFountException;
import com.formproject.Formproject.model.User;
import com.formproject.Formproject.repository.UserRepository;
import org.springframework.util.StringUtils;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {
	
	@Autowired
	private UserRepository userrepository;
	
	@PostMapping("/user")
    User newUser(@RequestParam("name") String name,
                 @RequestParam("email") String email,
                 @RequestParam("password") String password,
                 @RequestParam("file") MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir1 = "user-files/" ;
     
		FileUploadUtil.saveFile(uploadDir1, fileName, file);
        User newUser = new User(name, email, password, fileName);
        
        
        
        // Save file logic here
        
        return userrepository.save(newUser);
    }
	
	@GetMapping("/users")
	List<User>getAllUsers(){
		
		return userrepository.findAll();
	}
	
	@GetMapping("/user/{id}")
	User getUserId(@PathVariable Long id) {
		
		return userrepository.findById(id)
				.orElseThrow(()->new UserNotFountException(id));
		
	}
	
	@PutMapping("/user/{id}")
	User updateUser(@RequestBody User newUser,@PathVariable Long id) {
		return userrepository.findById(id)
				.map(user ->{
					user.setName(newUser.getName());
					user.setEmail(newUser.getEmail());
					user.setPassword(newUser.getPassword());
					return userrepository.save(user);
				}).orElseThrow(()->new UserNotFountException(id));
	}
	
	@DeleteMapping("/user/{id}")
	String deleteUser(@PathVariable Long id) {
		if(!userrepository.existsById(id)) {
			throw new UserNotFountException(id);
		}
		userrepository.deleteById(id);
		return "User with id" +id+ "has been deleted succesfully.";
	}
	
	
	

}
