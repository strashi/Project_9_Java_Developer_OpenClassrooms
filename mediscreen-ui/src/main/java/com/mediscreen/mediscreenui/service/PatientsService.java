package com.mediscreen.mediscreenui.service;

import com.mediscreen.mediscreenui.beans.PatientBean;
import com.mediscreen.mediscreenui.proxies.DataPatientsApiProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
;
import java.util.List;

@Service
public class PatientsService {

    @Autowired
    private DataPatientsApiProxy dataPatientsApiProxy;

    public PatientBean getPatient(Long patientId,){
        return dataPatientsApiProxy.getPatient(patientId);
    }

    public List<PatientBean> getPatientsList(String lastName) {
        return dataPatientsApiProxy.getPatientsList(lastName);
    }

    public PatientBean savePatient(PatientBean patient){
        PatientBean patientBean = dataPatientsApiProxy.savePatient(patient);
        return patientBean;
    }

    public void deletePatient(Long patientId){
        dataPatientsApiProxy.deletePatient(patientId);
    }
}
