package com.mediscreen.mediscreenui.service;

import com.mediscreen.mediscreenui.beans.DiabetesReportBean;
import com.mediscreen.mediscreenui.beans.NoteBean;
import com.mediscreen.mediscreenui.beans.PatientBean;
import com.mediscreen.mediscreenui.proxies.DataPatientsApiProxy;
import com.mediscreen.mediscreenui.proxies.DiabetesDetectorApiProxy;
import com.mediscreen.mediscreenui.proxies.PractitionersNoteApiProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiabetesDetectorService {

    @Autowired
    private DiabetesDetectorApiProxy diabetesDetectorApiProxy;

    @Autowired
    private DataPatientsApiProxy dataPatientsApiProxy;

    @Autowired
    private PractitionersNoteApiProxy practitionersNoteApiProxy;

    public DiabetesReportBean diabetesDetector(Long patientId){
        PatientBean patient = dataPatientsApiProxy.getPatient(patientId);
        List<String> noteList = practitionersNoteApiProxy.getNotesInString(patientId);
        return diabetesDetectorApiProxy.diabetesDetector(patientId,patient,noteList);

    }
}
