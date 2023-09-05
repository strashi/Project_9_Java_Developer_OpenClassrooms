package com.mediscreen.diabetesdetectorapi.serviceTest;

import com.mediscreen.diabetesdetectorapi.beans.NoteBean;
import com.mediscreen.diabetesdetectorapi.beans.PatientBean;
import com.mediscreen.diabetesdetectorapi.model.DiabetesReport;
import com.mediscreen.diabetesdetectorapi.proxies.DataPatientsApiProxy;
import com.mediscreen.diabetesdetectorapi.proxies.PractitionersNoteApiProxy;
import com.mediscreen.diabetesdetectorapi.service.DiabetesDetectorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class DiabetesDetectorServiceTest {

   @Autowired
    private DiabetesDetectorService diabetesDetectorService;

    @MockBean
    private DataPatientsApiProxy dataPatientsApiProxy;

    @MockBean
    private PractitionersNoteApiProxy practitionersNoteApiProxy;

    @Test
    public void diabetesDetectorMaleUnder30WithThreeTriggersTest() {

        // GIVEN
        LocalDate date = LocalDate.of(2000, 02, 29);
        PatientBean patient = new PatientBean(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");

        NoteBean note = new NoteBean();
        note.setId("f95223d5669g45662");
        note.setPatId(0L);
        note.setNotes("anticorps fumeur  microalbumine");
        List<String> stringList = new ArrayList<>();
        stringList.add(note.toString());

        when(dataPatientsApiProxy.getPatient(0L)).thenReturn(patient);
        when(practitionersNoteApiProxy.getNotesInString(0L)).thenReturn(stringList);

        //THEN

        DiabetesReport report = diabetesDetectorService.diabetesDetector(0, patient, stringList);

        //ARRANGE

        Assertions.assertSame("danger (In Danger)", report.getDiagnostic());
    }

    @Test
    public void diabetesDetectorMaleUnder30WithNullTriggerTest() {

        // GIVEN
        LocalDate date = LocalDate.of(2000, 02, 29);
        PatientBean patient = new PatientBean(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");

        NoteBean note = new NoteBean();
        note.setId("f95223d5669g45662");
        note.setPatId(0L);
        note.setNotes(" ");
        List<String> stringList = new ArrayList<>();
        stringList.add(note.toString());

        when(dataPatientsApiProxy.getPatient(0L)).thenReturn(patient);
        when(practitionersNoteApiProxy.getNotesInString(0L)).thenReturn(stringList);

        //THEN

        DiabetesReport report = diabetesDetectorService.diabetesDetector(0, patient, stringList);

        //ARRANGE

        Assertions.assertSame("aucun risque (None)", report.getDiagnostic());
    }

    @Test
    public void diabetesDetectorMaleUnder30WithTwoTriggerTest() {

        // GIVEN
        LocalDate date = LocalDate.of(2000, 02, 29);
        PatientBean patient = new PatientBean(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");

        NoteBean note = new NoteBean();
        note.setId("f95223d5669g45662");
        note.setPatId(0L);
        note.setNotes("anticorps fumeur ");
        List<String> stringList = new ArrayList<>();
        stringList.add(note.toString());

        when(dataPatientsApiProxy.getPatient(0L)).thenReturn(patient);
        when(practitionersNoteApiProxy.getNotesInString(0L)).thenReturn(stringList);

        //THEN

        DiabetesReport report = diabetesDetectorService.diabetesDetector(0, patient, stringList);

        //ARRANGE

        Assertions.assertSame("non défini (between None and In Danger)", report.getDiagnostic());
    }

    @Test
    public void diabetesDetectorMaleUnder30WithFiveTriggerTest() {

        // GIVEN
        LocalDate date = LocalDate.of(2000, 02, 29);
        PatientBean patient = new PatientBean(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");

        NoteBean note = new NoteBean();
        note.setId("f95223d5669g45662");
        note.setPatId(0L);
        note.setNotes("anticorps fumeur poids taille vertige");
        List<String> stringList = new ArrayList<>();
        stringList.add(note.toString());

        when(dataPatientsApiProxy.getPatient(0L)).thenReturn(patient);
        when(practitionersNoteApiProxy.getNotesInString(0L)).thenReturn(stringList);

        //THEN

        DiabetesReport report = diabetesDetectorService.diabetesDetector(0, patient, stringList);

        //ARRANGE

        Assertions.assertSame("apparition précoce (Early onset)", report.getDiagnostic());
    }

    @Test
    public void diabetesDetectorFemaleUnder30WithSevenTriggerTest() {

        // GIVEN
        LocalDate date = LocalDate.of(2000, 02, 29);
        PatientBean patient = new PatientBean(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");

        NoteBean note = new NoteBean();
        note.setId("f95223d5669g45662");
        note.setPatId(0L);
        note.setNotes("anticorps fumeur poids taille vertige anormal rechute");
        List<String> stringList = new ArrayList<>();
        stringList.add(note.toString());

        when(dataPatientsApiProxy.getPatient(0L)).thenReturn(patient);
        when(practitionersNoteApiProxy.getNotesInString(0L)).thenReturn(stringList);

        //THEN

        DiabetesReport report = diabetesDetectorService.diabetesDetector(0, patient, stringList);

        //ARRANGE

        Assertions.assertSame("apparition précoce (Early onset)", report.getDiagnostic());
    }

    @Test
    public void diabetesDetectorFemaleUnder30WithFourTriggerTest() {

        // GIVEN
        LocalDate date = LocalDate.of(2000, 02, 29);
        PatientBean patient = new PatientBean(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");

        NoteBean note = new NoteBean();
        note.setId("f95223d5669g45662");
        note.setPatId(0L);
        note.setNotes("anticorps fumeur poids taille");
        List<String> stringList = new ArrayList<>();
        stringList.add(note.toString());

        when(dataPatientsApiProxy.getPatient(0L)).thenReturn(patient);
        when(practitionersNoteApiProxy.getNotesInString(0L)).thenReturn(stringList);

        //THEN

        DiabetesReport report = diabetesDetectorService.diabetesDetector(0, patient, stringList);

        //ARRANGE

        Assertions.assertSame("danger (In Danger)", report.getDiagnostic());
    }

    @Test
    public void diabetesDetectorFemaleUnder30WithTwoTriggerTest() {

        // GIVEN
        LocalDate date = LocalDate.of(2000, 02, 29);
        PatientBean patient = new PatientBean(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");

        NoteBean note = new NoteBean();
        note.setId("f95223d5669g45662");
        note.setPatId(0L);
        note.setNotes("anticorps fumeur ");
        List<String> stringList = new ArrayList<>();
        stringList.add(note.toString());

        when(dataPatientsApiProxy.getPatient(0L)).thenReturn(patient);
        when(practitionersNoteApiProxy.getNotesInString(0L)).thenReturn(stringList);

        //THEN

        DiabetesReport report = diabetesDetectorService.diabetesDetector(0, patient, stringList);

        //ARRANGE

        Assertions.assertSame("non défini (between None and In Danger)", report.getDiagnostic());
    }
    @Test
    public void diabetesDetectorFemaleAbove30WithTwoTriggerTest() {

        // GIVEN
        LocalDate date = LocalDate.of(1993, 02, 28);
        PatientBean patient = new PatientBean(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");

        NoteBean note = new NoteBean();
        note.setId("f95223d5669g45662");
        note.setPatId(0L);
        note.setNotes("anticorps fumeur ");
        List<String> stringList = new ArrayList<>();
        stringList.add(note.toString());

        when(dataPatientsApiProxy.getPatient(0L)).thenReturn(patient);
        when(practitionersNoteApiProxy.getNotesInString(0L)).thenReturn(stringList);

        //THEN

        DiabetesReport report = diabetesDetectorService.diabetesDetector(0, patient, stringList);

        //ARRANGE

        Assertions.assertSame("risque limité (Borderline)", report.getDiagnostic());
    }

    @Test
    public void diabetesDetectorFemaleAbove30WithSixTriggerTest() {

        // GIVEN
        LocalDate date = LocalDate.of(1993, 02, 28);
        PatientBean patient = new PatientBean(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");

        NoteBean note = new NoteBean();
        note.setId("f95223d5669g45662");
        note.setPatId(0L);
        note.setNotes("anticorps fumeur taille poids anormal rechute");
        List<String> stringList = new ArrayList<>();
        stringList.add(note.toString());

        when(dataPatientsApiProxy.getPatient(0L)).thenReturn(patient);
        when(practitionersNoteApiProxy.getNotesInString(0L)).thenReturn(stringList);

        //THEN

        DiabetesReport report = diabetesDetectorService.diabetesDetector(0, patient, stringList);

        //ARRANGE

        Assertions.assertSame("danger (In Danger)", report.getDiagnostic());
    }

}
