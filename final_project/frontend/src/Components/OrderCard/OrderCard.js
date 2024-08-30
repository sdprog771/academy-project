import React, {useState} from 'react';
import ModalView from '../Modal/ModalView';
import classes from './OrderCard.css';

/***
 * The OrderCard component is used to create a modal with a card that contains all information about an order.
 * @param props
 * @returns {JSX.Element}
 * @constructor
 */

const OrderCard = (props) => {


    return (
        <ModalView onClose={props.onClose}>
            <div id="total">
                <p><span id="title">Item: </span>{props.el.people.order.orderDetail.item.name}</p>
                <p><span id="title">Quantity: </span>{props.el.people.order.orderDetail.quantity}</p>
                <p><span id="title">Date: </span>{new Date(props.el.people.order.orderDate).toISOString().slice(0, 10)}</p>
                <p><span id="title">Firstname: </span>{props.el.people.firstname}</p>
                <p><span id="title">Lastname: </span>{props.el.people.lastname}</p>
                <p><span id="title">Email: </span>{props.el.people.email}</p>
            </div>
            <div >
                <button id="actionsbutton" onClick={props.onClose}>Close</button>
            </div>
        </ModalView>
    );
}

export default OrderCard;
