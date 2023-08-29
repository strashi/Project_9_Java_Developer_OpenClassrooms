package com.mediscreen.mediscreenui.proxies;

import com.mediscreen.mediscreenui.beans.NoteBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "practitioners-notes-api", url = "localhost:8082")
public interface PractitionersNoteApiProxy {

    @GetMapping("/patHistory/{patId}")
    List<NoteBean> getPatientNote(@PathVariable Long patId);

    @PostMapping("/patHistory/add")
    NoteBean addNote(@RequestBody NoteBean note);
}
