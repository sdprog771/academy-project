package com.techpro.project.service;

import com.techpro.project.controllers.dto.ItemDTO;
import com.techpro.project.controllers.dto.OrderDTO;
import com.techpro.project.controllers.dto.OrderDetailDTO;
import com.techpro.project.controllers.dto.PeopleDTO;
import com.techpro.project.entity.Item;
import com.techpro.project.entity.Order;
import com.techpro.project.entity.OrderDetail;
import com.techpro.project.entity.People;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/***
 * The MappingService component is used as a service to handle data regarding people, orders and items. It provides a mapping service that
 * gets object data seperately and combine them to create a PeopleDTO object that contains all information for an order.
 * @Component create a class as a component
 */
@Component
public class MappingService {

    /***
     * Method for mapping a People object to a PeopleDTO object
     * @Param people (People)
     * @return a PeopleDTO object containing a series of details fully describing an order
     */
    public PeopleDTO mappingPeople(People people) {
        return PeopleDTO.builder()
                .personId(people.getPersonId())
                .firstname(people.getFirstname())
                .lastname(people.getLastname())
                .email(people.getEmail())
                .order(mappingOrderDTO(people.getOrder()))
                .build();
    }

    /***
     * Method for mapping a list of People to a list of PeopleDTO objects
     * @Param peopleList
     * @return a list of PeopleDTO objects
     */
    public List<PeopleDTO> mappingPeopleList(List<People> peopleList){
        return peopleList.stream().map(this::mappingPeople).collect(Collectors.toList());
    }

    /***
     * Method for mapping an Order object to an OrderDTO object
     * @Param order
     * @return an OrderDTO object
     */
    public OrderDTO mappingOrderDTO(Order order) {
        return OrderDTO.builder()
                .orderId(order.getOrderId())
                .orderDate(order.getOrderDate())
                .orderDetail(mappingOrderDetailDTO(order.getOrderDetail(), order.getOrderId()))
                .build();
    }

    /***
     * Method for mapping an OrderDetail object to an OrderDetailDTO object
     * @Param order, orderId
     * @return an OrderDTO object
     */
    public OrderDetailDTO mappingOrderDetailDTO(OrderDetail orderDetail, int orderId) {
        return OrderDetailDTO.builder()
                .orderDetailsId(orderDetail.getOrderDetailsId())
                .quantity(orderDetail.getQuantity())
                .item(mappingItemDTO(orderDetail.getItem()))
                .orderId(orderId)
                .build();
    }

    /***
     * Method for mapping an Item object to an ItemDTO object
     * @Param item
     * @return an ItemDTO object
     */
    public ItemDTO mappingItemDTO(Item item) {
        return ItemDTO.builder()
                .itemId(item.getItemId())
                .name(item.getName())
                .build();
    }

    /***
     * Method for mapping an OrderDTO object to an Order object using an OrderDetail object instead of orderId
     * @Param orderDTO
     * @return an Order object
     */
    public Order mappingOrderEntity(OrderDTO orderDTO) {
        return Order.builder()
                .orderId(orderDTO.getOrderId())
                .orderDate(orderDTO.getOrderDate())
                .orderDetail(mappingOrderDetailEntity(orderDTO.getOrderDetail()))
                .build();

    }

    /***
     * Method for mapping an OrderDetailDTO object to an OrderDetail object using an item object
     * @Param orderDetailDTO
     * @return an OrderDetail object
     */
    public OrderDetail mappingOrderDetailEntity(OrderDetailDTO orderDetailDTO) {
        return OrderDetail.builder()
                .orderDetailsId(orderDetailDTO.getOrderId())
                .quantity(orderDetailDTO.getQuantity())
                .item(mappingItemEntity(orderDetailDTO.getItem()))
                .build();
    }

    /***
     * Method for mapping an ItemDTO object to an Item object
     * @Param itemDTO
     * @return an Item object
     */
    public Item mappingItemEntity(ItemDTO itemDTO) {
        return Item.builder()
                .itemId(itemDTO.getItemId())
                .name(itemDTO.getName())
                .build();
    }

    /***
     * Method for mapping an PeopleDTO object to an People object
     * @Param peopleDTO
     * @return a People object
     */
    public People mappingPeopleEntity(PeopleDTO peopleDTO) {
        return People.builder()
                .personId(peopleDTO.getPersonId())
                .firstname(peopleDTO.getFirstname())
                .lastname(peopleDTO.getLastname())
                .email(peopleDTO.getEmail())
                .order(mappingOrderEntity(peopleDTO.getOrder()))
                .build();
    }

}
