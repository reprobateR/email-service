package com.cognizant.mail;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.mail.entity.Mail;
import com.cognizant.mail.service.EmailService;

@SpringBootApplication
public class EmailServiceApplication implements CommandLineRunner {
	
	@Autowired
	EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

	
	public void run(String... args) throws Exception {
		
		Mail mail = new Mail();
		mail.setMailFrom("emailservice@cognizant.com");
		mail.setMailTo("raghavtenneti11@gmail.com");
		mail.setMailSubject("Email with FreeMarker template");
 
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("firstName", "Raghav");
		model.put("lastName", "Tenneti");
		model.put("location", "Hyderabad");
		model.put("signature", "www.cognizant.com");
		mail.setModel(model);
 
		emailService.sendEmail(mail);
 
		System.out.println("Done!");
				
	}

}
