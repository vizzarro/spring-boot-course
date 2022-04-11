package it.aesys.courses.springboot.lesson2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("my.service")
public class MyServiceConfig {
    
    private String name;
    private String version;
    private Boolean enabled;

    public MyServiceConfig() {
        super();
    }

    public MyServiceConfig(String name, String version, Boolean enabled) {
        this();
        this.name = name;
        this.version = version;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
