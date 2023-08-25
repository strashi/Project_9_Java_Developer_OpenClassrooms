package com.mediscreen.mediscreenui.serviceTest;

import com.mediscreen.mediscreenui.beans.PatientBean;
import com.mediscreen.mediscreenui.proxies.DataPatientsApiProxy;
import com.mediscreen.mediscreenui.service.PatientsService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class ServiceTest {

    @MockBean
    private DataPatientsApiProxy dataPatientsApiProxy;

    @Autowired
    private PatientsService patientsService;
    @Test
    public void getPatientTest(){
        // GIVEN
        LocalDate date = LocalDate.of(2000,02,29);
        PatientBean patientBean = new PatientBean(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");
        when(dataPatientsApiProxy.getPatient(0L)).thenReturn(patientBean);
        // WHEN
        PatientBean patientTest = patientsService.getPatient(0L);
        // THEN
        Assert.assertSame(patientBean, patientTest);
    }

    @Test
    public void getPatientsListTest(){
        // GIVEN
        LocalDate date = LocalDate.of(2000,02,29);
        PatientBean patientBean = new PatientBean(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");
        List<PatientBean> list = new ArrayList<>();
        list.add(patientBean);

        when(dataPatientsApiProxy.getPatientsList("Black")).thenReturn(list);
        // WHEN
        List<PatientBean> listTest= patientsService.getPatientsList("Black");
        // THEN
        Assert.assertSame(list, listTest);
    }

    @Test
    public void savePatientTest(){
        // GIVEN
        LocalDate date = LocalDate.of(2000,02,29);
        PatientBean patientBean = new PatientBean(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");

        when(dataPatientsApiProxy.savePatient(patientBean)).thenReturn(patientBean);
        // WHEN
        PatientBean patientTest = patientsService.savePatient(patientBean);
        // THEN
        Assert.assertSame(patientBean, patientTest);
    }

    @Test
    public void deletePatientTest(){
        // GIVEN
        LocalDate date = LocalDate.of(2000,02,29);
        PatientBean patientBean = new PatientBean(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");

        doNothing().when(dataPatientsApiProxy).deletePatient(0L);
        // WHEN
        patientsService.deletePatient(0L);
        // THEN
        verify(dataPatientsApiProxy,times(1)).deletePatient(0L);
    }

}
