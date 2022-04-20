package it.aesys.courses.springboot.lesson1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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
public class Lesson1Application {

	private static final Logger logger = LoggerFactory.getLogger(Lesson1Application.class);
	
	@Value("${app.lesson}")
	private String lessonNumber;
	
	@Value("${lesson.welcome-message}")
	private String lessonMessage;

	@Value("${lesson.author}")
	private String lessonAuthor;

	private ConfigService configService;
	
	public static void main(String[] args) {

		SpringApplication.run(Lesson1Application.class, args);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String lesson() {
		StringBuilder builder = new StringBuilder();
		builder.append("<H1>SPRING BOOT "+lessonNumber+" </H!>");
		builder.append("<H2>"+lessonAuthor+"</H2>");
		return builder.toString();
	}




}
