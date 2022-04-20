package it.aesys.courses.springboot.lesson1.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("Print2")
public class PrintService2Impl implements PrintService{

    @Value("${print-something.service2.value}")
    private String value;

    @Override
    public String getValueToPrint() {
        return value;
    }


}
