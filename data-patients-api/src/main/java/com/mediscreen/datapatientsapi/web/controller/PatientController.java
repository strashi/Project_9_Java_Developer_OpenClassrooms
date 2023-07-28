package com.mediscreen.datapatientsapi.web.controller;

import com.mediscreen.datapatientsapi.dao.PatientsDao;
import com.mediscreen.datapatientsapi.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    private PatientsDao patientsDao;

   /* @RequestMapping("/")
    public List<Patient> listPatient(){
       return patientsDao.findAll();
    }*/

    @RequestMapping("/patients")
    public List<Patient> getPatientsList(@RequestParam String lastName){
        return patientsDao.findByLastName(lastName);
    }

    @GetMapping("/patient/{patientId}")
    public Patient getPatient(@PathVariable Long patientId){
        return patientsDao.findById(patientId).get();

    }

   /* @PostMapping("/patient/add")
    public Patient addPatient(@RequestParam String lastName,@RequestParam Date dob, @RequestParam String sex,
                              @RequestParam String address, @RequestParam String phone){
        Patient patient = new Patient();
        patient.setLastName(lastName);
        patient.setDob(dob);
        patient.setSex(sex);
        patient.setAddress(address);
        patient.setPhone(phone);
        return patientsDao.save(patient);
    }*/

    @PostMapping("/patient/add")
    public Patient savePatient(@RequestBody Patient patient){
        return patientsDao.save(patient);
    }

    @DeleteMapping ("/patient/delete")
    public void deletePatient(@RequestParam Long patientId){
        Patient patient = patientsDao.findById(patientId).get();
        patientsDao.delete(patient);
    }
}
