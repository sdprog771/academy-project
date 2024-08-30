import classes from './Header.module.css';
import Container from 'react-bootstrap/Container';
import {Nav, Navbar, NavbarBrand, NavLink} from "react-bootstrap";

/***
 * Header concerns the top layer of the web page and contains a navbar for assisting user's navigation in the application environment.
 * @returns {JSX.Element}
 * @constructor
 */
const Header = () => {

    return (

        <Navbar className={classes.layout}>
            <Container>
                <NavbarBrand className={classes.navbrand} href="/">Home</NavbarBrand>
                <Nav>
                    <NavLink className={classes.link} href="place_order">Place Order</NavLink>

                    <NavLink className={classes.link} href="view_orders">View Orders</NavLink>
                </Nav>


            </Container>
        </Navbar>
    );


};

export default Header;
