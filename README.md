# HA MICROSERVICE ARCHITECTURE
*A Homework Project for FH-BURGENLAND, WS 2023/24, Sem. 3*

**Short Description**

This project implements a Microservice Architecture focused on storing and retrieving data from sensors. It comprises various components, including a Configuration Service, a Service Directory, an API Gateway with Load Balancing, and a Database Service. This project is using Apache Maven.

**Install and Run**

1. Clone the repository.
2. Navigate to the project root.
3. Run `mvn clean install` for project setup.
4. Start the Services in this order:
    I. ConfigServer 
    II. ServiceRegistry
    III. ApiGateway
    IV. DatabaseService

Utilize SwaggerUI to manage sensors and their measurements. In addition to CRUD operations, retrieve all measurements from a sensor.
Find API documentation under: ./openapi/*


**List of Modules**

- ConfigServer
- DatabaseService
- ServiceRegistry
- ApiGateway


**How to Contribute**

Our project is limited to a closed group of contributors. Only members within the group have access to the repository. If you are a member of the closed group, you can submit pull requests for proposed changes. Ensure that the changes align with the project goals and have been discussed within the group. PR to the main branch has to be approved from an other group member. Forks of the repository outside the closed group are not allowed. All development and contributions should happen within the group's private repository.

**Credits**
* Lind Weidhofer
* Viktoria Vass
