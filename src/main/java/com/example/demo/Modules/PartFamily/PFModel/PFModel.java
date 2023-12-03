package com.example.demo.Modules.PartFamily.PFModel;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class PFModel {

    @Id
    private String uuid;

    private String partFamilyName;

    private List<String> applicableShopTypes;

    private List<String> criticality;

    private String updatedBy= "Rajas.M";

    private LocalDateTime lastUpdatedOn;

}
