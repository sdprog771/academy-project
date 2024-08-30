import classes from './Home.module.css';
import React from 'react';
import mall from '../../Assets/mall.jpg';


/***
 * Home component contains the basic dom elements that are presented in homepage.
 * @returns {JSX.Element}
 * @constructor
 */
const Home = () => {

    return (
        <div >
            <h1>Get the most for your purchases</h1>
        <img src={mall} className={classes.img} />
        </div>
    );
};

export default Home;
