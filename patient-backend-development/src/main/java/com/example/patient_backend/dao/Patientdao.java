package com.example.patient_backend.dao;

import com.example.patient_backend.model.Patientmodel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Patientdao extends CrudRepository<Patientmodel,Integer>
{

    @Query(value = "SELECT `id`, `address`, `date`, `doctor`, `number`, `url`, `username` FROM `patient` WHERE `id` = :id",nativeQuery = true)
    List<Patientmodel> search(@Param("id") Integer id);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `patient` WHERE `id` = :id",nativeQuery = true)
    void delete(@Param("id") Integer id);
}
