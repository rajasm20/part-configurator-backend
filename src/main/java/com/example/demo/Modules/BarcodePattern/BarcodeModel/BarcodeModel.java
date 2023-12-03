package com.example.demo.Modules.BarcodePattern.BarcodeModel;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

@Data
@Document(collection = "barcode")
public class BarcodeModel {
    
    @Id
    private String uuid;

    private String codeType;

    private String codeDescription;

    private String codeFormat;

    private String patternName;

    private String patternSample;

    private Integer patternLength;

    private List<String> applicableShopTypes;

    private String updatedBy = "Sayli";

    private String updatedAt;

    private String remark;

    public BarcodeModel() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mma dd/MM/yyyy");
        this.updatedAt = dateFormat.format(new Date());
    }
}
