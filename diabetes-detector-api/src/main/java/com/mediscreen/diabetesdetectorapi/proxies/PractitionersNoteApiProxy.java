package com.mediscreen.diabetesdetectorapi.proxies;

import com.mediscreen.diabetesdetectorapi.beans.NoteBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "practitioners-notes-api", url = "localhost:8082")
public interface PractitionersNoteApiProxy {
    @GetMapping("/patHistory/{patId}")
    List<NoteBean> getPatientNote(@PathVariable Long patId);

    @GetMapping("/getNotesInString/{patId}")
    List<String> getNotesInString(@PathVariable Long patId);

}
