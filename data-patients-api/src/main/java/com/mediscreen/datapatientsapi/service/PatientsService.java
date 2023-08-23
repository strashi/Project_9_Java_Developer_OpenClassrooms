package com.mediscreen.datapatientsapi.service;

import com.mediscreen.datapatientsapi.dao.PatientsDao;
import com.mediscreen.datapatientsapi.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientsService {

    @Autowired
    private PatientsDao patientsDao;

    public List<Patient> getPatientList(String lastName){
        return patientsDao.findByLastName(lastName);
    }

    public Patient getPatient(Long patientId){
      return patientsDao.findById(patientId).get();
    }

    public Patient savePatient(Patient patient){
        return patientsDao.save(patient);
    }

    public void deletePatient(Long patientId){
        Patient patient = patientsDao.findById(patientId).get();
        patientsDao.delete(patient);
    }
}
