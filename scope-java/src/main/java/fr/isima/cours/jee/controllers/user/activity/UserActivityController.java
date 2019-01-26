package fr.isima.cours.jee.controllers.user.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Provider;

@Controller
@RequestMapping("/activity")
public class UserActivityController {

    private final Provider<UserActivityCounter> userActivityCounterProvider;

    @Autowired
    public UserActivityController(
            Provider<UserActivityCounter> userActivityCounterProvider) {
        this.userActivityCounterProvider = userActivityCounterProvider;
    }

    @GetMapping
    @ResponseBody
    public Integer userActivityCounter() {
        return this.userActivityCounterProvider.get().getNumberOfRequest();
    }
}
