package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoitureAvecConstructeurVide() {
        Voiture voiture = new Voiture();

        voiture.setMarque("Renault");
        voiture.setPrix(15000);
        voiture.setId(1);

        assertEquals("Renault", voiture.getMarque());
        assertEquals(15000, voiture.getPrix());
        assertEquals(1, voiture.getId());
    }

    @Test
    void creerVoitureAvecConstructeurMarquePrix() {
        Voiture voiture = new Voiture("Peugeot", 20000);

        assertEquals("Peugeot", voiture.getMarque());
        assertEquals(20000, voiture.getPrix());
    }

    @Test
    void modifierVoitureAvecSetters() {
        Voiture voiture = new Voiture();

        voiture.setMarque("Citroen");
        voiture.setPrix(12000);
        voiture.setId(5);

        assertEquals("Citroen", voiture.getMarque());
        assertEquals(12000, voiture.getPrix());
        assertEquals(5, voiture.getId());
    }

    @Test
    void testerToString() {
        Voiture voiture = new Voiture("Fiat", 10000);
        voiture.setId(2);

        assertEquals("Car{marque='Fiat', prix=10000, id=2}", voiture.toString());
    }
}