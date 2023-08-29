package com.mediscreen.practitionersnotesapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "notes")
public class Note {

    @Id
    private String id;

    private Long patId;

    private String notes;
}
