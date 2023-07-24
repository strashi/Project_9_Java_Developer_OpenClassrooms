package com.mediscreen.datapatientsapi.web.controller;

import com.mediscreen.datapatientsapi.dao.PatientsDao;
import com.mediscreen.datapatientsapi.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientsDao patientsDao;

    @RequestMapping("/")
    public List<Patient> listPatient(){
       return patientsDao.findAll();
    }
}
