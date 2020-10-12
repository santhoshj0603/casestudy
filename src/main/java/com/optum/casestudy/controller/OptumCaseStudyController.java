package com.optum.casestudy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.optum.casestudy.model.User;
import com.optum.casestudy.service.OptumUserService;

@RestController
public class OptumCaseStudyController {
	
	private static final Logger LOG = LoggerFactory.getLogger(OptumCaseStudyController.class);
	
	@Autowired
	OptumUserService userService;
	
	@PostMapping("/public/v1/user/save")
	public User save(@RequestBody User user, @RequestHeader(value = "uuid", required = false) String uuid){
		LOG.info("Received save request :: uuid :: ", uuid);
		user = userService.saveUser(user);
		LOG.info("Successfully saved user :: uuid :: ", uuid);
		return user;
	}
	
	@GetMapping("/private/v1/user/all")
	public List<User> findAll(@RequestHeader(value = "uuid", required = false) String uuid){
		LOG.info("Received findAll request :: uuid :: ", uuid);
		List<User> users = userService.findAll();
		LOG.info("Successfully retrived all users :: uuid :: ", uuid);
		return users;
	}

}
