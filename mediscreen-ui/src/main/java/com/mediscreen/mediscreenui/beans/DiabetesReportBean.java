package com.mediscreen.mediscreenui.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class DiabetesReportBean {
    private Long patientId;
    private String firstName;
    private String lastName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern ="yyyy/MM/dd")
    private LocalDate dob;
    private int age;
    private String sex;
    private String address;
    private String phone;
    private String diagnostic;
}
