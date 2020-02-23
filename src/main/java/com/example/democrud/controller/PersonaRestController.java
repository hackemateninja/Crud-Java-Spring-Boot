package com.example.democrud.controller;

import com.example.democrud.model.Persona;
import com.example.democrud.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
public class PersonaRestController {

    private PersonaService personaService;

    PersonaRestController(PersonaService personaService){
        this.personaService = personaService;
    }

    @GetMapping(value = "/all")
    public List<Persona> getAll(){
        return personaService.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Persona> find(@PathVariable Long id){
        Persona persona = personaService.get(id);
        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Persona> save(@RequestBody Persona persona){
        Persona obj = personaService.save(persona);
        return new ResponseEntity<Persona>(obj, HttpStatus.CREATED);
    }
    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Persona> delete(@PathVariable Long id){
        Persona persona = personaService.get(id);
        if (persona != null){
            personaService.delete(id);
        }else{
            return new ResponseEntity<Persona>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }
}
