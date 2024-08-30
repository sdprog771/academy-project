package com.techpro.project.entity;

import lombok.*;

import javax.persistence.*;

/***
 *
 * This is a class that defines the entity Item which refers to the relevant table in the 'final-project' database.
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
 * @Table define the creation of table 'items'
 *
 */
@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "items")
public class Item {


    /***
     * itemId the id value of item table
     *
     * This column refers to the id column of the table Items. It is used as a key to be connected to other tables if necessary.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemid")
    private int itemId;

    /***
     * name the name value
     *
     */
    @Column(name = "name")
    private String name;


    /***
     * overriding the toString method of object class
     *
     * @return  a string tha returns the object properties
     */
    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                '}';
    }
}
