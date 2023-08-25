package com.mediscreen.datapatientsapi.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediscreen.datapatientsapi.model.Patient;
import com.mediscreen.datapatientsapi.service.PatientsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class controllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PatientsService patientsService;

    @Test
    public void getPatientsListTest() throws Exception{
        LocalDate date = LocalDate.of(2000,02,29);
        Patient patient = new Patient(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");
        List<Patient> list = new ArrayList<>();
        list.add(patient);
        when(patientsService.getPatientList("Black")).thenReturn(list);

        mockMvc.perform(get("/patients").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("lastName","Black"))
                .andExpect(status().isOk()).andDo(print());
    }
    @Test
    public void getPatientTest() throws Exception{
        LocalDate date = LocalDate.of(2000,02,29);
        Patient patient = new Patient(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");
        when(patientsService.getPatient(0L)).thenReturn(patient);

        mockMvc.perform(get("/patient/0")).andExpect(status().isOk()).andDo(print());
    }
    @Test
    public void savePatientTest() throws Exception{
        LocalDate date = LocalDate.of(2000,02,29);
        Patient patient = new Patient(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");

        mockMvc.perform(post("/patient/add").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(patient))).andExpect(status().isOk()).andDo(print());
    }
    @Test
    public void deletePatientTest() throws Exception{
        mockMvc.perform(delete("/patient/delete").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("patientId","0"))
                .andExpect(status().isOk()).andDo(print());
    }

}
