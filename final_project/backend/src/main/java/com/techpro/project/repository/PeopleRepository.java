package com.techpro.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techpro.project.entity.People;
/***
 * @Repository defines the PeopleRepository that extends JPA repository and provides methods for CRUD operations.
 */
@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {
}

