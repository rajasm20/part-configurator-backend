package com.example.demo.Modules.PartFamily.PFService;


import com.example.demo.Modules.PartFamily.PFModel.PFModel;
import com.example.demo.Modules.PartFamily.PFRepository.PFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PFServiceImpl implements PFService {
    private final PFRepository repository;



    @Autowired
    public PFServiceImpl(PFRepository repository) {
        this.repository = repository;

    }

    @Override
    public List<PFModel> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public Optional<PFModel> findByUuid(String uuid) {
        Optional<PFModel> modelObject = repository.findById(uuid);

        if (modelObject.isPresent()) {
            return modelObject;
        } else {

            return Optional.empty();
        }
    }

    @Override
    public PFModel saveUser(PFModel model) {

        model.setLastUpdatedOn(LocalDateTime.now());
        return repository.save(model);
    }

    @Override
    public PFModel updateUser(String uuid, PFModel model) {
        System.out.println("Received UUID: " + uuid);
        if(repository.existsById(uuid)){
            model.setUuid(uuid);
            model.setLastUpdatedOn(LocalDateTime.now());
            return repository.save(model);
        }
        return null;
    }

    @Override
    public void deleteUser(String uuid) {
        repository.deleteById(uuid);

    }


}

