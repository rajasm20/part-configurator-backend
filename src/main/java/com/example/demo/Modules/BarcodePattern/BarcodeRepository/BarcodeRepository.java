package com.example.demo.Modules.BarcodePattern.BarcodeRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.Modules.BarcodePattern.BarcodeModel.BarcodeModel;

public interface BarcodeRepository extends MongoRepository<BarcodeModel, String> {
    
}
