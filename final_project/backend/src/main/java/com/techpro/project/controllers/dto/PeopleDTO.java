package com.techpro.project.controllers.dto;

import lombok.*;

/***
 *
 * This is a class that defines the PeopleDTO for passing and getting data to and from the frontend part of the application.
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
public class PeopleDTO {

    private int personId;

    private String firstname;

    private String lastname;

    private String email;

    private OrderDTO order;


}
