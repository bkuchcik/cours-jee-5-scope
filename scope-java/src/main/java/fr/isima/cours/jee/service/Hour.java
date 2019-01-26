package fr.isima.cours.jee.service;

import java.time.LocalDateTime;

public class Hour {
    private final LocalDateTime unformatted;
    private final String formatted;

    Hour(LocalDateTime unformatted, String formatted) {
        this.unformatted = unformatted;
        this.formatted = formatted;
    }

    public String getFormatted() {
        return formatted;
    }

    public LocalDateTime getUnformatted() {
        return unformatted;
    }

    public Hour copy() {return new Hour(unformatted, formatted);}
}
