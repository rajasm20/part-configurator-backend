package com.example.demo.Modules.User.Service.Impl;

import com.example.demo.GenericHttpClient.GenericHttpClient;
import com.example.demo.Modules.User.Model.Employee;
import com.example.demo.Modules.User.Model.ExternalModel;
import com.example.demo.Modules.User.Repository.Repository;
import com.example.demo.Modules.User.Model.Model;
import com.example.demo.Modules.User.Service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class ServiceImpl implements MyService {
    private final Repository repository;
    private final GenericHttpClient genericHttpClient;

    @Autowired
    public ServiceImpl(Repository repository, GenericHttpClient genericHttpClientService) {
        this.repository = repository;
        this.genericHttpClient = genericHttpClientService;
    }

    @Override
    public List<Model> findAllUsers() {
        List<Model> userData = repository.findAll();

        String baseUrl = "https://dummy.restapiexample.com";
        String endpoint = "/api/v1/employees";
        HttpMethod method = HttpMethod.GET; // or GET, PUT, DELETE, etc.
        Object requestBody = "";
        HttpHeaders customHeaders = new HttpHeaders();
//        customHeaders.add("Authorization", "Bearer your_access_token");
//        customHeaders.add("Custom-Header", "header_value");

        Mono<ExternalModel> externalServiceCallDetails = genericHttpClient.sendRequest(baseUrl, method, endpoint, requestBody, customHeaders, ExternalModel.class);
        externalServiceCallDetails.subscribe(response -> {
            System.out.println("API Response: " + response.getData());
        }, error -> {
            System.err.println("API Error: " + error.getMessage());
        });
        return userData;
    }

    @Override
    public Optional<Model> findByUuid(String uuid) {
        Optional<Model> modelObject = repository.findByUuid(uuid);

        if (modelObject.isPresent()) {
            return modelObject;
        } else {
//            throw new CustomExceptionMessage("My Custom Error", HttpStatus.INTERNAL_SERVER_ERROR.getCode());
            log.info("User not found!");
            return Optional.empty();
        }
    }

    @Override
    public Model saveUser(@RequestBody Model model) {
        model.setUuid((UUID.randomUUID()).toString());
        return repository.save(model);
    }

    @Override
    public Model updateUser(String uuid, Model model) {
        Optional<Model> oldModelObject = repository.findByUuid(uuid);

        if (oldModelObject.isPresent()) {
            Model existingModel = oldModelObject.get();
            existingModel.setFirstName(model.getFirstName());
            existingModel.setLastName(model.getLastName());
            existingModel.setAge(model.getAge());

            return repository.save(existingModel);
        } else {
            log.info("User not found!");
            return null;
        }
    }

    @Override
    public void deleteUser(String uuid) {
        repository.deleteByUuid(uuid);
        log.info("User deleted successfully!");
    }
}
