package it.aesys.courses.springboot.schelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hw")
@SpringBootApplication
public class ScHelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScHelloworldApplication.class, args);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String helloWorld() {

		return "<H1>HELLO WORLD!!!</H!>";
	}

}
