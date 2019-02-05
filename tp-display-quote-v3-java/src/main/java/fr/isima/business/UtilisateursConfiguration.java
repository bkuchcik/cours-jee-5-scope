package fr.isima.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpSession;

@Configuration
public class UtilisateursConfiguration {

    @Bean
    @ApplicationScope
    public Utilisateurs utilisateurs() {
        return new Utilisateurs();
    }

    @Bean
    @SessionScope
    public SessionUtilisation sessionUtilisation(Utilisateur utilisateur) {
        return utilisateur.ouvrirSessionUtilisation();
    }

    @Bean
    @SessionScope
    @Autowired
    public Utilisateur utilisateur(HttpSession httpSession, Quotes quotes) {
        return new Utilisateur((String) httpSession.getAttribute("username"), quotes, utilisateurs());
    }
}
