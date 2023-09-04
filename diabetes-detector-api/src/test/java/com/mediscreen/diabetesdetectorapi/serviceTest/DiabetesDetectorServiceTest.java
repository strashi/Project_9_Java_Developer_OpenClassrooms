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
    public void diabetesDetectorTest() {

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

        DiabetesReport report = diabetesDetectorService.diabetesDetector(0);

        //ARRANGE

        Assertions.assertSame("danger (In Danger)", report.getDiagnostic());
    }

}
