# Challenge APIs
## _The backend development task_

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

## Features

- APIs security with **Basic** authentication
- Login API with _username/password_
- Import new employees with the given hierarchy
- Get the name of supervisor and the name of the supervisor’s supervisor by the given employee name

## Tech
Challenge users a number of open source projects to work properly:

- [Springboot] - Open source Java-based framework
- [Maven] - A software project management and comprehension tool
- [PostgreSQL] - Open source relational database management system
- [Docker] - Open source containerization platform
- [Docker-compose] - A tool for defining and running multi-container Docker applications

## Installation

Challenge requires [Java](https://www.java.com/) v11+, [Maven] v3.5+, and [Docker-compose] to run.

Install the dependencies and start the server on your local machine.

```sh
cd challenge
docker-compose up -d challenge_postgresdb
mvn clean install
mvn spring-boot:run
```

For using [Docker] and [Docker-compose] only:

```sh
docker-compose up --build -d
```

Verify the deployment by navigating to your server address in
your preferred browser.

```sh
127.0.0.1:8080
```

## Running the tests:

Run and verify unit tests:
```sh
mvn test
```

Run and double-check coding convention:
```sh
## The result locates at `target/checkstyle-result.xml` 
mvn clean site
```

APIs Test by using _curl_:

1. Authentication with provided username/password:
    - API description: handle login logic and return a basic token.
        ```sh
        POST /login HTTP/1.1
        HOST: localhost:8080
        Content-Type: application/json
        Body: {
            "username": string,
            "password": string,
        }
        ```
    - Available accounts: **admin/admin, user/user**
    - Example:
        ```sh
        curl --header "Content-Type: application/json"\
            --request POST\
            --data '{"username": "admin", "password": "admin"}' \
            http://localhost:8080/login
        
        ## Response 200:
        {
           "token": "YWRtaW46YWRtaW4=",
           "type": "Basic"
        }
        ```

## Deployment

Challenge requires [Docker] and [Docker-compose] for production environment

For the first deployment, run the following command:
```sh
docker-compose up --build -d
```
To stop the running Challenge application:
```sh
docker-compose stop challenge_api
```
To rebuild & redeploy the challenge application:
```sh
docker-compose up -d --no-deps --build challenge_api
```

## Author

* **Sang Huynh** - *thanhsangqn3@gmail.com* - [sanght](https://github.com/huynhsang)

## License

MIT

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job)

   [Springboot]: <https://spring.io/projects/spring-boot>
   [Maven]: <https://maven.apache.org/>
   [PostgreSQL]: <https://www.postgresql.com/>
   [Docker]: <https://www.docker.com/>
   [Docker-compose]: <https://docs.docker.com/compose/>
