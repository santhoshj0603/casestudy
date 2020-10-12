package com.optum.casestudy.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.optum.casestudy.model.User;
import com.optum.casestudy.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class OptumUserServiceTest {
	
	@InjectMocks
	OptumUserService service;
	
	@Mock
	UserRepository repository;
	
	@Test
	public void testSaveUser() {
		User user = User.builder().firstName("test").lastName("test").build();
		when(repository.save(user)).thenReturn(user);
		assertNotNull(service.saveUser(user));
	}
	
	@Test
	public void testFindAll() {
		User user = User.builder().firstName("test").lastName("test").build();
		List<User> list = new ArrayList<User>();
		list.add(user);
		when(repository.findAll()).thenReturn(list);
		assertNotNull(service.findAll());
	}

}
