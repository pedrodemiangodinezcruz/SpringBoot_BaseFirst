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

import com.solera.example.defectexample.model.PartModel;
import com.solera.example.defectexample.service.PartService;

@RestController
@RequestMapping("/api/parts")
public class PartController {

    @Autowired
    PartService partService;

    @GetMapping()
    public ArrayList<PartModel> getPart(){
        return partService.getParts();
    }
    @PostMapping()
    public String savePart(@RequestBody PartModel part){
        this.partService.savePart(part);
        return "";
    }
    @GetMapping(path= "/{id}")
    public Optional<PartModel> getPartById(@PathVariable Long id){
        return this.partService.getById(id);
    }
    @DeleteMapping(path = "/{id}")
    public String deletePart(@PathVariable Long id){
        boolean isDeleted = this.partService.deletePart(id);
        if(isDeleted){
            return String.format("The part with id %d was deleted.", id);
        }else{
            return String.format("The part with id %d can not be deleted", id);
        }
    }
    @PutMapping(path ="/{id}")
    public void updatePart(@PathVariable Long id,@RequestBody PartModel part){
        this.partService.updatePart(id, part);
    }

}
