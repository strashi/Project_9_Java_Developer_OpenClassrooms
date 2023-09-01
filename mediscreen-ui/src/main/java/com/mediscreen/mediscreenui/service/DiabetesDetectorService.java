package com.mediscreen.mediscreenui.service;

import com.mediscreen.mediscreenui.beans.DiabetesReportBean;
import com.mediscreen.mediscreenui.proxies.DiabetesDetectorApiProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiabetesDetectorService {

    @Autowired
    private DiabetesDetectorApiProxy diabetesDetectorApiProxy;

    public DiabetesReportBean diabetesDetector(Long patientId){
        return diabetesDetectorApiProxy.diabetesDetector(patientId);

    }
}
