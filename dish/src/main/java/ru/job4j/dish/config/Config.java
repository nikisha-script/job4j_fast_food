package ru.job4j.dish.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAspectJAutoProxy
public class Config {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
