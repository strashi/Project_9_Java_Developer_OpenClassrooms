package com.mediscreen.mediscreenui.controller;

import com.mediscreen.mediscreenui.beans.PatientBean;
import com.mediscreen.mediscreenui.proxies.DataPatientsApiProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    private DataPatientsApiProxy dataPatientsApiProxy;
    @RequestMapping("/")
    public String listPatient(Model model){
        List<PatientBean> listPatient =dataPatientsApiProxy.listPatient();
        model.addAttribute("listPatient",listPatient);

        return "Accueil";
    }
}
