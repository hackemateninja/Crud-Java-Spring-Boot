package com.example.democrud.impl;

import com.example.democrud.commons.GenericServiceImpl;
import com.example.democrud.dao.IPersonaDao;
import com.example.democrud.model.Persona;
import com.example.democrud.service.PersonaService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaService {

    private IPersonaDao personaDao;

    PersonaServiceImpl(IPersonaDao personaDao){
        this.personaDao = personaDao;
    }

    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personaDao;
    }
}
