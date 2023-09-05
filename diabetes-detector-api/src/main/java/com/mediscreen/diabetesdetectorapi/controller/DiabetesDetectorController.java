package com.mediscreen.diabetesdetectorapi.controller;

import com.mediscreen.diabetesdetectorapi.beans.PatientBean;
import com.mediscreen.diabetesdetectorapi.model.DiabetesReport;
import com.mediscreen.diabetesdetectorapi.service.DiabetesDetectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiabetesDetectorController {

    @Autowired
    private DiabetesDetectorService diabetesDetectorService;

    @PostMapping("/diabetesdetector/{patientId}")
    public DiabetesReport diabetesDetector(@PathVariable long patientId,
                                           @RequestBody PatientBean patient, @RequestParam List<String> noteList){
        return diabetesDetectorService.diabetesDetector(patientId, patient, noteList);

    }
}
