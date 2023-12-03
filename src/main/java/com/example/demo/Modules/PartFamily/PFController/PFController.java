package com.example.demo.Modules.PartFamily.PFController;

import com.example.demo.Modules.PartFamily.PFModel.PFModel;
import com.example.demo.Modules.PartFamily.PFService.PFService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/PFMaster")
@CrossOrigin(origins = "http://localhost:5173")
public class PFController {
    private final PFService myService;

    @Autowired
    public PFController(PFService myService) {
        this.myService = myService;
    }

    @GetMapping()
    public List<PFModel> findAllUsers() {
        return myService.findAllUsers();
    }

    @GetMapping("/{uuid}")
    public Optional<PFModel> findUserByUuid(@PathVariable String uuid) {
        return myService.findByUuid(uuid);
    }

    @PostMapping
    public PFModel saveUser(@RequestBody PFModel model) {
        return myService.saveUser(model);
    }

    @PutMapping("/{uuid}")
    public PFModel updateUser(@PathVariable String uuid, @RequestBody PFModel model) {
        return myService.updateUser(uuid, model);
    }

    @DeleteMapping("/{uuid}")
    public void deleteEmp(@PathVariable String uuid) {
        myService.deleteUser(uuid);
    }


}

