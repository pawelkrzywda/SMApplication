package com.smapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smapp.domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class TaskControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void saveTaskTest() throws Exception{
        //Given
        Task task = new Task(1L, "test", "test description", false);
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(task);

        //When & Then
        MvcResult result = mockMvc.perform(post("/saveTask")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonInString)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void updateTaskTest() throws Exception{
        //Given
        Task task = new Task(1L, "test", "test description", false);
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(task);

        //When & Then
        MvcResult result = mockMvc.perform(post("/updateTask")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonInString)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andReturn();
    }
}
