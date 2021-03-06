package it.aesys.courses.springboot.lesson2.controllers;

import it.aesys.courses.springboot.lesson2.services.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("print")
public class PrintSomethingController {

    @Value("${print-something.service-qualifier-key}")
    private String serviceQualifierKey;

    @Autowired
    private ApplicationContext context;


    protected PrintService getService() {

        return context.getBean(serviceQualifierKey, PrintService.class);

    }


    @RequestMapping(method = RequestMethod.GET)
    public String print() {

        return getService().getValueToPrint();

    }

}
