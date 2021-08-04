package com.webproject.webSpring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(properties = "classpath:application.yml")
//@ContextConfiguration(classes = WebSpringApplication.class)
class WebSpringApplicationTests {

	@Test
	void contextLoads() {
	}

}
