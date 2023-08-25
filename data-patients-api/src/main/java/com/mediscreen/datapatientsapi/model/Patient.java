package com.mediscreen.datapatientsapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long patientId;

    private String firstName;

    private String lastName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern ="yyyy/MM/dd")
    private LocalDate dob;
    private String sex;
    private String address;
    private String phone;

}
