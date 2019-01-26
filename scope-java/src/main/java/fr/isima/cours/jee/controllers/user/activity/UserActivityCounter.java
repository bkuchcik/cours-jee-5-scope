package fr.isima.cours.jee.controllers.user.activity;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@SessionScope
public class UserActivityCounter {

    private final AtomicInteger atomicInteger = new AtomicInteger();

    public int incrementAndGet() {
        return atomicInteger.incrementAndGet();
    }

    public Integer getNumberOfRequest() {
        return atomicInteger.get();
    }
}
