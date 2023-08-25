package com.mediscreen.datapatientsapi.web.controller;

import com.mediscreen.datapatientsapi.model.Patient;
import com.mediscreen.datapatientsapi.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientsController {

    @Autowired
    private PatientsService patientsService;

    @GetMapping("/patients")
    public List<Patient> getPatientsList(@RequestParam String lastName){
        return patientsService.getPatientList(lastName);
    }

    @GetMapping("/patient/{patientId}")
    public Patient getPatient(@PathVariable Long patientId){
        return patientsService.getPatient(patientId);
    }

    @PostMapping("/patient/add")
    public Patient savePatient(@RequestBody Patient patient){
        return patientsService.savePatient(patient);
    }

    @DeleteMapping ("/patient/delete")
    public void deletePatient(@RequestParam Long patientId){
        patientsService.deletePatient(patientId);
    }
}
