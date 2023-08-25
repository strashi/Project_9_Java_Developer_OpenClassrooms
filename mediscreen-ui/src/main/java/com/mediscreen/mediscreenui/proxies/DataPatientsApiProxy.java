package com.mediscreen.mediscreenui.proxies;

import com.mediscreen.mediscreenui.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@FeignClient(name = "data-patients-api", url = "localhost:8081")
public interface DataPatientsApiProxy {
   /* @RequestMapping("/")
    List<PatientBean> listPatient();*/
    @GetMapping("/patients")
    List<PatientBean> getPatientsList(@RequestParam String lastName);

    @GetMapping("/patient/{patientId}")
    PatientBean getPatient(@PathVariable Long patientId);

    @PostMapping("/patient/add")
    PatientBean savePatient(PatientBean patient);

    @DeleteMapping("/patient/delete")
    void deletePatient(@RequestParam Long patientId);
}
