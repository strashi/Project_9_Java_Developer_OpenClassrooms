package com.mediscreen.mediscreenui.proxies;

import com.mediscreen.mediscreenui.beans.DiabetesReportBean;
import com.mediscreen.mediscreenui.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "diabetes-detector-api", url = "localhost:8083")
public interface DiabetesDetectorApiProxy {

    @PostMapping("/diabetesdetector/{patientId}")
    DiabetesReportBean diabetesDetector(@PathVariable long patientId,
                                       @RequestBody PatientBean patient, @RequestParam List<String> noteList);
}
