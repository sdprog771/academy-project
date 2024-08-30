import React, {useEffect, useState} from 'react';
import {Container, Row, Col} from "react-bootstrap";
import OrderDetails from './OrderDetails';
import classes from './ViewOrder.module.css';
import axios from "axios";

/***
 * ViewOrder is the parent component for the presentation of the list of the realised orders.
 * It iterates a dataList and shows the details of each order.
 * ViewOrder is directly connected to the OrderDetails component.
 * @param props
 * @returns {JSX.Element}
 * @constructor
 */
const ViewOrder = (props) => {

    const [dataList1,setDataList1]=useState([]);

    useEffect(() => {
        getOrders();
    }, []);

    function getOrders() {
        axios.get(process.env.REACT_APP_SERVER_HOST + '/people/readAll')
            .then(response => {
                setDataList1(response.data.map(data => data));
            });
    }

    const dataList = dataList1.map(d => <OrderDetails key={d.personId} people={d} onDeleteOrder={getOrders} onEditReloadView={getOrders}/>)


    return (
        <Container className={classes.ok}>
            <Row>
                <Col>
                    <table>
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Quantity</th>
                            <th>Date</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                            {dataList}
                        </tbody>
                    </table>
                </Col>
            </Row>
        </Container>
    );
}

export default ViewOrder;
