import React, {useState} from 'react';
import classes from './OrderDetails.module.css';
import BorderColorIcon from '@mui/icons-material/BorderColor';
import ClearIcon from '@mui/icons-material/Clear';
import PreviewIcon from '@mui/icons-material/Preview';
import OrderCard from "../OrderCard/OrderCard";
import EditOrder from '../EditOrder/EditOrder';
import axios from "axios";
import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';

/***
 * OrderDetails component provides actions for viewing, editing and deleting orders.
 * It is directly connected to the ViewOrders component.
 * @param props
 * @returns {JSX.Element}
 * @constructor
 */
const OrderDetails = (props) => {

    const [cardIsShown, setCardIsShown] = useState(false);
    const [editIsShown, setEditIsShown]=useState(false);

    const showCardHandler=()=>{setCardIsShown(true);}
    const hideOrderHandler=()=>{setCardIsShown(false);}

    const showEditHandler=()=>{setEditIsShown(true)};
    const hideEditHandler=()=>{setEditIsShown(false);}

    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);


    const state = {
        people: props.people
    }

    const deleteHandler = (event) => {
        event.preventDefault();

        axios.delete(process.env.REACT_APP_SERVER_HOST + '/people/delete/' + props.people.personId)
            .then(response => {
                setShow(false);
                props.onDeleteOrder();
            });
    };

    function reloadOrders() {
        props.onEditReloadView();
    }

    return (
        <>
            <tr>
                {cardIsShown && <OrderCard onClose={hideOrderHandler} el={state}/>}
                {editIsShown && <EditOrder onClose={hideEditHandler} el={state} onEditOrder={reloadOrders}/>}
                <td>{props.people.order.orderId}</td>
                <td>{props.people.order.orderDetail.item.name}</td>
                <td>{props.people.order.orderDetail.quantity}</td>
                <td>{new Date(props.people.order.orderDate).toISOString().slice(0, 10)}</td>
                <td>
                    <button id="view" type="button" rel="tooltip" className="btn btn-just-icon btn-sm"
                            data-original-title="" title="" onClick={showCardHandler}>
                        <PreviewIcon className={classes.iconsStyle}/>
                    </button>

                    <button id="edit" type="button" rel="tooltip" className="btn btn-just-icon btn-sm"
                            data-original-title="" title="" onClick={showEditHandler}>
                        <BorderColorIcon className={classes.iconsStyle}/>
                    </button>

                    <button id="delete" type="button" rel="tooltip" className="btn btn-just-icon btn-sm"
                            data-original-title="" title="" onClick={handleShow}>
                        <ClearIcon className={classes.iconsStyle}/>
                    </button>
                </td>
            </tr>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton className={classes.confirmHeader}>
                    <Modal.Title>Delete Order</Modal.Title>
                </Modal.Header>
                <Modal.Body>Are you sure to delete this item?</Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Cancel
                    </Button>
                    <Button className={classes.buttonModal}  onClick={deleteHandler}>
                        Confirm
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    );
}


export default OrderDetails;
