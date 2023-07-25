package com.mediscreen.datapatientsapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
public class Patient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "patientId")
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
