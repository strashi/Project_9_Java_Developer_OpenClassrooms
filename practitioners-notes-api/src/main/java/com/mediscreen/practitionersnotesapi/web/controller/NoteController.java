package com.mediscreen.practitionersnotesapi.web.controller;

import com.mediscreen.practitionersnotesapi.model.Note;
import com.mediscreen.practitionersnotesapi.repository.NoteRepository;
import com.mediscreen.practitionersnotesapi.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/patHistory/{patId}")
    public List<Note> getPatientNote(@PathVariable Long patId){
        return noteService.findByPatId(patId);
    }

    @GetMapping("/patHistory/update/{id}")
    public Note getNote(@PathVariable String id){
        return noteService.findById(id);
    }

    @PostMapping("/patHistory/add")
    public Note addNote(@RequestBody Note note){
        return noteService.insert(note);
    }

    @PostMapping("/patHistory/update")
    public Note updateNote(@RequestBody Note note){
        return noteService.save(note);
    }

    @GetMapping("/getNotesInString/{patId}")
    public List<String> getNotesInString(@PathVariable Long patId){
        return noteService.getNotesInString(patId);
    }
}
