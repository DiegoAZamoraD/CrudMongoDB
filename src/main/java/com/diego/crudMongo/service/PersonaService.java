
package com.diego.crudMongo.service;

import com.diego.crudMongo.model.Persona;
import java.util.List;
import java.util.Optional;


public interface PersonaService {
    
    List<Persona> getAllPersonas();
    Optional<Persona>getPersonaById(String id); // Este metodo filtra por id, con optinal permite almacenar un objeto si lo encuetra o puede almacenar nulo
    Persona savePersona(Persona persona);
    void deletePersonaById(String id);
    
}
