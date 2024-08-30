package com.techpro.project.service;

import com.techpro.project.controllers.dto.PeopleDTO;
import org.springframework.stereotype.Service;


import java.util.List;

/***
 * Create an interface for defining all CRUD methods to be used by its implementation.
 * @Service provide functionalities for the project development
 */
@Service
public interface Servicepeople {


    PeopleDTO savePeople(PeopleDTO people);

    // Read operation
    PeopleDTO readPeople(int id);

    PeopleDTO updatePeople(PeopleDTO people);

    List<PeopleDTO> findAll();

    void deletePeople(int id);


}
