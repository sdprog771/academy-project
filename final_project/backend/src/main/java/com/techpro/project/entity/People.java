package com.techpro.project.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 *
 * This is a class that defines the entity People which refers to the relevant table in the 'final-project' database.
 * It comprises all columns and any relations to other tables if existing.
 *
 *
 * @Getter provide getter methods
 * @Setter provide setter methods
 * @Entity Define class as an Entity
 * @Data provide toString method
 * @NoArgsConstructor provide constructor method without parameters
 * @AllArgsConstructor provide constructor method including all parameters
 * @Builder produce builder API
 * @Table define the creation of table 'people'
 *
 */
@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "people")
public class People {

    /***
     * personId the id value of people table
     *
     * This column refers to the id column of the table people. It is used as a key to be connected to other tables if necessary.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "personid")
    private int personId;

    /***
     * firstname the firstname value
     */
    @Column(name = "firstname")
    private String firstname;

    /***
     * lastname the lastname value
     */
    @Column(name = "lastname")
    private String lastname;

    /***
     * email the email value
     */
    @Column(name = "email")
    private String email;

    /***
     * order the order object
     */
    @OneToOne(mappedBy="people", cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "orderid")
    private Order order;

    /***
     * overriding the toString method of object class
     *
     * @return  a string tha returns the object properties
     */
    @Override
    public String toString() {
        return "People{" +
                "personId=" + personId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", order=" + order +
                '}';
    }
}
