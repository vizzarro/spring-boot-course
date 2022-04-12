package it.aesys.courses.springboot.lesson2.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("welcome")
@Profile("devel")
public class WelcomeServiceImpl implements WelcomeService{

    @Value("${app.lesson}")
    private String lessonNumber;

    @Value("${lesson.welcome-message}")
    private String lessonMessage;

    @Value("${lesson.author}")
    private String lessonAuthor;
    
    @Override
    public String welcome(String token) {
        StringBuilder builder = new StringBuilder();
        builder.append("<H1>SPRING BOOT COURSE "+lessonNumber+" </H!>");
        builder.append("<H2>"+lessonMessage+"</H2>");
        builder.append("<H3>"+lessonAuthor+"</H3>");
        return builder.toString();
    }
    
}
