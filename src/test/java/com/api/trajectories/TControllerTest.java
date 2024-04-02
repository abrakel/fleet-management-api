package com.api.trajectories;

import com.api.repository.TrajectoriesR;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TrajectoriesR trajectoriesR;

    @Test
    @DisplayName("Find trajectories by taxiId and date")
    void findTrajectoriesTest() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(get("/trajectories/taxi")
                .param("taxiId", "7249")
                .param("date", "08-02-2008"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].taxiId.id").value(7249))
                .andExpect(jsonPath("$.content[0].taxiId.plate").value("CNCJ-2997"))
                .andDo(print())
                .andReturn();
    }

    @Test
    @DisplayName("Last location test")
    void lastLocationTest() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(get("/trajectories/location")
                .param("page", "0")
                .param("size", "20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$").isNotEmpty())
                .andDo(print())
                .andReturn();
    }
}
