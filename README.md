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
- run ```./gradlew clean build```
- run ```docker-compose up --build -d```
- test endpoint: ```curl --location 'http://localhost:80/application/api/v1/food'```
- to stop the stack run: ```docker-compose down```

# Performance Tests

## No traffic
![alt text](./docs/monitoring/no-traffic/system-io.png)
![alt text](./docs/monitoring/no-traffic/system-load.png)
![alt text](./docs/monitoring/no-traffic/nginx.png)
![alt text](./docs/monitoring/no-traffic/network.png)
![alt text](./docs/monitoring/no-traffic/mongo.png)
![alt text](./docs/monitoring/no-traffic/monog-insert-to-db.png)
![alt text](./docs/monitoring/no-traffic/elastic.png)
![alt text](./docs/monitoring/no-traffic/elastic-threads.png)


## Concurrency 50, threads 50, time 10 sec
```ab -c 50 -n 50 -t 20 http://localhost:80/application/api/v1/food```
![alt text](./docs/monitoring/c50n50t20/system-load.png)
![alt text](./docs/monitoring/c50n50t20/system-io.png)
![alt text](./docs/monitoring/c50n50t20/network.png)
![alt text](./docs/monitoring/c50n50t20/nginx.png)
![alt text](./docs/monitoring/c50n50t20/mongo.png)
![alt text](./docs/monitoring/c50n50t20/elastic-load.png)
![alt text](./docs/monitoring/c50n50t20/elastic-indices.png)
![alt text](./docs/monitoring/c50n50t20/elastic-threads.png)


## Concurrency 50, threads 100, time 60 sec
```ab -c 50 -n 100 -t 60 http://localhost:80/application/api/v1/food```
![alt text](./docs/monitoring/c50n100t60/system-load.png)
![alt text](./docs/monitoring/c50n100t60/system-io.png)
![alt text](./docs/monitoring/c50n100t60/nginx.png)
![alt text](./docs/monitoring/c50n100t60/mongo.png)
![alt text](./docs/monitoring/c50n100t60/elastic.png)

## Comparing diagrams in 30 min window between no traffic, low load, high load

![alt text](./docs/monitoring/notrafic-c50n50t20-c50n100t60-30min-window/system-load.png)
![alt text](./docs/monitoring/notrafic-c50n50t20-c50n100t60-30min-window/system-io.png)
![alt text](./docs/monitoring/notrafic-c50n50t20-c50n100t60-30min-window/network.png)
![alt text](./docs/monitoring/notrafic-c50n50t20-c50n100t60-30min-window/nginx.png)
![alt text](./docs/monitoring/notrafic-c50n50t20-c50n100t60-30min-window/mongo.png)
![alt text](./docs/monitoring/notrafic-c50n50t20-c50n100t60-30min-window/elastic.png)
![alt text](./docs/monitoring/notrafic-c50n50t20-c50n100t60-30min-window/elastic-threads.png)
![alt text](./docs/monitoring/notrafic-c50n50t20-c50n100t60-30min-window/elastic-idx.png)


