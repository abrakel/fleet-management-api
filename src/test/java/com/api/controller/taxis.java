package com.api.controller;

/* WebMvcTest: Para escuchar la solicitud HTTP,
validar entradas, llamar a la logica,
serializar la salida y traducir excepciones a una respuesta adecuada */

import com.api.model.Taxis;
import com.api.service.TaxisService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@AutoConfigureMockMvc
//@ExtendWith(SpringExtension.class)
//public class taxiControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private TaxisService taxisService;
//
//    @Test
//    public void getTaxisById() throws Exception {
//        Taxis taxi = new Taxis();
//        taxi.setId(7249L);
//        taxi.setPlate("CNCJ-2997");
//        when(taxisService.findById(7249L)).thenReturn(Optional.of(taxi));
//
//        //Realizar solicitud al controlador
//        mockMvc.perform(get("/taxis/id", 7249L))
//                .andExpect(status().isOk())
//                .andExpect(content().json("{\"id\":7249,\"plate\":\"CNCJ-2997\"}"));
//    }
//}
