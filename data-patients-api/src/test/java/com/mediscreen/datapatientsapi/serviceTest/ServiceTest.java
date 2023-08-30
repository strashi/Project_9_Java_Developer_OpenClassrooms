package com.mediscreen.datapatientsapi.serviceTest;

import com.mediscreen.datapatientsapi.dao.PatientsDao;
import com.mediscreen.datapatientsapi.model.Patient;
import com.mediscreen.datapatientsapi.service.PatientsService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
public class ServiceTest {
    @MockBean
    private PatientsDao patientsDao;

    @Autowired
    private PatientsService patientsService;

    @Test
    public void getPatientsListTest(){

    }
    @Test
    public void getPatientTest(){
        // GIVEN
        LocalDate date = LocalDate.of(2000,02,29);
        Patient patient = new Patient(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");
        when(patientsDao.findById(0L)).thenReturn(Optional.of(patient));
        // WHEN
        Patient patientTest = patientsService.getPatient(0L);
        // THEN
        Assert.assertSame(patient, patientTest);
    }
    @Test
    public void savePatientTest(){
        // GIVEN
        LocalDate date = LocalDate.of(2000,02,29);
        Patient patient = new Patient(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");

        when(patientsDao.save(patient)).thenReturn(patient);
        // WHEN
        Patient patientTest = patientsService.savePatient(patient);
        // THEN
        Assert.assertSame(patient, patientTest);
    }

    @Test
    public void deletePatientTest(){
        // GIVEN
        LocalDate date = LocalDate.of(2000,02,29);
        Patient patient = new Patient(0L, "Jack", "Black", date, "M", "5 rue du Port", "123-456-789");
        when(patientsDao.findById(0L)).thenReturn(Optional.of(patient));
        doNothing().when(patientsDao).delete(patient);
        // WHEN
        patientsService.deletePatient(0L);
        // THEN
        verify(patientsDao,times(1)).delete(patient);
    }

}
