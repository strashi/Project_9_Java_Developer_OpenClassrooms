package com.mediscreen.datapatientsapi.dao;

import com.mediscreen.datapatientsapi.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsDao extends JpaRepository<Patient,Long> {
}
