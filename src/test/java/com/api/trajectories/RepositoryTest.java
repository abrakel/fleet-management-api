package com.api.trajectories;

import com.api.model.Trajectories;
import com.api.repository.TrajectoriesR;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RepositoryTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrajectoriesR trajectoriesR; //Lo que se quiere testear

    @Test
    @DisplayName("Content Size Test")
    public void contentSizeTest () throws Exception{

        Pageable pageable = Pageable.ofSize(1).withPage(1);

        List<Trajectories> trajectoriesList = new ArrayList<>();
        trajectoriesList.add(new Trajectories());
        trajectoriesList.add(new Trajectories());
        trajectoriesList.add(new Trajectories());

        when(trajectoriesR.findLastLocation(pageable)).thenReturn(trajectoriesList);

        this.mockMvc.perform(get("/trajectories/location")
                        .param("page", "1")
                        .param("size", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").isNotEmpty())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content.length()").value(3))
                .andReturn();
    }
}
