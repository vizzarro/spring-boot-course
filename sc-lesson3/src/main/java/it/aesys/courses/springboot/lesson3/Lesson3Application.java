package it.aesys.courses.springboot.lesson1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping(path = "/")
@SpringBootApplication
public class Lesson3Application {

	private static final Logger logger = LoggerFactory.getLogger(Lesson1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Lesson1Application.class, args);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String lesson() {
		StringBuilder builder = new StringBuilder();
		builder.append("<H1>SPRING BOOT LESSON 3</H!>");
		builder.append("<H2>alessandro.vizzarro@aesys.tech</H2>");
		return builder.toString();
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			logger.info("Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				logger.info(beanName);
			}
		};
	}



}
