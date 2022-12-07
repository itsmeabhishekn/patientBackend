package com.example.patient_backend.controller;


import com.example.patient_backend.dao.Patientdao;
import com.example.patient_backend.model.Patientmodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Patientcontroller {
    @Autowired
    private Patientdao dao;
    @CrossOrigin(origins ="*")
    @GetMapping("/viewall")
    public List<Patientmodel> Viewall()
    {
        return (List<Patientmodel>) dao.findAll();
    }
    @CrossOrigin(origins ="*")
    @PostMapping(path="/add",consumes = "application/json",produces = "application/json")
    public String add(@RequestBody Patientmodel p)
    {

        System.out.println(p.getUsername().toString());
        System.out.println(p.getAddress().toString());
        System.out.println(p.getNumber().toString());
        System.out.println(p.getDate().toString());
        System.out.println(p.getUrl().toString());
        System.out.println(p.getDoctor().toString());
        dao.save(p);
        return "Patient data added Successfully";
    }
}
