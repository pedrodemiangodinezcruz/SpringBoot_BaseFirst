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

import com.solera.example.defectexample.model.DefectModel;
import com.solera.example.defectexample.service.DefectService;

@RestController
@RequestMapping("/api/defects")
public class DefectController {

    @Autowired
    DefectService defectService;

    @GetMapping()
    public ArrayList<DefectModel> getDefect(){
        return defectService.getDefects();
    }
    @PostMapping()
    public String saveDefect(@RequestBody DefectModel defect){
        this.defectService.saveDefect(defect);
        return "";
    }
    @GetMapping(path= "/{id}")
    public Optional<DefectModel> getDefectById(@PathVariable Long id){
        return this.defectService.getById(id);
    }
    @DeleteMapping(path = "/{id}")
    public String deleteDefect(@PathVariable Long id){
        boolean isDeleted = this.defectService.deleteDefect(id);
        if(isDeleted){
            return String.format("The defect with id %d was deleted.", id);
        }else{
            return String.format("The defect with id %d can not be deleted", id);
        }
    }
    @PutMapping(path ="/{id}")
    public void updateDefect (@PathVariable Long id,@RequestBody DefectModel defect){
        this.defectService.updateDefect(id, defect);
    }

}
