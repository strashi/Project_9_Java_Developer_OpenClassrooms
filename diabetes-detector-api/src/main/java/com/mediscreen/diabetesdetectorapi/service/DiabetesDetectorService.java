package com.mediscreen.diabetesdetectorapi.service;

import com.mediscreen.diabetesdetectorapi.beans.PatientBean;
import com.mediscreen.diabetesdetectorapi.model.DiabetesReport;
import com.mediscreen.diabetesdetectorapi.proxies.DataPatientsApiProxy;
import com.mediscreen.diabetesdetectorapi.proxies.PractitionersNoteApiProxy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DiabetesDetectorService {

    @Autowired
    private DataPatientsApiProxy dataPatientsApiProxy;

    @Autowired
    private PractitionersNoteApiProxy practitionersNoteApiProxy;

    @Autowired
    private ModelMapper modelMapper;

    public DiabetesReport diabetesDetector(long id) {
        PatientBean patient = dataPatientsApiProxy.getPatient(id);
        List<String> noteInStringList = practitionersNoteApiProxy.getNotesInString(id);

        int patientAge = ageCalculator(patient.getDob());
        String patientSex = patient.getSex();

        int triggerWordNumber = triggerWordCount(noteInStringList);

        DiabetesReport report = modelMapper.map(patient, DiabetesReport.class);
        report.setAge(patientAge);
        report.setDiagnostic(defineDiagnostic(triggerWordNumber,patientAge,patientSex));

        return report;
    }

    public String defineDiagnostic(int triggerWordNumber, int age, String sex){

        if ( triggerWordNumber == 0)
            return "aucun risque (None)";

        else{ //triggerWordNumber != 0
            if ( age >= 30){
                if (triggerWordNumber == 1)
                    return "non défini (between None and Borderline)";
                else if (triggerWordNumber >= 2 && triggerWordNumber <= 5)
                    return  "risque limité (Borderline)";
                else if (triggerWordNumber >= 6 && triggerWordNumber <= 7)
                    return "danger (In Danger)";
                else if (triggerWordNumber >=8)
                    return "apparition précoce (Early onset)";

            }else{ //age < 30

                if (sex == "M"){
                   if (triggerWordNumber >= 1 && triggerWordNumber <= 2)
                       return "non défini (between None and In Danger)";
                    else if (triggerWordNumber >= 3 && triggerWordNumber <= 4)
                        return "danger (In Danger)";
                    else if (triggerWordNumber >=5)
                        return "apparition précoce (Early onset)";
                }else{ //sex == "F"
                    if (triggerWordNumber >= 1 && triggerWordNumber <= 3)
                        return "non défini (between None and In Danger)";
                    else if (triggerWordNumber >= 4 && triggerWordNumber <= 6)
                        return "danger (In Danger)";
                    else if (triggerWordNumber >=7)
                        return "apparition précoce (Early onset)";
                }
            }
        }
        return null;
    }

    private int triggerWordCount(List<String> noteInStringList){
        String[] regTab = {"(?i)h[éeè]moglobine[ ]*A1C",
                "(?i)microalbumine",
                "(?i)taille",
                "(?i)poids",
                "(?i)fumeur",
                "(?i)anormal",
                "(?i)cholestérol",
                "(?i)vertige",
                "(?i)rechute",
                "(?i)réaction",
                "(?i)anticorps"};

        int triggerWordCount =0;
        for (String str : noteInStringList){
            for( String reg : regTab) {
                int occur = regexOccur(str, reg);
                triggerWordCount = triggerWordCount + occur;
            }
        }
        return triggerWordCount;
    }

    public int regexOccur(String text, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(text);
        int occur = 0;
        while(matcher.find()) {
            occur ++;
        }
        return occur;
    }
    private int ageCalculator(LocalDate dob){
        LocalDate now = LocalDate.now();
        Period period = Period.between(dob, now);
        return period.getYears();
    }



}
