package com.mediscreen.mediscreenui.service;

import com.mediscreen.mediscreenui.beans.NoteBean;
import com.mediscreen.mediscreenui.proxies.PractitionersNoteApiProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {

    @Autowired
    private PractitionersNoteApiProxy practitionersNoteApiProxy;


    public List<NoteBean> getPatientNote(Long patientId) {
        return practitionersNoteApiProxy.getPatientNote(patientId);
    }

    public NoteBean addNote(NoteBean noteBean) {
        return practitionersNoteApiProxy.addNote(noteBean);
    }

    public NoteBean getNote(String id) {
        return practitionersNoteApiProxy.getNote(id);
    }

    public NoteBean updateNote(NoteBean note) {
        return practitionersNoteApiProxy.updateNote(note);
    }
}
