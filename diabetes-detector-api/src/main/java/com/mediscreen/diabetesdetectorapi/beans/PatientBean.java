package com.mediscreen.diabetesdetectorapi.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
public class PatientBean {
    private Long patientId;

    private String firstName;

    private String lastName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern ="yyyy/MM/dd")
    private LocalDate dob;

    private String sex;

    private String address;

    private String phone;
}
