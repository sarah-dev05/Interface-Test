package com.example.demo.web;

import com.example.demo.service.Echantillon;
import com.example.demo.service.Statistique;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    Statistique statistique;

    @Test
    void creerVoitureRetourneOk() throws Exception {
        mockMvc.perform(post("/voiture")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"marque\":\"f\",\"prix\":100}"))
                .andExpect(status().isOk());

        verify(statistique).ajouter(any());
    }

    @Test
    void getStatistiqueRetourneOk() throws Exception {
        Echantillon echantillon = new Echantillon(2, 150);

        when(statistique.prixMoyen()).thenReturn(echantillon);

        mockMvc.perform(get("/statistique"))
                .andExpect(status().isOk());
    }

    @Test
    void getStatistiqueSansVoitureRetourneBadRequest() throws Exception {
        doThrow(new ArithmeticException()).when(statistique).prixMoyen();

        mockMvc.perform(get("/statistique"))
                .andExpect(status().isBadRequest());
    }
}