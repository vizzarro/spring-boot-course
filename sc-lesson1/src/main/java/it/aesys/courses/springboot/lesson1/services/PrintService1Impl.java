package it.aesys.courses.springboot.lesson1.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("Print1")
public class PrintService1Impl implements PrintService {

    @Value("${print-something.service1.value}")
    private String value;

    @Override
    public String getValueToPrint() {
        return value;
    }

}
