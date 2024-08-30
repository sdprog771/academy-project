package com.techpro.project.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

/***
 *
 * This is a class that defines the entity Order which refers to the relevant table in the 'final-project' database.
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
 * @Table define the creation of table 'order'
 *
 */
@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order {

    /***
     * orderId the id value of order table
     *
     * This column refers to the id column of the table Order. It is used as a key to be connected to other tables if necessary.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private int orderId;

    /***
     * people the people object that is related to the order
     *
     */
    @OneToOne
    @JoinColumn(name="personid", nullable=false)
    private People people;


    /***
     * orderDate the date value of the order
     *
     */
    @Column(name = "orderdate")
    private Timestamp orderDate;

    /***
     * orderDetail the orderDetail object that carries more information about the order
     *
     */
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    @JoinColumn(name = "order_detail_id", referencedColumnName = "orderdetailsid")
    private OrderDetail orderDetail;

    /***
     * overriding the toString method of object class
     *
     * @return  a string tha returns the object properties
     */
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", peopleId=" + people.getPersonId() +
                ", orderDate=" + orderDate +
                ", orderDetail=" + orderDetail +
                '}';
    }
}
