package com.synergisticIT.Config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@PropertySource("classpath:db.properties")
public class AppConfig {

    @Bean
    InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver =  new InternalResourceViewResolver();
        viewResolver.setSuffix(".jsp");
        viewResolver.setPrefix("WEB-INF/jsp/");
        return viewResolver;
    }


}
