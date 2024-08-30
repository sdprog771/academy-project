package com.techpro.project.controllers.dto;

import lombok.*;

import java.sql.Timestamp;

/***
 *
 * This is a class that defines the OrderDTO for passing and getting data to and from the frontend part of the application.
 *
 * @Getter provide getter methods
 * @Setter provide setter methods
 * @NoArgsConstructor provide constructor method without parameters
 * @AllArgsConstructor provide constructor method including all parameters
 * @Builder produce builder API
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    private int orderId;

    private Timestamp orderDate;

    private OrderDetailDTO orderDetail;
}
