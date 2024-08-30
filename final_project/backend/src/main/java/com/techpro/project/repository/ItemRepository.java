package com.techpro.project.repository;

import com.techpro.project.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * @Repository defines the ItemRepository that extends JPA repository and provides methods for CRUD operations.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
