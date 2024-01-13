Introduction

The Voter service is a Spring Boot RESTful Web Service designed for testing. 
It provides several HTTP API endpoints for managing votes, including
reviewing a static list of votes, casting a vote, and viewing voting results.

Quick Start for Local Development
To run the Voter service locally, follow these steps:

git clone --depth 1 --branch master \
  https://github.com/jayaprakash9603/VotingSystem.git
cd voter-service
./gradlew clean cleanTest build
java -jar build/libs/voter-service-0.2.0.jar

The service runs on port 8080.

Getting Started with the API
To interact with the Voter service API, you can use Postman based on the
HTTP method type. The API has the following endpoints:


1.Enter Candidate

Method: POST
Endpoint: /entercandidate
Description: Takes a candidate name as a parameter and saves it into a table with 
an initialized vote count of 0. Uses local variables instead of a database.
Cast Vote

2.Method: POST
Endpoint: /castvote
Description: Takes a candidate name as a parameter, increments the vote count, 
and returns the updated count. Votes are entered only for valid candidates.
Count Vote

3.Method: POST
Endpoint: /countvote
Description: Takes a candidate name as a parameter and returns the latest vote count. 
Validates the candidate name.
List Vote

4.Method: GET
Endpoint: /listvote
Description: Returns all candidate names and their respective vote counts in JSON format.
Get Winner

5.Method: GET
Endpoint: /getwinner
Description: Returns the name of the candidate with the largest number of votes.

Example API usage :

http://localhost:8080/entercandidate?name=ajay

http://localhost:8080/castvote?name=ajay

http://localhost:8080/countvote?name=ajay

http://localhost:8080/listvote

http://localhost:8080/getwinner


Service Endpoints

By default, the service runs on localhost, port 8080. 
The table below summarizes the endpoints:
--------------------------------------------------
| Purpose         | Method | Endpoint            |
| --------------- | -----  | ------------------- |
| Enter Candidate | POST   | /entercandidate     |
| Cast Vote       | POST   | /castvote           |
| Count Vote      | POST   | /countvote          |
| List Vote       | GET    | /listvote           |
| Get Winner      | GET    | /getwinner          |
--------------------------------------------------