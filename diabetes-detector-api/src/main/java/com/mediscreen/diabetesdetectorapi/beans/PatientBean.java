package com.mediscreen.diabetesdetectorapi.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientBean implements Serializable {
    private Long patientId;

    private String firstName;

    private String lastName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern ="yyyy-MM-dd")
    private LocalDate dob;

    private String sex;

    private String address;

    private String phone;
}
