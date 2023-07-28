package com.mediscreen.mediscreenui.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
@Data
public class PatientBean implements Serializable {
    private Long patientId;

    private String firstName;
    private String lastName;

    @JsonFormat(pattern ="yyyy/MM/dd")
    private Date dob;
    private String sex;
    private String address;
    private String phone;
}
