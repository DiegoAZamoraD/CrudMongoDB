
package com.diego.crudMongo.api;

import com.diego.crudMongo.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository<Persona, String>{
    
}
