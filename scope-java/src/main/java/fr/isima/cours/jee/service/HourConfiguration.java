package fr.isima.cours.jee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class HourConfiguration {

    @Bean
    @ApplicationScope
    public HourPattern hourProperties() throws IOException {
        final Properties props = new Properties();
        props.load(HourConfiguration.class.getResourceAsStream("/hour.properties"));
        return new HourPattern(props.getProperty("format.date.heure.courante"));
    }

    @Bean
    @RequestScope
    @Autowired
    public Hour hour(HourGenerator hourGenerator) {
        return hourGenerator.nowWithStandardFormat();
    }

}
