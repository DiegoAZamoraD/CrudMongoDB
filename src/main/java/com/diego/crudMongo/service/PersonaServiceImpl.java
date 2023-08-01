
package com.diego.crudMongo.service;

import com.diego.crudMongo.api.PersonaRepository;
import com.diego.crudMongo.model.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired // Inyectamos o instanciamos nuestro repositorio
    private PersonaRepository personaRepository;
    
    // Select all for Persona
    @Override
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }
    
    // Select PersonaById
    @Override
    public Optional<Persona> getPersonaById(String id) {
        return personaRepository.findById(id);
    }
    
    // Create Persona
    @Override
    public Persona savePersona(Persona persona) {
        return personaRepository.save(persona);
    }
    
    // Delete Persona
    @Override
    public void deletePersonaById(String id) {
//        Persona persona = personaRepository.findById(id).orElse(null);
//        personaRepository.delete(persona);
          personaRepository.deleteById(id);
    }
    
}
