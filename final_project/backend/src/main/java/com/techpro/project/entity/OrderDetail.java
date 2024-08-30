package com.techpro.project.entity;

import lombok.*;

import javax.persistence.*;

/***
 *
 * This is a class that defines the entity Order_Details which refers to the relevant table in the 'final-project' database.
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
 * @Table define the creation of table 'order_details'
 *
 */
@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "order_details")
public class OrderDetail {


    /***
     * orderDetailsId the id value of order_details table
     *
     * This column refers to the id column of the table order_details. It is used as a key to be connected to other tables if necessary.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderdetailsid")
    private int orderDetailsId;

    /***
     * order the order object that is related to the orderDetail
     *
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderid", referencedColumnName = "orderid")
    private Order order;

    /***
     * item the item object that is ordered when placing an order
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemid", referencedColumnName = "itemid")
    private Item item;

    /***
     * quantity the quantity value of items
     */
    @Column(name = "quantity")
    private int quantity;


    /***
     * overriding the toString method of object class
     *
     * @return  a string tha returns the object properties
     */
    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailsId=" + orderDetailsId +
                ", orderId=" + order.getOrderId() +
                ", item=" + item +
                ", quantity=" + quantity +
                '}';
    }
}
