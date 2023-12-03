package com.example.demo.Modules.BarcodePattern.BarcodeService;

import com.example.demo.Modules.BarcodePattern.BarcodeRepository.BarcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Modules.BarcodePattern.BarcodeModel.BarcodeModel;

import java.util.List;
import java.util.Optional;

@Service
public class BarcodeServiceImpl implements BarcodeService {

    private final BarcodeRepository barcodeRepository;

    @Autowired
    public BarcodeServiceImpl(BarcodeRepository barcodeRepository) {
        this.barcodeRepository = barcodeRepository;
    }

    @Override
    public BarcodeModel createBarcode(BarcodeModel barcodeModel) {
        return barcodeRepository.save(barcodeModel);
    }

    @Override
    public BarcodeModel getBarcodeById(String uuid) {
        Optional<BarcodeModel> barcodeOptional = barcodeRepository.findById(uuid);
        return barcodeOptional.orElse(null);
    }

    @Override
    public List<BarcodeModel> getAllBarcodes() {
        return barcodeRepository.findAll();
    }

    //update
    @Override
    public BarcodeModel updateBarcode(String uuid, BarcodeModel barcode) {
        if (barcodeRepository.existsById(uuid)) {
            barcode.setUuid(uuid);
            return barcodeRepository.save(barcode);
        }
        return null;
    }

    @Override
    public void deleteBarcode(String uuid) {
        barcodeRepository.deleteById(uuid);
    }
}
