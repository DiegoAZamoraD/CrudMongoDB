
package com.diego.crudMongo.controller;

import com.diego.crudMongo.model.Persona;
import com.diego.crudMongo.service.PersonaServiceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persona") 
public class PersonaController {
    
    @Autowired
    PersonaServiceImpl personaServiceImpl;
    
    @PostMapping("/save")
    public ResponseEntity<Persona> savePersona(@RequestBody @Validated Persona persona){
        Persona personaSaved = personaServiceImpl.savePersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(personaSaved);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Persona>> getPersonas(){
        List<Persona> listaPersonas = personaServiceImpl.getAllPersonas();
        return ResponseEntity.status(HttpStatus.OK).body(listaPersonas);
    }
    
    //Otra Forma de actualziar una persona
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Persona> actualziarPersona(@PathVariable String id, @RequestBody @Validated Persona persona){
//        Optional<Persona> personaOptional = personaServiceImpl.getPersonaById(id);
//        if(personaOptional.isPresent()){
//            persona.setId(id);
//            Persona personaUpdate = personaServiceImpl.savePersona(persona);
//            return ResponseEntity.status(HttpStatus.OK).body(personaUpdate);
//        }else{
//            return ResponseEntity.notFound().build(); // No hay ningun dato
//        }
//    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable String id,@RequestBody Persona persona){
        Optional<Persona> personaFind = personaServiceImpl.getPersonaById(id);
        if(personaFind.isPresent()){
            Persona personaUpdate = personaFind.get();
            personaUpdate.setId(id);
            personaUpdate.setNombre(persona.getNombre());
            personaUpdate.setApellido(persona.getApellido());
            personaUpdate.setTelefono(persona.getTelefono());
            personaServiceImpl.savePersona(personaUpdate);
            return ResponseEntity.status(HttpStatus.OK).body(personaUpdate);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @DeleteMapping("/delete/{id}")
    public void deletePersona(@PathVariable String id){
        personaServiceImpl.deletePersonaById(id);
    }
}
