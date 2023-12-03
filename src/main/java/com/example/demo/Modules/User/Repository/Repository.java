package com.example.demo.Modules.User.Repository;

import com.example.demo.Modules.User.Model.Model;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface Repository extends MongoRepository<Model, String> {
    Optional<Model> findByUuid(String uuid);

    void deleteByUuid(String uuid);
}
