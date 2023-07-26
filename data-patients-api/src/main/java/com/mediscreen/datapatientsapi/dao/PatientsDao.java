package com.mediscreen.datapatientsapi.dao;

import com.mediscreen.datapatientsapi.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientsDao extends JpaRepository<Patient,Long> {

    List<Patient> findByLastName(String lastName);
}
