package com.solera.example.defectexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.solera.example.defectexample.model.InspectionModel;

@Repository
public interface InspectionRepository extends CrudRepository<InspectionModel, Long>{

}
