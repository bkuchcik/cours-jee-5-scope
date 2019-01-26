package fr.isima.cours.jee.controllers;

import fr.isima.cours.jee.service.Hour;
import fr.isima.cours.jee.service.HourGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Provider;

@Controller
@RequestMapping("/heure")
public class HeureMVCController {

    private final Provider<Hour> hour;

    @Autowired
    public HeureMVCController(Provider<Hour> hour) {
        this.hour = hour;
    }

    @GetMapping
    public ModelAndView heure() {
        return new ModelAndView("heureCourante", "currentDateAsString", this.hour.get().getFormatted());
    }

}
