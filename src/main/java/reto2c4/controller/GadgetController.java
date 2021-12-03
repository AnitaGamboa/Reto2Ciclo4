/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto2c4.controller;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import r2c4.modelos.Gadget;
import r2c4.services.GadgetService;

/**
 *
 * @author anita
 */

@RestController
@RequestMapping("/api/gadget")
@CrossOrigin("*")   

public class GadgetController {
    
    @Autowired
    GadgetService service;
    
  @GetMapping("/all")
    public List<Gadget> getAll() {
        return service.getAll();
    }

    // traer gadget por id
    @GetMapping("/{id}")
    public Optional<Gadget> getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    //Registrar gadget
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget save(@RequestBody Gadget gadget) {
        return service.save(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget update(@RequestBody Gadget gadget) {
        return service.update(gadget);
    }

    /**
     * @DeleteMapping("/{id}") public ResponseEntity delete(@PathVariable ("id")
     * int id){ gadgetService.delete(id); return new
     * ResponseEntity(HttpStatus.NO_CONTENT); }  
   * *
     */
    @DeleteMapping("/{id}") 
    public ResponseEntity delete(@PathVariable ("id") int id){ 
        service.delete(id); 
        return new  ResponseEntity(HttpStatus.NO_CONTENT); 
    }

}
