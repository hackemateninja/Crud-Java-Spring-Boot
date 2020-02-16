package com.example.democrud.dao;

import com.example.democrud.model.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaDao extends CrudRepository<Persona, Long> {

}
