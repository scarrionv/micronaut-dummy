# Micronaut dummy

This is just a project to have fun learning new things.


## Table of Contents

- [Technology stack](#technology-stack)
- [Getting started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Run](#run)
- [Usage](#usage)


### Technology stack

* [![Java][Java]][Java-url]
* [![Gradle][Gradle]][Gradle-url]
* [![Docker][Docker]][Docker-url]
* [![Kubernetes][Kubernetes]][Kubernetes-url]
* [![Prometheus][Prometheus]][Prometheus-url]
* [![Grafana][Grafana]][Grafana-url]


## Getting started

Follow this steps to run the project locally 


### Prerequisites

The following tools and technologies are required:
- Java 17
- Gradle
- Docker


### Installation

Clone the git project

```shell
git clone https://github.com/scarrionv/micronaut-dummy.git micronaut-dummy
```

### Run

Be sure docker is running in your compute. Use docker compose to run the project


#### Start 

```shell
docker-compose -f dev/docker/docker-compose.yaml up
```

#### Stop 

```shell
docker-compose -f dev/docker/docker-compose.yaml down
```


## Usage

### Micronaut dummy

Is deployed an accessible at:
[http://localhost:8080](http://localhost:8080)


### Prometheus

Is deployed an accessible at:
[http://localhost:9090](http://localhost:9090)


### Grafana

Is deployed an accessible at:
[http://localhost:3000](http://localhost:3000/dashboards)

It will ask you to log in, use the following user information:
```yaml
user: admin
password: grafana
```

<!-- MARKDOWN LINKS & IMAGES -->
[Docker]: https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white
[Docker-url]: https://www.docker.com/
[Gradle]: https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white
[Gradle-url]: https://www.gradle.com/
[Grafana]: https://img.shields.io/badge/grafana-%23F46800.svg?style=for-the-badge&logo=grafana&logoColor=white
[Grafana-url]: https://www.grafana.com/
[Kubernetes]: https://img.shields.io/badge/kubernetes-%23326ce5.svg?style=for-the-badge&logo=kubernetes&logoColor=white
[Kubernetes-url]: https://www.kubernetes.com/
[Prometheus]: https://img.shields.io/badge/Prometheus-E6522C?style=for-the-badge&logo=Prometheus&logoColor=white
[Prometheus-url]: https://www.prometheus.com/
[Java]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/
