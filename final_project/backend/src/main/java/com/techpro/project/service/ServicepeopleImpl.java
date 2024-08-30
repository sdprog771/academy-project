package com.techpro.project.service;

import com.techpro.project.controllers.dto.PeopleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techpro.project.entity.People;
import com.techpro.project.repository.PeopleRepository;

import java.util.List;
import java.util.Optional;

/***
 * The ServicepeopleImpl component is used as a service to handle data regarding people and pass them to the database.
 * It contains references to the PeopleRepository and MappingService.
 * The above are used to combine all necessary information that describe and order and pass them to the CRUD requests.
 * @Component create a class as a component
 */
@Component
public class ServicepeopleImpl implements Servicepeople {

    private PeopleRepository peopleRepository;
    private MappingService mappingService;

    /***
     *
     *@Autowired inject beans when running the application
     * @param peopleRepository
     * @param mappingService
     */
    @Autowired
    public ServicepeopleImpl(PeopleRepository peopleRepository,
                             MappingService mappingService) {
        this.peopleRepository = peopleRepository;
        this.mappingService = mappingService;
    }

    /***
     * @Override override savePeople method for saving a people object to the database.
     * This oject contains information from OrderDetail and Order components.
     * @return  a list of OrderDTO objects that is presented finally on the web page
     */
    @Override
    public PeopleDTO savePeople(PeopleDTO people) {

        final People p = mappingService.mappingPeopleEntity(people);
        p.getOrder().setPeople(p);
        p.getOrder().getOrderDetail().setOrder(p.getOrder());
        final People savedPeople = peopleRepository.save(p);

        return mappingService.mappingPeople(savedPeople);
    }

    /***
     * @Override override readPeople method for finding a PeopleDTO object by id
     * @Param id
     * @return  if object exists returns an OrderDTO object that is presented finally on the web page else null value
     */
    @Override
    public PeopleDTO readPeople(int id) {
        final Optional<People> people = peopleRepository.findById(id);
        if (people.isPresent()) {
            return mappingService.mappingPeople(people.get());
        } else {
            return null;
        }
    }

    /***
     * @Override override updatePeople method for updating a PeopleDTO object
     * @Param people (PeopleDTO)
     * @return  returns an OrderDTO object that is mapped to the database and also projected as an updated instance to the web page
     */
    @Override
    public PeopleDTO updatePeople(PeopleDTO people) {

        final People p = peopleRepository.findById(people.getPersonId()).orElseThrow();

        p.setFirstname(people.getFirstname());
        p.setLastname(people.getLastname());
        p.setEmail(people.getEmail());
        p.getOrder().setOrderDate(people.getOrder().getOrderDate());
        p.getOrder().getOrderDetail().setQuantity(people.getOrder().getOrderDetail().getQuantity());
        p.getOrder().getOrderDetail().getItem().setName(people.getOrder().getOrderDetail().getItem().getName());

        final People saved = peopleRepository.save(p);
        return mappingService.mappingPeople(saved);
    }

    /***
     * @Override override findAll method for projecting all PeopleDTO objects that is a list containing full information for each order
     * @return  a list of PeopleDTO objects that is presented finally on the web page
     */
    @Override
    public List<PeopleDTO> findAll() {
        final List<People> peopleList = peopleRepository.findAll();
        return mappingService.mappingPeopleList(peopleList);
    }


    /***
     * @Override override delete method for deleting an order object
     * @Param id
     */
    public void deletePeople(int id){
        peopleRepository.deleteById(id);

    }
}
