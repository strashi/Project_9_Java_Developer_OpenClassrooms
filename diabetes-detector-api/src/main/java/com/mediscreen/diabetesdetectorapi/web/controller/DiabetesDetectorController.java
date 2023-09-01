package com.mediscreen.diabetesdetectorapi.web.controller;

import com.mediscreen.diabetesdetectorapi.model.DiabetesReport;
import com.mediscreen.diabetesdetectorapi.service.DiabetesDetectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiabetesDetectorController {

    @Autowired
    private DiabetesDetectorService diabetesDetectorService;

    @GetMapping("/diabetesdetector/{patientId}")
    public DiabetesReport diabetesDetector(@PathVariable long patientId){
        return diabetesDetectorService.diabetesDetector(patientId);

    }
}
