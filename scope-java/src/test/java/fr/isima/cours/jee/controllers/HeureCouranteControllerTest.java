package fr.isima.cours.jee.controllers;

import fr.isima.cours.jee.service.Hour;
import fr.isima.cours.jee.service.HourGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HeureCouranteControllerTest {

    public static final String FORMATTED = "formatted";

    @Mock
    private Hour hour;

    private HeureMVCController heureController;

    private ModelAndView heureModelAndView() {
        return this.heureController.heure();
    }

    @Before
    public void before() {
        this.heureController = new HeureMVCController(() -> hour);
        when(hour.getFormatted()).thenReturn(FORMATTED);
    }

    @Test
    public void heureCourante_RedirectToHeureCouranteV5() {
        assertThat(heureModelAndView().getViewName()).isEqualTo("heureCourante");
    }

    @Test
    public void heureCourante_hourGenreratorValueIsModel() {
        assertThat(heureModelAndView().getModel().get("currentDateAsString")).isEqualTo(FORMATTED);
    }

}
