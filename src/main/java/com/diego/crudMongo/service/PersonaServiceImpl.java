
package com.diego.crudMongo.service;

import com.diego.crudMongo.api.PersonaRepository;
import com.diego.crudMongo.model.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;
    
    @Override
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Optional<Persona> getPersonaById(Long id) {
//        Persona persona = personaRepository.findById(id).orElse(null);
//        Optional<Persona> personaEncontrada = Optional.of(persona);
//        return personaEncontrada;
        return personaRepository.findById(id);
    }

    @Override
    public Persona savePersona(Persona persona) {
        personaRepository.save(persona);
        return persona;
    }

    @Override
    public void deletePersonaById(Long id) {
        Persona persona = personaRepository.findById(id).orElse(null);
        personaRepository.delete(persona);
    }
    
}
