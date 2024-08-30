package com.techpro.project.controllers;

import com.techpro.project.controllers.dto.PeopleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.techpro.project.service.Servicepeople;
import java.util.List;

/**
 * The PeopleController class is used to create CRUD methods that can provide a communication
 * layer between frontend and backend based on user requests.
 *
 * @CrossOrigin enable cross-origin resource sharing between frontend and backend
 * @RestController to create RESTful services
 * @RequestMapping map web request
 */
@CrossOrigin(origins = "${CROSS_ORIGIN}")
@RestController
@RequestMapping("people")
public class PeopleController {
    private final Servicepeople servicepeople;

    /**
     * @Autowired inject beans when running the application
     * PeopleController constructor to initialise the service and mapping instances for people.
     */
    @Autowired
    public PeopleController(Servicepeople servicepeople) {
        this.servicepeople = servicepeople;
    }

    /**
     * @GetMapping CRUD operation for retrieving people data.
     * @return return a list of all objects of type People
     */
    @GetMapping(value = "/readAll", produces = "application/json")
    public List<PeopleDTO> getAllPeople() {
        return servicepeople.findAll();
    }

    /**
     * @GetMapping CRUD operation for getting a People instance by id.
     * @PathVariable uses a path variable
     * @return return an object of type People
     */
    @GetMapping(value = "/read/{id}", produces = "application/json")
    public PeopleDTO getPeople(@PathVariable(value = "id") int id) {
        return servicepeople.readPeople(id);
    }

    /**
     * @PostMapping CRUD operation for creating a new People instance.
     * @RequestBody peopleDTO defines the needed parameter
     * @return return an object of type PeopleDTO
     */
    @PostMapping(value = "/create", produces = "application/json")
    public PeopleDTO create(@RequestBody PeopleDTO peopleDTO) {
        return servicepeople.savePeople(peopleDTO);
    }

    /**
     * @PutMapping CRUD operation for creating a new People instance.
     * @RequestBody define id of instance to be updated
     * @RequestBody peopleDTO defines the needed parameter
     * @return return an object of type PeopleDTO
     */
    @PutMapping(value = "/update", produces = "application/json")
    public PeopleDTO updatePeople(@RequestBody PeopleDTO peopleDTO) {
        return servicepeople.updatePeople(peopleDTO);
    }

    /***
     * @DeleteMapping CRUD operation for retrieving data so as to delete them from database.
     * @PathVariable uses a path variable
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
        public void deletePeople(@PathVariable int id){
            servicepeople.deletePeople(id);
        }

}
