package com.optum.casestudy;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OptumCaseStudyApplicationTests {

	@Test
	void contextLoads() {
		OptumCaseStudyApplication application = new OptumCaseStudyApplication();
		assertNotNull(application);
	}

}
