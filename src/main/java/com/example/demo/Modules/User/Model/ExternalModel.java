package com.example.demo.Modules.User.Model;

import lombok.Data;

import java.util.List;

@Data
public class ExternalModel {
    private String status;
    private List<Employee> data;
}


