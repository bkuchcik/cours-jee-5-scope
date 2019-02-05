package fr.isima.business;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * L'ensemble des utilisateurs de l'application.
 * 
 * Le stockage ne se faisant qu'en m�moire, un red�marrage fait perdre toutes
 * les donn�es
 * 
 * @author Benjamin
 *
 */
public class Utilisateurs {

    private final AtomicInteger nombreTotalCitation = new AtomicInteger(0);

    public void incrementNombreCitationLu() {
        nombreTotalCitation.getAndIncrement();
    }

    public int getNombreCitationVuAuTotal() {
        return nombreTotalCitation.get();
    }
}
