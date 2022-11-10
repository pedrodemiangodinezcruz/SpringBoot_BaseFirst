package com.solera.example.defectexample.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.example.defectexample.model.InspectionModel;
import com.solera.example.defectexample.service.InspectionService;

@RestController
@RequestMapping("/api/inspections")
public class InspectionController {

    @Autowired
    InspectionService inspectionService;

    @GetMapping()
    public ArrayList<InspectionModel> getInspections(){
        return inspectionService.getInspections();
    }
    @PostMapping()
    public String saveInspections(@RequestBody InspectionModel inspection){
        this.inspectionService.saveInspection(inspection);
        return "";
    }
    @GetMapping(path= "/{id}")
    public Optional<InspectionModel> getInspectionById(@PathVariable Long id){
        return this.inspectionService.getById(id);
    }
    @DeleteMapping(path = "/{id}")
    public String deleteInspection(@PathVariable Long id){
        boolean isDeleted = this.inspectionService.deleteInspection(id);
        if(isDeleted){
            return String.format("The inspection with id %d was deleted.", id);
        }else{
            return String.format("The inspection with id %d can not be deleted", id);
        }
    }
    @PutMapping(path ="/{id}")
    public void updateInspection(@PathVariable Long id,@RequestBody InspectionModel inspection){
        this.inspectionService.updateInspection(id, inspection);
    }

}