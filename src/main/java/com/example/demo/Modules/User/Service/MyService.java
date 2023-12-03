package com.example.demo.Modules.User.Service;

import java.util.List;
import java.util.Optional;
import com.example.demo.Modules.User.Model.Model;

public interface MyService {
    List<Model> findAllUsers();
    Optional<Model> findByUuid(String uuid);
    Model saveUser(Model model);
    Model updateUser(String uuid,Model model);
    void deleteUser(String uuid);
}

