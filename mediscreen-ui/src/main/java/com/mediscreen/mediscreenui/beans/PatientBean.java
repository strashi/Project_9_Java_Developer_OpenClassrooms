package com.mediscreen.mediscreenui.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientBean implements Serializable {

    private Long patientId;

    @Size(min = 2, max= 20, message = "between 2 und 20 characters")
    @NotBlank(message = "FirstName is mandatory")
    private String firstName;

    @Size(min = 2, max= 30, message = "between 2 und 30 characters")
    @NotBlank(message = "LastName is mandatory")
    private String lastName;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern ="yyyy-MM-dd")
    @NotNull(message = "Date of birthday is mandatory")
    @Past(message = "Date of birthday must be in the past")
    private LocalDate dob;

    @Size(min = 1, max= 1 , message = "only one character")
    @NotBlank(message = "Sex is mandatory")
    private String sex;

    @Size(min = 5, max =60, message = "between 5 und 60 characters")
    @NotBlank(message = "Address is mandatory")
    private String address;

    @Size(min = 8, max= 30, message = "between 8 und 30 numbers")
    @NotBlank(message = "Phone is mandatory")
    private String phone;
}
