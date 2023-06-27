# Food Management System
Manages restaurant menu for drinks and food

# Project structure
- app: backend application
- nginx: reverse proxy for the application

# Prerequisites
- java 17

# Run Locally
- install java 17.0.4-oracle
- run ```./gradlew clean build```
- run ```docker-compose up --build -d```
- test endpoint: ```curl --location 'http://localhost:80/api/v1/food'```
- to stop infrastructure run: ```docker-compose down```



