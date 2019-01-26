package fr.isima.cours.jee.controllers.user.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

import javax.inject.Provider;

@Component
public class UserActivityListener {

    private final Provider<UserActivityCounter> userActivityCounterProvider;

    @Autowired
    public UserActivityListener(
            Provider<UserActivityCounter> userActivityCounterProvider) {
        this.userActivityCounterProvider = userActivityCounterProvider;
    }

    @EventListener
    public void handleEvent(ServletRequestHandledEvent e) {
        if (e.getRequestUrl().contains("heure")) {
            this.userActivityCounterProvider.get().incrementAndGet();
        }
    }
}
