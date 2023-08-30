package com.mediscreen.mediscreenui.serviceTest;

import com.mediscreen.mediscreenui.beans.NoteBean;
import com.mediscreen.mediscreenui.proxies.PractitionersNoteApiProxy;
import com.mediscreen.mediscreenui.service.NotesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class NotesServiceTest {

    @MockBean
    private PractitionersNoteApiProxy practitionersNoteApiProxy;

    @Autowired
    private NotesService notesService;

    @Test
    public void getPatientNoteTest(){
        // GIVEN
        NoteBean note = new NoteBean();
        note.setId("f95223d5669g45662");
        note.setPatId(1L);
        note.setNotes("là, y a vraiment rien à dire");
        List<NoteBean> noteList= new ArrayList<>();
        noteList.add(note);

        when(practitionersNoteApiProxy.getPatientNote(1L)).thenReturn(noteList);

        // WHEN
        List<NoteBean> testList = notesService.getPatientNote(1L);

        // THEN
        NoteBean noteTest = testList.get(0);
        Assertions.assertSame(note, noteTest);
    }

    @Test
    public void getNoteTest(){
        // GIVEN
        NoteBean note = new NoteBean();
        note.setId("f95223d5669g45662");
        note.setPatId(1L);
        note.setNotes("là, y a vraiment rien à dire");

        when(practitionersNoteApiProxy.getNote("f95223d5669g45662")).thenReturn(note);

        // WHEN
        NoteBean noteTest = notesService.getNote("f95223d5669g45662");

        // THEN
        Assertions.assertSame(note, noteTest);
    }

    @Test
    public void addNoteTest(){
        // GIVEN
        NoteBean note = new NoteBean();
        note.setId("f95223d5669g45662");
        note.setPatId(1L);
        note.setNotes("là, y a vraiment rien à dire");

        when(practitionersNoteApiProxy.addNote(note)).thenReturn(note);

        // WHEN
        NoteBean noteTest = notesService.addNote(note);

        // THEN
        Assertions.assertSame(note, noteTest);
    }

    @Test
    public void updateNoteTest(){
        // GIVEN
        NoteBean note = new NoteBean();
        note.setId("f95223d5669g45662");
        note.setPatId(1L);
        note.setNotes("là, y a vraiment rien à dire");

        when(practitionersNoteApiProxy.updateNote(note)).thenReturn(note);

        // WHEN
        NoteBean noteTest = notesService.updateNote(note);

        // THEN
        Assertions.assertSame(note, noteTest);
    }
}
