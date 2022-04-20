package it.aesys.courses.springboot.lesson1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class ConfigService {

    @Value("${app.lesson}")
    private String lessonNumber;

    @Value("${lesson.welcome-message}")
    private String lessonMessage;

    @Value("${lesson.author}")
    private String lessonAuthor;

    public String getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(String lessonNumber) {
        this.lessonNumber = lessonNumber;
    }
}
