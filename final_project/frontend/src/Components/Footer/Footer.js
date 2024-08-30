import classes from './Footer.module.css';

/***
 * Footer is used to add a footer layer at the bottom of the page. In this application mostly defines the frame of the page.
 * In it there is a short description for the project identity.
 * @returns {JSX.Element}
 * @constructor
 */
const Footer=()=>{

    return(
        <footer className={classes.layout}>Copyright © Sophia Damianidou TechPro Academy 2023</footer>
    );


};

export default Footer;
