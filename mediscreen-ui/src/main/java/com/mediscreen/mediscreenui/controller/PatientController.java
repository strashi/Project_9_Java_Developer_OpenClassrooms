package com.mediscreen.mediscreenui.controller;

import com.mediscreen.mediscreenui.beans.PatientBean;
import com.mediscreen.mediscreenui.proxies.DataPatientsApiProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("patient/add")
    public String addPatientForm(PatientBean patient){
        return "CreatePatient";
    }

    @PostMapping("/patient/add")
    public String savePatient(@Valid PatientBean patient, BindingResult result){
        if (!result.hasErrors()){
            dataPatientsApiProxy.savePatient(patient);
            return "redirect:/";
        }
        return "CreatePatient";
    }

    @GetMapping("/patient/manage/{patientId}")
    public String managePatient(@PathVariable Long patientId, Model model ){
        PatientBean patient= dataPatientsApiProxy.getPatient(patientId);
        model.addAttribute("patientBean",patient);
        return "ManagePatient";
    }
    @PostMapping("/patient/manage/{patientId}")
    public String updatePatient(@PathVariable Long patientId, PatientBean patient,Model model){
        patient.setPatientId(patientId);
        dataPatientsApiProxy.savePatient(patient);
        return "redirect:/patient/{patientId}";
    }

   @GetMapping("/patient/delete")
   public String deletePatient(@RequestParam Long patientId){
       System.out.println("patientId "+patientId);
        dataPatientsApiProxy.deletePatient(patientId);
       return "redirect:/";
   }

}
