import classes from "./EditOrder.module.css";
import React, {useState} from 'react';
import {FormGroup, FormControl, FormLabel, FormText, Container, Row, Col, Form} from "react-bootstrap";
import ModalEdit from '../ModalEdit/ModalEdit';
import axios from "axios";

/***
 * EditOrder component provides a form that contains all information of an order.
 * There users can choose to update as many fields they wish save data and send them back to the database.
 * @param props
 * @returns {JSX.Element}
 * @constructor
 */
const EditOrder = (props) => {

    const [itemInput, setItemInput] = useState(props.el.people.order.orderDetail.item.name);
    const [quantityInput, setQuantityInput] = useState(props.el.people.order.orderDetail.quantity);
    const [dateInput, setDateInput] = useState(new Date(props.el.people.order.orderDate).toISOString().slice(0, 10));
    const [firstnameInput, setFirstnameInput] = useState(props.el.people.firstname);
    const [lastnameInput, setLastnameInput] = useState(props.el.people.lastname);
    const [emailInput, setEmailInput] = useState(props.el.people.email);

    const inputChangeHandler = (identifier, value) => {
        if (identifier === 'item') {
            setItemInput(value);
        } else if (identifier === 'quantity') {
            setQuantityInput(value);
        } else if (identifier === 'date') {
            setDateInput(value);
        } else if (identifier === 'firstname') {
            setFirstnameInput(value);
        } else if (identifier === 'lastname') {
            setLastnameInput(value);
        } else if (identifier === 'email') {
            setEmailInput(value);
        }
    };

    const submitHandler = (event) => {
        event.preventDefault();
        const people = {
            personId: props.el.people.personId,
            firstname: firstnameInput,
            lastname: lastnameInput,
            email: emailInput,
            order: {
                orderId: props.el.people.order.orderId,
                orderDate: new Date(dateInput).toISOString(),
                orderDetail: {
                    orderDetailsId: props.el.people.order.orderDetail.orderDetailsId,
                    orderId: props.el.people.order.orderId,
                    item: {
                        itemId: props.el.people.order.orderDetail.item.itemId,
                        name: itemInput
                    },
                    quantity: quantityInput,
                }
            }
        }

        axios.put(process.env.REACT_APP_SERVER_HOST + '/people/update', people)
            .then(response => {
                props.onClose();
                props.onEditOrder();
            });
    };

    return (
        <ModalEdit onClose={props.onClose}>
            <Container className={classes.all}>
                <Form action="" method="get" className={classes.all} onSubmit={submitHandler}>
                    <Row>
                        <Col>
                            <FormGroup className={classes.form}>
                                <FormLabel htmlFor="name" className={classes.label}>Enter item:</FormLabel>
                                <FormControl type="text" name="item" id="item" className={classes.format} required
                                             value={itemInput}
                                             onChange={(event) => inputChangeHandler('item', event.target.value)}/>
                                <FormText className={classes.formtext}>
                                    Please enter an item you wish to purchase.
                                </FormText>
                            </FormGroup>
                        </Col>
                    </Row>

                    <Row>
                        <Col size={4}>
                            <FormGroup className={classes.form}>
                                <div>
                                    <FormLabel className={classes.label} htmlFor="name">Quantity: </FormLabel>
                                </div>
                                <div>
                                    <FormControl className={classes.input} type="number" name="quantity"
                                                 id="quantity" min="1" step="1"
                                                 required
                                                 value={quantityInput}
                                                 onChange={(event) => inputChangeHandler('quantity', event.target.value)}/>
                                </div>
                                <FormText>
                                    Please enter the amount of items.
                                </FormText>
                            </FormGroup>
                        </Col>
                        <Col size={4}>
                            <FormGroup className={classes.form}>
                                <div>
                                    <FormLabel htmlFor="start" className={classes.label}>Order date:</FormLabel>
                                </div>
                                <div>
                                    <FormControl type="date" name="date" id="date"
                                                 className={classes.input}
                                                 min="2023-01-01" max="2023-12-31"
                                                 value={dateInput}
                                                 onChange={(event) => inputChangeHandler('date', event.target.value)}></FormControl>
                                </div>
                            </FormGroup>
                        </Col>
                    </Row>

                    <FormGroup className={classes.form}>
                        <FormLabel htmlFor="name" className={classes.label}>Enter your first name: </FormLabel>
                        <FormControl type="text" name="firstname" id="firstname" className={classes.format} required
                                     value={firstnameInput}
                                     onChange={(event) => inputChangeHandler('firstname', event.target.value)}/>
                        <FormText className={classes.formtext}>
                            Please fill order details.
                        </FormText>
                    </FormGroup>
                    <FormGroup className={classes.form}>
                        <FormLabel htmlFor="name" className={classes.label}>Enter your last name: </FormLabel>
                        <FormControl type="text" name="lastname" id="lastname" className={classes.format} required
                                     value={lastnameInput}
                                     onChange={(event) => inputChangeHandler('lastname', event.target.value)}/>
                        <FormText className={classes.formtext}>
                            Please fill order details.
                        </FormText>
                    </FormGroup>
                    <FormGroup className={classes.form}>
                        <FormLabel htmlFor="email" className={classes.label}>Enter your email: </FormLabel>
                        <FormControl type="email" name="email" id="email" className={classes.format}
                                     placeholder="name@example.com" required
                                     value={emailInput}
                                     onChange={(event) => inputChangeHandler('email', event.target.value)}/>
                        <FormText className={classes.formtext}>
                            Please fill order details.
                        </FormText>
                    </FormGroup>
                    <div className={classes.positionSave}>
                        <span><button className={classes.save}>Save</button></span>
                        <span>
                                <a href="view_orders">
                                    <button className={classes.close} onClick={props.onClose}>Close</button>
                                </a>
                            </span>
                    </div>
                </Form>
            </Container>
        </ModalEdit>
    );

}

export default EditOrder;
