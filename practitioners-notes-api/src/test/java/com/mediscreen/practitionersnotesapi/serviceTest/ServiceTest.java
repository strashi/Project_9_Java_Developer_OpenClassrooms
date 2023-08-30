package com.mediscreen.practitionersnotesapi.serviceTest;

import com.mediscreen.practitionersnotesapi.model.Note;
import com.mediscreen.practitionersnotesapi.repository.NoteRepository;
import com.mediscreen.practitionersnotesapi.service.NoteService;
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
public class ServiceTest {

    @MockBean
    private NoteRepository noteRepository;

    @Autowired
    private NoteService noteService;

    @Test
    public void findByPatIdTest(){
        // GIVEN
       Note note = new Note();
       note.setId("f95223d5669g45662");
       note.setPatId(1L);
       note.setNotes("là, y a vraiment rien à dire");
       List<Note> noteList= new ArrayList<>();
       noteList.add(note);

       when(noteRepository.findByPatId(1L)).thenReturn(noteList);

        // WHEN
        List<Note> testList = noteService.findByPatId(1L);

        // THEN
        Note noteTest = testList.get(0);
        Assertions.assertSame(note, noteTest);
    }

    @Test
    public void findByIdTest(){
        // GIVEN
        Note note = new Note();
        note.setId("f95223d5669g45662");
        note.setPatId(1L);
        note.setNotes("là, y a vraiment rien à dire");

        when(noteRepository.findById("f95223d5669g45662")).thenReturn(Optional.of(note));

        // WHEN
        Note noteTest = noteService.findById("f95223d5669g45662");

        // THEN
        Assertions.assertSame(note, noteTest);
    }

    @Test
    public void insertTest(){
        // GIVEN
        Note note = new Note();
        note.setId("f95223d5669g45662");
        note.setPatId(1L);
        note.setNotes("là, y a vraiment rien à dire");

        when(noteRepository.insert(note)).thenReturn(note);

        // WHEN
        Note noteTest = noteService.insert(note);

        // THEN
        Assertions.assertSame(note, noteTest);
    }

    @Test
    public void saveTest(){
        // GIVEN
        Note note = new Note();
        note.setId("f95223d5669g45662");
        note.setPatId(1L);
        note.setNotes("là, y a vraiment rien à dire");

        when(noteRepository.save(note)).thenReturn(note);

        // WHEN
        Note noteTest = noteService.save(note);

        // THEN
        Assertions.assertSame(note, noteTest);
    }
}
