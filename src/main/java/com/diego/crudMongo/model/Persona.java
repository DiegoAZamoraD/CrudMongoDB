
package com.diego.crudMongo.model;

import org.springframework.data.annotation.Id;


public class Persona {
    
    //Atributos 
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    
    //Metodos Constructores
    public Persona(){
        
    }
    
    public Persona(String id, String nombre, String apellido, String telefono){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    //Metodos Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
}
