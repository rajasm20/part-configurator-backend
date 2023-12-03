package com.example.demo.Modules.User.Model;

import lombok.*;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "users")
public class Model {

     @Id
    private String uuid;
    private String firstName;
    private String lastName;
    private String age;

}
