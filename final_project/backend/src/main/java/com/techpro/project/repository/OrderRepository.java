package com.techpro.project.repository;

import com.techpro.project.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/***
 * @Repository defines the OrderRepository that extends JPA repository and provides methods for CRUD operations.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
