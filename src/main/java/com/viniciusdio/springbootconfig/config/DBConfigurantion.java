package com.viniciusdio.springbootconfig.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfigurantion {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("DEV")
    public String testDatabaseConnection(){
        System.out.println("DB connection for Dev - H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to H2_TEST - Teste isntance";
    }

    @Profile("PROD")
    public String productionDataSourceConnection(){
        System.out.println("DB connection for Dev - MYSQL");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to MYSQL_PROD - Teste isntance";
    }


}
