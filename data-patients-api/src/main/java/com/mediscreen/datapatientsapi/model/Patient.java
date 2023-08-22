package com.mediscreen.datapatientsapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Patient implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long patientId;

    private String firstName;

    private String lastName;

    @JsonFormat(pattern ="yyyy/MM/dd")
    private Date dob;
    private String sex;
    private String address;
    private String phone;

}
