package com.solera.example.defectexample.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.solera.example.defectexample.model.InspectionModel;
import com.solera.example.defectexample.repository.InspectionRepository;

@Service
public class InspectionService {
	
	@Autowired
	InspectionRepository inspectionRepository;
	
	//Get all inspections
		public ArrayList<InspectionModel> getInspections()
		{
			return (ArrayList<InspectionModel>)inspectionRepository.findAll();
		}
		
		//Search by Id
		public Optional<InspectionModel> getById(Long id)
		{
			return inspectionRepository.findById(id);
		}
		
		//Save part
		public InspectionModel saveInspection(InspectionModel inspection) 
		{
			return inspectionRepository.save(inspection);
		}
		
		//Update existing inspection
		public ResponseEntity<InspectionModel> updateInspection(Long id, InspectionModel inspection)
		{
			InspectionModel updateInspection = inspectionRepository.findById(id)
			        .orElseThrow(()->
			                new IllegalStateException(String.format("The inspection with id: %d was not found", id)));
			updateInspection.setVehicleId(inspection.getVehicleId());
			updateInspection.setDriverId(inspection.getDriverId());
			updateInspection.setComments(inspection.getComments());
			updateInspection.setCreateDate(inspection.getCreatedDate());
			inspectionRepository.save(updateInspection);
			return ResponseEntity.ok(updateInspection);
		}
		
		
		//Delete inspection
		public boolean deleteInspection(Long id) 
		{
			try {
				inspectionRepository.deleteById(id);
				return true;
			}catch(Exception e) {
				return false;
			}
		}
}
