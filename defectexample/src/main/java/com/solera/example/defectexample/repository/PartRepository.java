package com.solera.example.defectexample.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.solera.example.defectexample.model.PartModel;

@Repository
public interface PartRepository extends CrudRepository<PartModel, Long>{
	
}
