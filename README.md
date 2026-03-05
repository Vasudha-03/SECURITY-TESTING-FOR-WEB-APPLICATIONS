# SECURITY-TESTING-FOR-WEB-APPLICATIONS
# COMPANY: CODETECH IT SOLUTIONS 
# NAME: VASUDHA M R 
# INTERN ID: CTIS4793 
# DOMAIN: SOFTWARE TESTING 
# DURATION: 4 WEEKS MENTOR: NEELA SANTOSH

#Task 3: Secutiy testing for web application

1. Objective of the Task

The main objective of Task 3 was to perform security testing on a web application.

The goal was to identify common security vulnerabilities such as:

SQL Injection

Cross-Site Scripting (XSS)

Improper input validation

Security testing helps in protecting sensitive data and ensuring that the application is safe from malicious attacks.

2. Application Used for Testing

The testing was conducted on a Hospital Appointment and Medical Record Management System.

This web application allows management of:

Doctors

Patients

Departments

Appointments

The application exposes REST APIs to perform operations such as:

Creating records

Updating records

Retrieving data

Managing relationships between entities.

3. Technologies and Tools Used

The following technologies and tools were used while performing the task:

Development Technologies

Java

Spring Boot Framework

Spring Data JPA

Hibernate

MySQL Database

Testing Tools

Postman – used to send HTTP requests and test APIs

Web Browser – used to verify responses

JSON format – used for sending request data

These tools helped in simulating user inputs and testing API behavior.

4. Platform Used

The project was developed and tested on a local development environment.

The backend application was executed using Spring Boot.

The server ran on localhost:8080.

APIs were tested through Postman by sending HTTP requests such as:

GET

POST

PUT

DELETE

5. Testing Process

The following steps were followed during the testing process:

Started the Spring Boot application.

Opened Postman to test REST APIs.

Sent requests to different endpoints such as:

Retrieving doctor details

Retrieving patient details using user ID

Updating records.

Modified input values to check how the application handles unexpected or malicious inputs.

Observed the responses returned by the server.

This helped in determining whether the application had proper security validations.

6. SQL Injection Testing

SQL Injection is a vulnerability where attackers try to manipulate database queries.

During testing, special inputs were entered such as:

' OR '1'='1

This type of input is commonly used by attackers to bypass authentication systems.

Observation

The system accepted the input without rejecting it.

This indicates that strong input validation is not implemented.

7. Authentication Testing

The application uses Spring Security for basic authentication.

Unauthorized API access was attempted to check if the system blocks unauthorized users.

Observation

Some endpoints returned:

HTTP 401 Unauthorized

This indicates that basic authentication protection exists.

8. Data Relationship Testing

The relationships between entities such as:

User

Patient

Doctor

were also tested.

For example:

Retrieving patient information using user ID.

Observation

The API returned the correct patient data.

However, in some responses user details were returned as null.

This indicates that entity mapping or response structure may require improvement.

9. Tasks Completed

The following tasks were successfully completed:

Developed and executed the Spring Boot web application.

Tested REST APIs using Postman.

Performed SQL Injection testing.

Checked authentication behavior using Spring Security.

Verified entity relationships between User, Doctor, and Patient.

Observed system responses for malicious input values.

10. Tasks Not Fully Completed

Some advanced security testing activities were not fully implemented:

Cross-Site Scripting (XSS) testing

Automated vulnerability scanning

Penetration testing using professional security tools

Implementation of advanced input validation

These tasks can be performed in the future to strengthen application security.

11. Working of the System

The application receives HTTP requests through REST APIs. The request is processed by Spring Boot controllers.

The controller interacts with:

Service layer

DAO layer

Repository layer.

Data is retrieved or stored in the MySQL database.

The server then returns a JSON response containing the requested information.

12. Conclusion

Security testing helped in understanding how vulnerabilities can exist in web applications.

Testing revealed that the application needs stronger input validation mechanisms.

Implementing validation techniques and security best practices will help in preventing attacks such as SQL Injection and XSS.

This task provided practical experience in API testing and web application security analysis.
