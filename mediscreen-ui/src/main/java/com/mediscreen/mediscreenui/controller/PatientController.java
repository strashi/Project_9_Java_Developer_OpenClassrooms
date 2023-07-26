package com.mediscreen.mediscreenui.controller;

import com.mediscreen.mediscreenui.beans.PatientBean;
import com.mediscreen.mediscreenui.proxies.DataPatientsApiProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    private DataPatientsApiProxy dataPatientsApiProxy;

    /*  @RequestMapping("/")
    public String listPatient(Model model){
        List<PatientBean> listPatient =dataPatientsApiProxy.listPatient();
        model.addAttribute("listPatient",listPatient);

        return "Accueil";
    }*/

    @GetMapping("/")
    public String accueil(){
        return "Accueil";
    }

    @GetMapping("/patient/{patientId}")
    public String getPatient(@PathVariable Long patientId, Model model){
        PatientBean patient = dataPatientsApiProxy.getPatient(patientId);
        model.addAttribute("patient", patient);
        return "PatientProfile";
    }


    @RequestMapping("/patients")
    public String getPatientsList(@RequestParam String lastName, Model model){
        List<PatientBean> patientsList = dataPatientsApiProxy.getPatientsList(lastName);
        model.addAttribute("patientsList", patientsList);
        return "PatientsList";
    }
}
