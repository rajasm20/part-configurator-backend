package com.example.demo.Modules.BarcodePattern.BarcodeService;

import java.util.List;

import com.example.demo.Modules.BarcodePattern.BarcodeModel.BarcodeModel;

public interface BarcodeService {
    BarcodeModel createBarcode(BarcodeModel barcodeModel);

    BarcodeModel getBarcodeById(String uuid);

    List<BarcodeModel> getAllBarcodes();

    //update code
    BarcodeModel updateBarcode(String uuid, BarcodeModel barcode);

    void deleteBarcode(String uuid);
}

