package com.mediscreen.mediscreenui.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;
@Data
public class PatientBean {
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
