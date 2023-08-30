package com.mediscreen.practitionersnotesapi.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediscreen.practitionersnotesapi.model.Note;
import com.mediscreen.practitionersnotesapi.service.NoteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @MockBean
    private NoteService noteService;

    @Test
    public void getPatientNoteTest() throws Exception{
        Note note = new Note();
        note.setId("f95223d5669g45662");
        note.setPatId(0L);
        note.setNotes("là, y a vraiment rien à dire");
        List<Note> noteList= new ArrayList<>();
        noteList.add(note);

        when(noteService.findByPatId(0L)).thenReturn(noteList);

        mockMvc.perform(get("/patHistory/0")).andExpect(status().isOk()).andDo(print());

    }

    @Test
    public void getNoteTest() throws Exception{
        Note note = new Note();
        note.setId("f95223d5669g45662");
        note.setPatId(0L);
        note.setNotes("là, y a vraiment rien à dire");

        when(noteService.findById("f95223d5669g45662")).thenReturn(note);

        mockMvc.perform(get("/patHistory/update/0")).andExpect(status().isOk()).andDo(print());

    }

    @Test
    public void addNoteTest() throws Exception{
        Note note = new Note();
        note.setId("f95223d5669g45662");
        note.setPatId(0L);
        note.setNotes("là, y a vraiment rien à dire");

        mockMvc.perform(post("/patHistory/add")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(note)))
                        .andExpect(status().isOk()).andDo(print());

    }

    @Test
    public void updateNoteTest() throws Exception{
        Note note = new Note();
        note.setId("f95223d5669g45662");
        note.setPatId(0L);
        note.setNotes("là, y a vraiment rien à dire");

        mockMvc.perform(post("/patHistory/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(note)))
                .andExpect(status().isOk()).andDo(print());

    }




}
