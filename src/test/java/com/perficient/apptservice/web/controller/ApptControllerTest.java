package com.perficient.apptservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perficient.apptservice.services.ApptService;
import com.perficient.apptservice.web.controllers.ApptController;
import com.perficient.apptservice.web.model.ApptDto;
import com.perficient.apptservice.web.model.ApptTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

// Unit Tests
@WebMvcTest(ApptController.class)
public class ApptControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ApptService apptService;

    @Test
    void getApptById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/appointments/{id}","xyz")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getApptList() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/appointments")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void saveAppt() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/appointments/")
                .content(asJsonString(getValidApptDto()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void updateAppt() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .put("/appointments/{id}", "xyz")
                .content(asJsonString(getValidApptDto()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteAppt() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/appointments/{id}", "xyz"))
                .andExpect(status().isAccepted());
    }

    ApptDto getValidApptDto() {
        return ApptDto.builder()
                .id("test-record")
                .apptName("Morning Yoga")
                .apptType(ApptTypeEnum.SESSION)
                .description("Yoga classes taught by instructor.")
                //.startTime(LocalTime.now())
                //.endTime(LocalTime.now())
                .metadata("N/A")
                .build();
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }


}
