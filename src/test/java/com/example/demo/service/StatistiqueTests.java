package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class StatistiqueTests {

    @Test
    void calculerPrixMoyenAvecDeuxVoitures() {
        StatistiqueImpl statistique = new StatistiqueImpl();

        Voiture v1 = new Voiture("Ferrari", 2000);
        Voiture v2 = new Voiture("Porsche", 3000);

        statistique.ajouter(v1);
        statistique.ajouter(v2);

        Echantillon echantillon = statistique.prixMoyen();

        assertEquals(2, echantillon.getNombreDeVoitures());
        assertEquals(2500, echantillon.getPrixMoyen());
    }

    @Test
    void calculerPrixMoyenAvecUneVoiture() {
        StatistiqueImpl statistique = new StatistiqueImpl();

        Voiture voiture = new Voiture("Renault", 12000);
        statistique.ajouter(voiture);

        Echantillon echantillon = statistique.prixMoyen();

        assertEquals(1, echantillon.getNombreDeVoitures());
        assertEquals(12000, echantillon.getPrixMoyen());
    }

    @Test
    void calculerPrixMoyenSansVoitureLanceException() {
        StatistiqueImpl statistique = new StatistiqueImpl();

        assertThrows(ArithmeticException.class, () -> {
            statistique.prixMoyen();
        });
    }
}