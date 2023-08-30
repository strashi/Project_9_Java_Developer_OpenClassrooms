package com.mediscreen.practitionersnotesapi.service;

import com.mediscreen.practitionersnotesapi.model.Note;
import com.mediscreen.practitionersnotesapi.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> findByPatId(Long patId) {
        return noteRepository.findByPatId(patId);
    }

    public Note findById(String id) {
        return noteRepository.findById(id).get();
    }

    public Note insert(Note note) {
        return noteRepository.insert(note);
    }

    public Note save(Note note) {
        return noteRepository.save(note);
    }
}
