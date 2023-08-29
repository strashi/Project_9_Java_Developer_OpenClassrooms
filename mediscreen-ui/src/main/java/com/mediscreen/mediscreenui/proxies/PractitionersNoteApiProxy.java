package com.mediscreen.mediscreenui.proxies;

import com.mediscreen.mediscreenui.beans.NoteBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "practitioners-notes-api", url = "localhost:8082")
public interface PractitionersNoteApiProxy {

    @GetMapping("/patHistory/{patId}")
    List<NoteBean> getPatientNote(@PathVariable Long patId);

    @GetMapping("/patHistory/update/{id}")
    NoteBean getNote(@PathVariable String id);

    @PostMapping("/patHistory/add")
    NoteBean addNote(@RequestBody NoteBean note);

    @PostMapping("/patHistory/update")
    NoteBean updateNote(@RequestBody NoteBean note);

}
