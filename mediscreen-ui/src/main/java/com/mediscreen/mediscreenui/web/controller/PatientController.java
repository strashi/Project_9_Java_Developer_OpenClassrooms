package com.mediscreen.mediscreenui.web.controller;

import com.mediscreen.mediscreenui.beans.NoteBean;
import com.mediscreen.mediscreenui.beans.PatientBean;
import com.mediscreen.mediscreenui.proxies.DataPatientsApiProxy;
import com.mediscreen.mediscreenui.proxies.PractitionersNoteApiProxy;
import com.mediscreen.mediscreenui.service.PatientsService;
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
    private PatientsService patientsService;

    @Autowired
    private PractitionersNoteApiProxy practitionersNoteApiProxy;

    @GetMapping("/")
    public String accueil(){
        return "Accueil";
    }

    @GetMapping("/patient/{patientId}")
    public String getPatient(@PathVariable Long patientId, Model model){
        PatientBean patient = patientsService.getPatient(patientId);
        model.addAttribute("patient", patient);
        List<NoteBean> noteList = practitionersNoteApiProxy.getPatientNote(patientId);
        model.addAttribute("noteList", noteList);
        return "PatientProfile";
    }

    @PostMapping("/notes/add/{patId}")
    public String addNote(@RequestParam String note, @PathVariable Long patId){
        NoteBean noteBean = new NoteBean();
        noteBean.setNotes(note);
        noteBean.setPatId(patId);
        practitionersNoteApiProxy.addNote(noteBean);
        return "redirect:/patient/{patId}";

    }


    @PostMapping("/patients")
    public String getPatientsList(@RequestParam String lastName, Model model){
        List<PatientBean> patientsList = patientsService.getPatientsList(lastName);
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
            patientsService.savePatient(patient);
            return "redirect:/";
        }
        return "CreatePatient";
    }

    @GetMapping("/patient/manage/{patientId}")
    public String managePatient(@PathVariable Long patientId, Model model ){
        PatientBean patient= patientsService.getPatient(patientId);
        model.addAttribute("patientBean",patient);
        return "ManagePatient";
    }
    @PostMapping("/patient/manage/{patientId}")
    public String updatePatient(@PathVariable Long patientId, PatientBean patient){
        patient.setPatientId(patientId);
        patientsService.savePatient(patient);
        return "redirect:/patient/{patientId}";
    }

   @GetMapping("/patient/delete")
   public String deletePatient(@RequestParam Long patientId){
       patientsService.deletePatient(patientId);
       return "redirect:/";
   }

}
