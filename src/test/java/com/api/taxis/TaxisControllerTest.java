package com.api.taxis;

import com.api.repository.TaxisRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TaxisControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private TaxisRepository taxisRepository;

        @Test
        @DisplayName("Probando endpoint ")
        void contextLoads() throws Exception {
            mockMvc.perform(get("/taxis/all"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.content").isArray())
                    .andExpect(jsonPath("$.size").value(10))
                    .andExpect(jsonPath("$.pageable.pageSize").value(10))
                    .andReturn();
        }

        @Test
        @DisplayName("Buscar taxi por id")
        void taxiById() throws Exception {
            String expectedResponse = "{\"id\":7249,\"plate\":\"CNCJ-2997\"}";

            MvcResult mvcResult = this.mockMvc.perform(get("/taxis/id")
                            .param("id", "7249"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id").value(7249))
                    .andExpect(jsonPath("$.plate").value("CNCJ-2997"))
                    .andReturn();

            assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
        }
}
