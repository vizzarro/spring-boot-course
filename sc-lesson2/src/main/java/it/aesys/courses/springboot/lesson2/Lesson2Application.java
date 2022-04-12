package it.aesys.courses.springboot.lesson2;

import it.aesys.courses.springboot.lesson2.services.MyServiceImpl;
import it.aesys.courses.springboot.lesson2.services.WelcomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping(path = "/")
@SpringBootApplication
@ConfigurationPropertiesScan({ "it.aesys.courses.springboot.lesson2.config" })
public class Lesson2Application {

	private static final Logger logger = LoggerFactory.getLogger(Lesson2Application.class);

	@Autowired
	private MyServiceImpl service;

	@Autowired
	@Qualifier("welcome")
	private WelcomeService welcomeService;

	public static void main(String[] args) {
		SpringApplication.run(Lesson2Application.class, args);
	}

	@RequestMapping(method = RequestMethod.GET, params = { "token" })
	public String lesson(@RequestParam(name="token",required = false) String token) {

		return welcomeService.welcome(token);
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
