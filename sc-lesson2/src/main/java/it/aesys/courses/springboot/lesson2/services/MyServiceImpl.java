package it.aesys.courses.springboot.lesson2.services;

import it.aesys.courses.springboot.lesson2.config.MyServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl {

    @Autowired
    private MyServiceConfig config;

    public MyServiceConfig getConfig() {
        return config;
    }

    public void setConfig(MyServiceConfig config) {
        this.config = config;
    }
}
