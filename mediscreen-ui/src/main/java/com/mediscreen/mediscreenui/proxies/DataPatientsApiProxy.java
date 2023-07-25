package com.mediscreen.mediscreenui.proxies;

import com.mediscreen.mediscreenui.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@FeignClient(name = "data-patients-api", url = "localhost:8081")
public interface DataPatientsApiProxy {
    @RequestMapping("/")
    List<PatientBean> listPatient();

    @PostMapping("/patient/add")
    PatientBean addPatient(@RequestParam String family, @RequestParam String given, @RequestParam Date dob, @RequestParam String sex,
                              @RequestParam String address, @RequestParam String phone);
}
