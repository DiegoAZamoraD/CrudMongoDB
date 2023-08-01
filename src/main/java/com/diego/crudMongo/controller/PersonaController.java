
package com.diego.crudMongo.controller;

import com.diego.crudMongo.model.Persona;
import com.diego.crudMongo.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persona") 
public class PersonaController {
    
    @Autowired
    PersonaServiceImpl personaServiceImpl;
    
    @PostMapping("/save")
    public ResponseEntity<Persona> savePersona(@RequestBody Persona persona){
        Persona personaSaved = personaServiceImpl.savePersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(personaSaved);
    }
    
    
}
