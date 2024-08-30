import classes from "./FormT.module.css";
import React, {useState} from 'react';
import {FormGroup, FormControl, FormLabel, FormText, Container, Row, Col, Form} from "react-bootstrap";
import {useNavigate} from "react-router-dom";
import axios from "axios";

/***
 * FormT componenent provides a form with available input fields where user can insert data and create a new order.
 * @param props
 * @returns {JSX.Element}
 * @constructor
 */
const FormT = (props) => {

    const [itemInput, setItemInput] = useState('');
    const [quantityInput, setQuantityInput] = useState('');
    const [dateInput, setDateInput] = useState('');
    const [firstnameInput, setFirstnameInput] = useState('');
    const [lastnameInput, setLastnameInput] = useState('');
    const [emailInput, setEmailInput] = useState('');
    const navigate = useNavigate();

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
            personId: "",
            firstname: firstnameInput,
            lastname: lastnameInput,
            email: emailInput,
            order: {
                orderId: "",
                personId: "",
                orderDate: new Date(dateInput),
                orderDetail: {
                    orderDetailsId: "",
                    item: {
                        itemId: "",
                        name: itemInput
                    },
                    quantity: quantityInput,
                }
            }
        }

        axios.post(process.env.REACT_APP_SERVER_HOST + '/people/create', people)
            .then(response => {
                navigate("/view_orders");
            });

    };

    return (

        <Container className={classes.all}>
            <Form action="" method="get" className={classes.all} onSubmit={submitHandler}>
                <Row>
                    <Col>
                        <FormGroup className={classes.form}>
                            <FormLabel htmlFor="name" className={classes.label}>Enter item: </FormLabel>
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
                                <FormControl className={classes.input} type="number" name="quantity" id="quantity"
                                             min="1" step="1" required value={quantityInput}
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
                                             className={classes.input} required
                                             min="2023-01-01" max="2023-12-31" value={dateInput}
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
                                 placeholder="name@example.com" required value={emailInput}
                                 onChange={(event) => inputChangeHandler('email', event.target.value)}/>
                    <FormText className={classes.formtext}>
                        Please fill order details.
                    </FormText>
                </FormGroup>

                <div className={classes.positionSubmit}>
                    <button className={classes.submit}>Submit</button>
                </div>
            </Form>


        </Container>

    );

}

export default FormT;
