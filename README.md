# Wildlife Tracker

Wildlife Tracker is an app that allows one to record sightings of various animal,It allows one to create rangers,locations,animals and 
sightings. It also allows you to view rangers locations sightings and animals. One can also view sightings a ranger has made and 
locations with the sightings that have occured in them

## Author
- [Ruth Mwangi](https://github.com/Ruth-Mwangi)

## Setup/Installation Requirements
* Fork this repo
* Clone this repo 
* Open terminal
* Navigate to appropriate directory using the cd command
* type in the command git clone and paste the url of clone and then press enter 
## Setup Requirements for Database
* In PSQL:
* CREATE DATABASE wildlife_tracker;
* \c wildlife_tracker
* CREATE TABLE animals (id serial PRIMARY KEY, name varchar,type VARCHAR,health VARCHAR,age VARCHAR);
* CREATE TABLE locations (id serial PRIMARY KEY,name VARCHAR);
* CREATE TABLE locations_sightings (id serial PRIMARY KEY,location_id INT,sighting_id INT);
* CREATE TABLE rangers (id serial PRIMARY KEY,name VARCHAR,badge_number VARCHAR);
* CREATE TABLE rangers_sightings (id serial PRIMARY KEY,ranger_id INT,sighting_id INT);
* CREATE TABLE sightings (id serial PRIMARY KEY,animal_id INT,ranger_id INT,location_id INT,time TIMESTAMP);
* CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
## In order to run locally
* Go to DB.class in main/java folder and make necessary changes
* Go to DatabaseRule in test/java folder and make necessary changes

## Technologies Used
* Java
* Heroku
* CSS
* HBS

## Support and contact details
If you come across any problems you can reach me at: rwmwangi96@gmail.com

### License
*This project is licensed under the terms of the MIT license.*
Copyright (c) 2020 **Ruth Mwangi**

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
