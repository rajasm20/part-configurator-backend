package com.example.demo.Modules.BarcodePattern.BarcodeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Modules.BarcodePattern.BarcodeModel.BarcodeModel;
import com.example.demo.Modules.BarcodePattern.BarcodeService.BarcodeService;

import java.util.List;

@RestController
@RequestMapping("/barcode")
@CrossOrigin(origins = "http://localhost:5173")
public class BarcodeController {

    private final BarcodeService barcodeService;

    @Autowired
    public BarcodeController(BarcodeService barcodeService) {
        this.barcodeService = barcodeService;
    }

    @PostMapping
    public BarcodeModel createBarcode(@RequestBody BarcodeModel barcodeModel) {
        return barcodeService.createBarcode(barcodeModel);
    }

    @GetMapping("/{uuid}")
    public BarcodeModel getBarcodeById(@PathVariable String uuid) {
        return barcodeService.getBarcodeById(uuid);
    }

    @GetMapping
    public List<BarcodeModel> getAllBarcodes() {
        return barcodeService.getAllBarcodes();
    }


    //update code starts
    @PutMapping("/{uuid}")
    public BarcodeModel updateBarcode(@PathVariable String uuid, @RequestBody BarcodeModel barcode) {
        return barcodeService.updateBarcode(uuid, barcode);
    }
    //update code ends

    @DeleteMapping("/{uuid}")
    public void deleteBarcode(@PathVariable String uuid) {
        barcodeService.deleteBarcode(uuid);
    }
}

