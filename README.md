# Spring Boot Application Monitoring Using TIG Stack
Monitors Spring Boot Application using
- [Telegraph](https://www.influxdata.com/time-series-platform/telegraf/)
- [Influxdb](https://www.influxdata.com/)
- [Grafana](https://grafana.com/)

# Project structure
- app: backend application
- nginx: reverse proxy for the application
- grafana
- telegraph
- gradle

# Prerequisites
- java 17

# Run Locally
- install java 17.0.4-oracle
- add [telegraph inputs](https://github.com/influxdata/telegraf/blob/master/plugins/inputs)
- add telegraph dashboard to grafana (id: 61)
- add permissions for docker ```sudo chmod 666 /var/run/docker.sock```
- run ```./gradlew clean build```
- run ```docker-compose up --build -d```
- test endpoint: ```curl --location 'http://localhost:80/application/api/v1/food'```
- to stop the stack run: ```docker-compose down```



