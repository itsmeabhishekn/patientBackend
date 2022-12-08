package com.example.patient_backend.controller;


import com.example.patient_backend.dao.Patientdao;
import com.example.patient_backend.model.Patientmodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class Patientcontroller {
    @Autowired
    private Patientdao dao;


    @CrossOrigin(origins ="*")
    @GetMapping("/viewall")
    public List<Patientmodel> viewall()
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


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Patientmodel> search(@RequestBody Patientmodel s)
    {
        String id=String.valueOf(s.getId());
        System.out.println(id);
        return (List<Patientmodel>) dao.search(s.getId());
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/delete")
    public HashMap<String, String> delete(@RequestBody Patientmodel d )
    {
        String id = String.valueOf(d.getId());
        System.out.println(id);
        dao.delete(d.getId());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

}
