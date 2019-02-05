package fr.isima.server;


import fr.isima.business.Quotes;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("fr.isima")
public class Application {

    @Bean
    public Quotes quotes() {
        return Quotes.createDefaultQuotes();
    }
}
