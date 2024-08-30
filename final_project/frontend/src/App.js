import './App.css';
import FormT from './Components/Form/FormT';
import Header from "./Components/Header/Header";
import Footer from "./Components/Footer/Footer";
import Home from './Components/Home/Home';
import ViewOrder from './Components/ViewOrder/ViewOrder';
import React from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import EditOrder from "./Components/EditOrder/EditOrder";

/***
 *
 * The App component which is the main component of the application is used for presenting properly other components.
 * With BrowserRouter components are also organised based on url paths.
 * @returns {JSX.Element}
 * @constructor
 */
function App() {

    return (
        <Router>
            <Header/>
            <main id="main">
                <Routes>
                    <Route path="/" element={<Home/>}></Route>
                    <Route path="/place_order" element={<FormT />}></Route>
                    <Route path="/view_orders" element={<ViewOrder />}></Route>
                    <Route path="/edit_order/:id" element={<EditOrder/>}></Route>

                    {/*Replace above row with below to view grid*/}
                    {/*<Route path="/view_orders" element={<Grid />}></Route>*/}
                </Routes>
            </main>
            <Footer/>
        </Router>

    );


}

export default App;
