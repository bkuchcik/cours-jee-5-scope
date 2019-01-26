package fr.isima.cours.jee.service;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class HourGeneratorTest {

    public static final String HOUR_PATTERN = "'le' dd/MM/yyyy ' à ' HH:mm:ss ";
    private HourGenerator hourGenerator = new HourGenerator(new HourPattern(HOUR_PATTERN));

    @Test
    public void heureCourante_AddHeureCouranteToRequest() throws ParseException {
        final Date now = new Date();

        final String formattedDate = hourGenerator.nowWithStandardFormat().getFormatted();

        final Date date = DateUtils
                .parseDate(formattedDate, HOUR_PATTERN);
        assertThat(date).isBetween(DateUtils.addSeconds(now, -1), DateUtils.addSeconds(now, 1));
    }
}