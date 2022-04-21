package it.aesys.courses.springboot.lesson2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("i18n")
public class InternationalizationExampleController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    public String messageView(Locale locale) {
      return messageSource.getMessage("i18n.message.language",null,locale)  ;
    }

}
