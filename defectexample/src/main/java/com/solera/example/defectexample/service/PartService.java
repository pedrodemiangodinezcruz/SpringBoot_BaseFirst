package com.solera.example.defectexample.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.solera.example.defectexample.model.PartModel;
import com.solera.example.defectexample.repository.PartRepository;

@Service
public class PartService {
	
	@Autowired
	PartRepository partRepository;
	
	//Get all parts
	public ArrayList<PartModel> getParts()
	{
		return (ArrayList<PartModel>)partRepository.findAll();
	}
	
	//Search by Id
	public Optional<PartModel> getById(Long id)
	{
		return partRepository.findById(id);
	}
	
	//Save part
	public PartModel savePart(PartModel part) 
	{
		return partRepository.save(part);
	}
	
	//Update existing part
	public ResponseEntity<PartModel> updatePart(Long id, PartModel part)
	{
		PartModel updatePart = partRepository.findById(id)
		        .orElseThrow(()->
		                new IllegalStateException(String.format("The part with id: %d was not found", id)));
		updatePart.setName(part.getName());
		partRepository.save(updatePart);
		return ResponseEntity.ok(updatePart);
	}
	
	//Delete part
	public boolean deletePart(Long id) 
	{
		try {
			partRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
