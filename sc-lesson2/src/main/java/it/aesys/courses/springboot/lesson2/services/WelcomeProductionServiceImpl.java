package it.aesys.courses.springboot.lesson2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("welcome")
@Profile("production")
public class WelcomeProductionServiceImpl implements WelcomeService {

    @Autowired
    private MyServiceImpl service;
    
    @Value("${welcome.errormessage}")
    private String errorMessage;

    @Value("${app.lesson}")
    private String lessonNumber;

    @Value("${lesson.welcome-message}")
    private String lessonMessage;

    @Value("${lesson.author}")
    private String lessonAuthor;
    
    @Override
    public String welcome(String token) {
       if (!service.getConfig().getToken().equals(token) )
           return errorMessage;

        StringBuilder builder = new StringBuilder();
        builder.append("<H1>SPRING BOOT COURSE "+lessonNumber+" </H!>");
        builder.append("<H2>"+lessonMessage+"</H2>");
        builder.append("<H3>"+lessonAuthor+"</H3>");
        return builder.toString();
    }
}
