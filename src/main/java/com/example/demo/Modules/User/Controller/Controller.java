package com.example.demo.Modules.User.Controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.Modules.User.Model.Model;
import com.example.demo.Modules.User.Service.MyService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/users")
public class Controller {

    private final MyService myService;

    @Autowired
    public Controller(MyService myService) {
        this.myService = myService;
    }

    @GetMapping()
    public List<Model> findAllUsers() {
        return myService.findAllUsers();
    }

    @GetMapping("/{uuid}")
    public Optional<Model> findUserByUuid(@PathVariable("uuid") String uuid) {
        return myService.findByUuid(uuid);
    }

    @PostMapping
    public Model saveUser(@RequestBody Model model) {
        return myService.saveUser(model);
    }

    @PutMapping("/{uuid}")
    public Model updateUser(@PathVariable("uuid") String uuid, @RequestBody Model model) {
        return myService.updateUser(uuid, model);
    }

    @DeleteMapping("/{uuid}")
    public void deleteUser(@PathVariable("uuid") String uuid) {
        myService.deleteUser(uuid);
    }
}
