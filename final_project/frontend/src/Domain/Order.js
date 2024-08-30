export class Order {
    orderId;
    people;
    orderDate;
    orderDetails;


    constructor(orderId, people, orderDate, orderDetails) {
        this.orderId = orderId;
        this.people = people;
        this.orderDate = orderDate;
        this.orderDetails = orderDetails;
    }
}