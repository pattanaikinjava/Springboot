package in.app.springboot.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.app.springboot.entity.Role;
import in.app.springboot.entity.User;

@RestController
@RequestMapping(value="/rest")
public class ResponeJsonController {
	
	//1. fetch data from server in global data format
	 //accepted - application/JSON (by default)
	// By default JACKSON lib i supported to take care of json in spring boot.
	@GetMapping(value="/one")
	public ResponseEntity<User> getOneUser(){
	User user =  new User(101,"dev","admin", "pa1998",
 		   List.of("w1","w2","w3"),
 		   Map.of("11","DEV","22","PROD")
			);
		ResponseEntity<User> response =
				        new ResponseEntity<>(
					      user, HttpStatus.OK
						 );
		return response;
	}
	
	@GetMapping(value="/list")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> listofUsers = Arrays.asList
				(
						 new User(101,"dev","admin", "hg6579",
								 List.of("A1","A2","A3"),
								 Map.of("10","SQL","20","BI")),
						 new User(102,"pattanaik","accountant", "tg091",
								 List.of("B1","B2","B3"),
								 Map.of("31","SUPPORT","32","MAINTAIN")),
						 new User(103,"abc","clerk", "tge387",
								 List.of("C1","C2","C3"),
								 Map.of("50","RND","51","CSD")),
						 new User(104,"xyz","manager", "ah109",
								 List.of("D1","D2","D3"),
								 Map.of("61","DEV","67","PROD"))
				);
		ResponseEntity<List<User>>  response = new ResponseEntity<>
		       (
		    		   listofUsers,
		    		   HttpStatus.OK
				);
		return response;
	}
	@PostMapping(value="/listrole")
	public ResponseEntity<List<Role>> getAllRoles(){
		List<Role> listofUsers = Arrays.asList
				(
						 new Role(758,"re09"),
						 new Role(65,"epor01")
						 
				);
		ResponseEntity<List<Role>>  response = new ResponseEntity<>
		       (
		    		   listofUsers,
		    		   HttpStatus.OK
				);
		return response;
	}
	
}
/*
 * Browser donot supports XML formatted data for GET type.
 * By default JACKSON is supported in browser.
 * */
