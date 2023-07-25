package com.mediscreen.datapatientsapi.web.controller;

import com.mediscreen.datapatientsapi.dao.PatientsDao;
import com.mediscreen.datapatientsapi.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientsDao patientsDao;

    @RequestMapping("/")
    public List<Patient> listPatient(){
       return patientsDao.findAll();
    }

    @PostMapping("/patient/add")
    public Patient addPatient(@RequestParam String family, @RequestParam String given,@RequestParam Date dob, @RequestParam String sex,
                              @RequestParam String address, @RequestParam String phone){
        Patient patient = new Patient();
        patient.setFamily(family);
        patient.setGiven(given);
        patient.setDob(dob);
        patient.setSex(sex);
        patient.setAddress(address);
        patient.setPhone(phone);
        return patientsDao.save(patient);
    }
}
