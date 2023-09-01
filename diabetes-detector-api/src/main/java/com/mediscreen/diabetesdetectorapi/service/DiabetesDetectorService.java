package com.mediscreen.diabetesdetectorapi.service;

import com.mediscreen.diabetesdetectorapi.beans.NoteBean;
import com.mediscreen.diabetesdetectorapi.beans.PatientBean;
import com.mediscreen.diabetesdetectorapi.model.DiabetesReport;
import com.mediscreen.diabetesdetectorapi.proxies.DataPatientsApiProxy;
import com.mediscreen.diabetesdetectorapi.proxies.PractitionersNoteApiProxy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
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
        List<NoteBean> noteList = practitionersNoteApiProxy.getPatientNote(id);
        List<String> noteInStringList = practitionersNoteApiProxy.getNotesInString(id);

        int patientAge = ageCalculator(patient.getDob());
        String patientSex = patient.getSex();

        DiabetesReport report = modelMapper.map(patient, DiabetesReport.class);
        report.setAge(patientAge);
        report.setDiagnostic(defineDiagnostic(noteInStringList,patientAge,patientSex));

        return report;
    }

    private String defineDiagnostic(List<String> noteInStringList, int age, String sex){
        int triggerWordNumber = triggerWordCount(noteInStringList);

        System.out.println("nombre d'occurence: "+triggerWordNumber);
        System.out.println(noteInStringList.toString());
        switch (triggerWordNumber){

            case 0:
                return "aucun risque (None)";

            case 1:
            case 2:
                if (age > 30){
                    return  "risque limité (Borderline)";

                }else {
                    return "aucun risque (None)";
                }

            case 3:
                if (age < 30 && sex == "M"){
                    return "danger (In Danger)";

                }else{
                    return  "risque limité (Borderline)";

                }

            case 4:
                if (age < 30){
                        return "danger (In Danger)";
                }else{
                    return  "risque limité (Borderline)";

                }

            case 5:
                if (age < 30 && sex == "M"){
                    return "apparition précoce (Early onset";

                }else{
                    return  "risque limité (Borderline)";

                }

            case 6:
                return "danger (In Danger)";

            case 7:
                if (age < 30 && sex == "F"){
                    return "apparition précoce (Early onset";

                }else{
                    return "danger (In Danger)";

                }

            case 8:
                return "apparition précoce (Early onset";

            default:
                return "apparition précoce (Early onset";

        }
    }

    private int triggerWordCount(List<String> noteInStringList){

       /* String text = "blaHemogLobinea1c blaghemoglobinea1c";
        String text1 = "Microalbumine";
        List<String> stringList = new ArrayList<>();
        stringList.add(text);
        stringList.add(text1);*/
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

    /**
     * Renvoie le nombre d'occurrences du pattern spécifié dans la chaine de caractères spécifiée
     * @param text chaine de caractères initiale
     * @param regex expression régulière dont le nombre d'occurrences doit etre compté
     * @return le nombre d'occurrences du pattern spécifié dans la chaine de caractères spécifiée
     */
    public static int regexOccur(String text, String regex) {
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
