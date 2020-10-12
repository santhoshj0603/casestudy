package com.optum.casestudy.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.optum.casestudy.model.User;
import com.optum.casestudy.service.OptumUserService;

@RunWith(MockitoJUnitRunner.class)
public class OptumCaseStudyControllerTest {

	@InjectMocks
	OptumCaseStudyController controller;
	MockMvc mockMvc;
	@Mock
	OptumUserService userService;

	private static final String SAVE_URL = "/public/v1/user/save";
	private static final String FIND_ALL_URL = "/private/v1/user/all";

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testSave() throws Exception {
		User user = User.builder().firstName("test").lastName("test").build();
		when(userService.saveUser(user)).thenReturn(user);
		this.mockMvc.perform(post(SAVE_URL).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(user)).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void findAll() throws Exception {
		User user = User.builder().firstName("test").lastName("test").build();
		List<User> list = new ArrayList<User>();
		list.add(user);
		when(userService.findAll()).thenReturn(list);
		this.mockMvc.perform(get(FIND_ALL_URL).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}