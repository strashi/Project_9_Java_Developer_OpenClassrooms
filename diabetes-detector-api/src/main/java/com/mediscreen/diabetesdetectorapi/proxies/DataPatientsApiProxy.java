package com.mediscreen.diabetesdetectorapi.proxies;

import com.mediscreen.diabetesdetectorapi.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "data-patients-api", url = "localhost:8081")
public interface DataPatientsApiProxy {
    @GetMapping("/patient/{patientId}")
    PatientBean getPatient(@PathVariable Long patientId);
}
