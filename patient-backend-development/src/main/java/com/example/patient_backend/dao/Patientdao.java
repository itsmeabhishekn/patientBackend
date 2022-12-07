package com.example.patient_backend.dao;

import com.example.patient_backend.model.Patientmodel;
import org.springframework.data.repository.CrudRepository;

public interface Patientdao extends CrudRepository<Patientmodel,Integer>
{
}
