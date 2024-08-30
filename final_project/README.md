<h1> 
# Web APPLICATION: BASIC ONLINE SHOP FUNCTIONALITIES
</h1>
<h2>
# TECHPRO ACADEMY - FINAL ASSIGNMENT
</h2>
<br>
<img src=".\extra material\Home Page.jpg" />
<br>

<h3>
# Application Details
</h3>
<br>

<table>
<tr>
<td>
  This web application is developed with React, SpringBoot and MySQL server to display a basic management tool for covering some basic functional needs of an online store. 
  It helps to organise products, customers and purchases in a simple and effective way. It also provides the flexibility to adjust and further expand the app to meet future needs.
</td>
</tr>
</table> 
<br>

<h3>
## Table of Contents
</h3>
<br>

<p>
-[Getting Started](#getting-started)
</p>
<p>
-[Overview](#overview)
</p>
<p>
-[Buit With](#built-with)
</p>
<p>
-[Project Files Description](#project-files-description)
</p>
<p>
-[Getting Started](#getting-started)
</p>
<p>
-[Site](#site)
</p>
<p>
-[Landing Page](#landing-page)
</p>
<p>
-[Usage](#usage)
</p>
<p>
-[Credits](#credits)
</p>
<p>
-[License](#license)
</p>
<br>

<h3>
## Getting Started
</h3>
<br>

<p>
This project provides a basic web application where orders can be placed and modified.
</p>
<p>
The interface records orders, clients and products while also supports the management of these data.
</p>
<p>
Detailed presentation of the application is included in the Demo and Site parts of this file.
</p>
<br>

<h3>
## Overview
</h3>
<br>

<p>In this project a user can access the home page of the application and select to access either a "place order" service or a "view orders" service.</p>
<p>In the first case the user may use a form and insert information so as to create a new order.</p>
<p>In the second case the user can view all orders saved in the database. Also he/she can select one of the following options:</p>
<p>-use the view icon to view an order's details</p>
<p>-use the edit icon to modify the data of an order</p>
<p>-use the delete icon to remove an existing order</p>
<br>

<h3>
## Built With
</h3>
<br>

<p>This project has been developed by using Javascript and React-18.2.0, React-Dom-18.2.0, React-bootestrap-2.7.4, React-router-dom-6.13.0 packages.</p>
<br>

<p>For the development of backend part it was used Java openjdk-18, Springboot and Maven including the following dependencies:</p>
<p>-springdoc-openapi-ui:v1.6.4</p>
<p>-springfox-swagger2:v2.9.1</p>
<p>-lombok:v1.18.28</p>
<p>-spring-boot-starter-web</p>
<p>-spring-boot-starter-jersey</p>
<p>-spring-boot-starter-jdbc</p>
<p>-spring-boot-starter-data-jpa</p>
<p>-mysql-connector-java</p>
<p>-spring-boot-devtools</p>
<p>-spring-boot-starter-test</p>
<p>-mysql-connector-java:v8.0.28</p>
<br>

<p>For storing data a MySQL database is created. For its creation the file <i>'final_project_db.sql'</i> was executed in MySQL Workbench 8.0CE.</p>
<br>

<p>Docker images pulled from docker hub: <i>alpine:latest, mysql:latest and node:latest</i>.</p>
<br>

<h3>
## Project Files Description 
</h3>
<br>

<p>The project is divided in three parts: The root folder containes the frontend, backend and db directories.</p>
<p>- The folder frontend contains all files and information for executing the JS React part of the application.</p>
<p>- The folder backend contains all files and information for executing the Java (Maven), Spring boot part of the application.</p>
<p>- The folder db contains the <i>.sql</i> file for creating the database of the application.</p>
<br>

<h3>
## Getting Started
</h3>
<br>

<p>You are able to start the application by following the steps below:</p>
<br>

<p>The project has been tested in <i>Linux Ubuntu 20.04.5 Live Server</i>.</p>
<p>In any case it is important that Springboot, Maven and NodeJS are installed.</p>
<br>
<br>

<p>For Linux Ubuntu Server:</p>
<br>

<p>Before any installation please execute: <u>sudo apt update</u> to keep your system updated.</p>
<br>

<p>In Linux Server the project was run by using Docker. The frontend, backend and database were considered as microservices that were 
containerized. For this reason add Docker before running the application.</p>
<p>In the root path execute the commands below to install docker:</p>
<p>- <u>sudo apt install apt-transport-https ca-certificates curl software-properties-common</u></p>
<p>- <u>curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -</u></p>
<p>- <u>sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable"</u></p>
<p>- <u>apt-cache policy docker-ce</u></p>
<p>- <u>sudo apt install docker-ce</u></p>
<p>- <u>sudo systemctl status docker</u></p>
<br>

<p>For running Docker as sudo user you may execute the commands below:
<p>- <u>sudo groupadd docker</u></p>
<p>- <u>sudo usermod -a -G docker  $USER</u></p>
<p>- <u>newgrp docker</u></p>
<br>

<p>To get images for creating the containers execute:
<p>- execute <u> docker pull alpine </u> to get the respective image from the docker hub.</p>
<p>- similarly execute <u> docker pull node </u> and <u> docker pull mysql</u></p>
<p>For this project latest tags were used.
<br>

<p>For the frontend:</p>
<p>- Access frontend folder and execute: <u>sudo apt install npm</u> and <u>npm install</u></p>
<p>For the backend:</p>
<p>- Access backend folder and execute: <u>sudo apt install maven</u></p>
<br>
<p>- Use <u>ifconfig</u> command to get your IP Address and edit the <i>variables.env</i> file to configure your environment. You may also alter the username and passwords.</p>
<p>- Access the backend folder of the project where <i>pom.xml</i> file is saved and execute the following command to build the backend:</p>
<p>- <u>mvn clean install</u></p>
<p>- Access the root folder of the project where <i>docker-compose.yaml</i> file is saved and execute the following command:</p>
<p>- <u>docker compose --env-file variables.env up --build -d</u></p>
<br>
<p>- Alternatively access the project root folder and execute: <u>source script.sh</u> </p>
<p>This script contains the above commands to build and run the application.</p>
<br>

<h2>
## Site
</h2>
<br>

<h3>
For a quick demonstration of the web app interface selected views are presented below.
</h3>
<br>

<img src=".\extra material\Home Page.jpg" />
<i>Home page of the application.</i>
<br>

<img src=".\extra material\Place_order page.jpg" />
<i>Page to place an order.</i>
<br>

<img src=".\extra material\View_Orders.jpg" />
<i>Page to view all saved orders. User can also select to view, edit or delete an order.</i>
<br>

<img src=".\extra material\View_order_details.jpg" />
<i>Pop up window where the details of an order are provided.</i>
<br>

<img src=".\extra material\Edit_Order.jpg" />
<i>Pop up window where user can edit the details of an order and update its data.</i>
<br>

<h2>
## Site performance
</h2>
<br>

<p>Chart showing the performance of the app when create order request is executed.</p>
<img src=".\extra material\Chart_Create_Order.jpg" />
<br>

<p>Chart showing the performance of the app when view all orders request is executed.</p>
<img src=".\extra material\Chart_View_All_Orders.jpg" />
<br>

<p>Chart showing the performance of the app when view order details request is executed.</p>
<img src=".\extra material\Chart_View_Order_Details.jpg" />
<br>

<p>Chart showing the performance of the app when delete order request is executed.</p>
<img src=".\extra material\Chart_Delete_Order.png" />
<br>

<p>Chart showing the performance of the app when update order request is executed.</p>
<img src=".\extra material\Chart_Update_Order.png" />
<br>


<h3>
### Landing page
</h3>
<br>

<p>The path to the application is defined by React default port. Upon execution homepage is loaded on 'http://localhost:3000/' or 'http://yourIpAddress:3000/'</p>
<p>You may also see a list of the available requests by using swagger. Access 'http://localhostOryourIpAddress:8090/myproject' to view the list.</p>
<br>

<h3>
## Usage
</h3>
<p>
## Credits
For the design, creation and development of this project the TechPro Academy team has contributed.
</p>
<p>Also several tutorials on YouTube and websites assisted during the development. Some are listed below.</p>
<br>
<p>https://developer.mozilla.org/</p>
<p>https://docs.docker.com/</p>
<p>https://docs.npmjs.com/</p>
<p>https://react-bootstrap.netlify.app/</p>
<p>https://docs.oracle.com/javase/8/docs/api/java</p>
<p>https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html</p>
<p>https://www.udemy.com/course/react-the-complete-guide-incl-redux</p>
<p>https://spring.io/</p>
<p>https://mvnrepository.com/</p>
<p>https://www.digitalocean.com/</p>
<p>https://zetcode.com/</p>
<p>https://medium.com/</p>
<p>https://stackoverflow.com/</p>
<p>https://dev.to/</p>
<p>https://linuxhandbook.com/</p>
<br>

<h3>
## License
</h3>
<br>
<p>This Web Application is developed under the terms of TechPro Academy Seminar Enterprise as a final project of the program.</p>
<p>It was developed by S Damianidou and submitted on the 28th of June 2023.</p>