package com.example.demo.Modules.PartFamily.PFRepository;



import com.example.demo.Modules.PartFamily.PFModel.PFModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface PFRepository extends MongoRepository<PFModel, String> {

}