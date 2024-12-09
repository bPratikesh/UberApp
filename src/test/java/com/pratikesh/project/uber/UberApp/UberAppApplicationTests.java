package com.pratikesh.project.uber.UberApp;

import com.pratikesh.project.uber.UberApp.services.implementations.EmailSenderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UberAppApplicationTests {

	@Autowired
	private EmailSenderServiceImpl emailSenderService;
	@Test
	void contextLoads() {
		emailSenderService.sendEmail("ridoye2950@datingel.com",
				"Testing", "This is a mail for testing purpose");
	}

}
