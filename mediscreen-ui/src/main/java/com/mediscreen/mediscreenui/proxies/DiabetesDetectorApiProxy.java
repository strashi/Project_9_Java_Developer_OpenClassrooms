package com.mediscreen.mediscreenui.proxies;

import com.mediscreen.mediscreenui.beans.DiabetesReportBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "diabetes-detector-api", url = "localhost:8083")
public interface DiabetesDetectorApiProxy {

    @GetMapping("/diabetesdetector/{patientId}")
    DiabetesReportBean diabetesDetector(@PathVariable long patientId);
}
