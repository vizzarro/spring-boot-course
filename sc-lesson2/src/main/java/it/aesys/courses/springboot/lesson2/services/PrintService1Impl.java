package it.aesys.courses.springboot.lesson2.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("printService")
@Profile("devel")
public class PrintService1Impl implements PrintService {

    @Value("${print-something.service1.value}")
    private String value;

    @Override
    public String getValueToPrint() {
        return value;
    }

}
