package com.techpro.project.repository;

import com.techpro.project.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * @Repository defines the OrderDetailRepository that extends JPA repository and provides methods for CRUD operations.
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
