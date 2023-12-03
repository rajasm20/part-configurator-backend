package com.example.demo.Modules.PartFamily.PFService;

import com.example.demo.Modules.PartFamily.PFModel.PFModel;

import java.util.List;
import java.util.Optional;

public interface PFService {
    List<PFModel> findAllUsers();
    Optional<PFModel> findByUuid(String uuid);
    PFModel saveUser(PFModel model);
    PFModel updateUser(String uuid, PFModel model);
    void deleteUser(String uuid);




}
