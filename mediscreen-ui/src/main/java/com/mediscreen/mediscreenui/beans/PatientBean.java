package com.mediscreen.mediscreenui.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
//import java.sql.Date;
import java.util.Date;
@Data
public class PatientBean implements Serializable {
    private Long patientId;
    @NotBlank(message = "FirstName is mandatory")
    private String firstName;
    @NotBlank(message = "LastName is mandatory")
    private String lastName;
    //@JsonFormat(pattern ="yyyy/MM/dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "dob is mandatory")
    @Past(message = "dob in the past")
    private Date dob;
    @NotBlank(message = "Sex is mandatory")
    private String sex;
    @NotBlank(message = "Address is mandatory")
    private String address;
    @NotBlank(message = "Phone is mandatory")
    private String phone;
}
