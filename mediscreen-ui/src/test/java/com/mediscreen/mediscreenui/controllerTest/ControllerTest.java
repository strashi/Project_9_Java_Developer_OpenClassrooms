package com.mediscreen.mediscreenui.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediscreen.mediscreenui.beans.NoteBean;
import com.mediscreen.mediscreenui.beans.PatientBean;
import com.mediscreen.mediscreenui.service.NotesService;
import com.mediscreen.mediscreenui.service.PatientsService;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientsService patientsService;

    @MockBean
    private NotesService notesService;

    @Test
    public void accueilTest() throws Exception{
        mockMvc.perform(get("/")).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void getPatientTest() throws Exception{
        LocalDate date = LocalDate.of(2000,02,29);
        PatientBean patientBean = new PatientBean(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");
        when(patientsService.getPatient(0L)).thenReturn(patientBean);

        NoteBean note = new NoteBean();
        note.setId("f95223d5669g45662");
        note.setPatId(0L);
        note.setNotes("là, y a vraiment rien à dire");
        List<NoteBean> noteList= new ArrayList<>();
        noteList.add(note);
        when(notesService.getPatientNote(0l)).thenReturn(noteList);

        mockMvc.perform(get("/patient/0")).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void addNoteTest() throws Exception{
        NoteBean note = new NoteBean();
        note.setId("f95223d5669g45662");
        note.setPatId(0L);
        note.setNotes("là, y a vraiment rien à dire");

        mockMvc.perform(post("/notes/add/0")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("notes","là, y a vraiment rien à dire"))
                .andExpect(status().isFound()).andDo(print())
                        .andExpect(view().name("redirect:/patient/{patId}"));
    }

    @Test
    public void getNoteTest() throws Exception{
        NoteBean note = new NoteBean();
        note.setId("f95223d5669g45662");
        note.setPatId(0L);
        note.setNotes("là, y a vraiment rien à dire");

        when(notesService.getNote("f95223d5669g45662")).thenReturn(note);

        mockMvc.perform(get("/notes/update/f95223d5669g45662")).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void updateNoteTest() throws Exception{
        NoteBean note = new NoteBean();
        note.setId("f95223d5669g45662");
        note.setPatId(0L);
        note.setNotes("là, y a vraiment rien à dire");

        mockMvc.perform(post("/notes/update/f95223d5669g45662/0")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("notes","là, y a vraiment rien à dire"))
                .andExpect(status().isFound()).andDo(print())
                .andExpect(view().name("redirect:/patient/{patId}"));

    }

    @Test
    public void getPatientsListTest() throws Exception{
        LocalDate date = LocalDate.of(2000,02,29);
        PatientBean patientBean = new PatientBean(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");
        List<PatientBean> list = new ArrayList<>();
        list.add(patientBean);
        when(patientsService.getPatientsList("Black")).thenReturn(list);

        mockMvc.perform(post("/patients").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("lastName","Black"))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(view().name("PatientsList"));
    }
    @Test
    public void addPatientFormTest() throws Exception {
        mockMvc.perform(get("/patient/add")).andExpect(status().isOk()).andDo(print());
    }
    @Test
    public void savePatientTest() throws Exception{

        mockMvc.perform(post("/patient/add").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("patientId","0")
                        .param("firstName","Jack")
                        .param("lastName","Black")
                        .param("dob", "2000-02-29")
                        .param("sex","M")
                        .param("address","5 rue du Port")
                        .param("phone","123-456-789"))

                .andExpect(status().isFound()).andDo(print())
                .andExpect(view().name("redirect:/"));
    }

    @Test
    public void managePatientTest() throws Exception{
        LocalDate date = LocalDate.of(2000,02,29);
        PatientBean patientBean = new PatientBean(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");
        when(patientsService.getPatient(0L)).thenReturn(patientBean);

        mockMvc.perform(get("/patient/manage/0")).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void updatePatientTest() throws Exception{
        LocalDate date = LocalDate.of(2000,02,29);
        PatientBean patientBean = new PatientBean(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");
        when(patientsService.getPatient(0L)).thenReturn(patientBean);

        mockMvc.perform(post("/patient/manage/0").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        //.param("patientId","0")
                        .param("firstName","Jason")
                        .param("lastName","White")
                        .param("dob", "1996-02-29")
                        .param("sex","M")
                        .param("address","25 rue de la mer")
                        .param("phone","987-654-321"))

                .andExpect(status().isFound()).andDo(print())
                .andExpect(view().name("redirect:/patient/{patientId}"));
    }

    @Test
    public void deletePatientTest() throws Exception{

         mockMvc.perform(get("/patient/delete").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("patientId","0"))
                .andExpect(status().isFound()).andDo(print())
                .andExpect(view().name("redirect:/"));

    }

}
