package fr.isima.cours.jee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class HourGenerator {


    private final HourPattern hourPattern;

    @Autowired
    public HourGenerator(HourPattern hourPattern) {
        this.hourPattern = hourPattern;
    }

    public Hour nowWithStandardFormat() {
        final LocalDateTime unformatted = LocalDateTime.now();
        return new Hour(unformatted, DateTimeFormatter.ofPattern(this.hourPattern.getHourPattern()).format(unformatted));
    }
}
