package com.mediscreen.datapatientsapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long patientId;

    private String firstName;
    private String family;
    private String given;

    @JsonFormat(pattern ="yyyy/MM/dd")
    private Date dob;
    private String sex;
    private String address;
    private String phone;

}
