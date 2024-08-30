import React from 'react';
import classes from './ModalView.module.css';
import  {Fragment} from 'react';
import ReactDOM from "react-dom";


/***
 * The ModalView component is used to create the creation of the modal tha wraps the OrderCard dom element.
 * It comprises also the backdrop part.
 * @param props
 * @returns {JSX.Element}
 * @constructor
 */
const Backdrop = props => {
    return(
        <div className={classes.backdrop} onClick={props.onClose}></div>
    );
};

const ModalOverlay = props => {
    return(
        <div className={classes.modal}>
            <div className={classes.content}>{props.children}</div>
        </div>
    );
};

const portalElement=document.getElementById('overlays');

const ModalView=(props)=>{


    return(
       <Fragment>
           {ReactDOM.createPortal(<Backdrop onClose={props.onClose}/>,portalElement )}
           {ReactDOM.createPortal(<ModalOverlay>{props.children}</ModalOverlay>, portalElement)}
       </Fragment>
    );
}

export default ModalView;
