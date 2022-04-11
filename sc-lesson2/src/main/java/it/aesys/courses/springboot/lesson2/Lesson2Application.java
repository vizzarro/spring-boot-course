package it.aesys.courses.springboot.lesson2;

import it.aesys.courses.springboot.lesson2.services.MyServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping(path = "/")
@SpringBootApplication
@ConfigurationPropertiesScan({ "it.aesys.courses.springboot.lesson2.config" })
public class Lesson2Application {

	private static final Logger logger = LoggerFactory.getLogger(Lesson2Application.class);

	@Value("${app.lesson}")
	private String lessonNumber;

	@Value("${lesson.welcome-message}")
	private String lessonMessage;

	@Value("${lesson.author}")
	private String lessonAuthor;

	@Autowired
	private MyServiceImpl service;

	public static void main(String[] args) {
		SpringApplication.run(Lesson2Application.class, args);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String lesson() {
		StringBuilder builder = new StringBuilder();
		builder.append("<H1>SPRING BOOT COURSE "+lessonNumber+" </H!>");
		builder.append("<H2>"+lessonMessage+"</H2>");
		builder.append("<H3>"+lessonAuthor+"</H3>");
		return builder.toString();
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {

		logger.info("Starts service {} version {} configuration init",service.getConfig().getName(),service.getConfig().getVersion());
		logger.info("Service {} enbled: {}",service.getConfig().getEnabled());


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
