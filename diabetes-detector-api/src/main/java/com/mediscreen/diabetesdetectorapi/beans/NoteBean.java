package com.mediscreen.diabetesdetectorapi.beans;

import lombok.Data;

@Data
public class NoteBean {
    private String id;

    private Long patId;

    private String notes;
}
