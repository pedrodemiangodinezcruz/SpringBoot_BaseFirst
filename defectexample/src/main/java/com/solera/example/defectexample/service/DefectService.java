package com.solera.example.defectexample.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.solera.example.defectexample.model.DefectModel;
import com.solera.example.defectexample.repository.DefectRepository;

@Service
public class DefectService {

	@Autowired
	DefectRepository defectRepository;

	//Get all defects
	public ArrayList<DefectModel> getDefects()
	{
		return (ArrayList<DefectModel>)defectRepository.findAll();
	}
	
	//Search by Id
	public Optional<DefectModel> getById(Long id)
	{
		return defectRepository.findById(id);
	}
	
	//Save part
	public DefectModel saveDefect(DefectModel defect) 
	{
		return defectRepository.save(defect);
	}
	
	//Update existing part
	public ResponseEntity<DefectModel> updateDefect(Long id, DefectModel defect)
	{
		DefectModel updateDefect = defectRepository.findById(id)
		        .orElseThrow(()->
		                new IllegalStateException(String.format("The part with id: %d was not found", id)));
		updateDefect.setInspectionID(defect.getInspectionID());
		updateDefect.setPartID(defect.getPartID());
		updateDefect.setStatus(defect.getStatus());
		updateDefect.setComment(defect.getComment());
		updateDefect.setCreatedDate(defect.getCreatedDate());
		updateDefect.setRepairedDate(defect.getRepairedDate());
		defectRepository.save(updateDefect);
		return ResponseEntity.ok(updateDefect);
	}
	
	//Delete part
	public boolean deleteDefect(Long id) 
	{
		try {
			defectRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
