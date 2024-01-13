## Introduction

The Voter [Spring Boot](https://projects.spring.io/spring-boot/) RESTful Web Service is used for Springboot testing. The Voter service exposes several HTTP API endpoints, listed below. API users can review a static list votes , cast a vote, view voting results.

## Quick Start for Local Development

The Voter service can runs locally, on port `8080`. To clone, build, test, and run the Voter service locally:

```bash
git clone --depth 1 --branch master \
  https://github.com/jayaprakash9603/VotingSystem.git
```

## Getting Started with the API

The easiest way to get started with the Voter service API is to test the api's in the postman based on the HTTP method type.

The API entercandidate shall take a name as a parameter and save that into a table with a a count(vote count) initialized to 0.

Use local variables instead of a database to store the data.

The API castvote shall take a name as a parameter and increment the vote count and return it. It should enter vote only for a valid candidate.

The API countvote shall take a name as a parameter and should return the latest vote count. Validate candidate name.

The API listvote should return all names and votecounts. The return value is in JSON.

The API getwinner should return the name of the candidate who got the largest number of votes.

APIs shall be simultaneously executed by multi-users.

Implement unit testing

Example API usage

`http://localhost:8080/entercandidate?name=ajay`

`http://localhost:8080/castvote?name=ajay`

`http://localhost:8080/countvote?name=ajay`

`http://localhost:8080/listvote`

`http://localhost:8080/getwinner`

## Service Endpoints

By default, the service runs on `localhost`, port `8080`.

| Purpose         | Method | Endpoint                                                          |
| --------------- | :----- | :---------------------------------------------------------------- |
| Enter Candidate | POST   | [/entercandidate](http://localhost:8080/entercandidate?name=ajay) |
| Cast Vote       | POST   | [/castvote](http://localhost:8080/castvote?name=ajay)             |
| Count Vote      | POST   | [/countvote](http://localhost:8080/countvote?name=ajay)           |
| List Vote       | GET    | [/listvote](http://localhost:8080/listvote)                       |
| Get Winner      | GET    | [/getwinner](http://localhost:8080/listvote)                      |

## Voting

Submitting a new vote, requires an HTTP `POST` request to the `/votes` endpoint, and pass the candidate name as follows:

```text
http POST http://localhost:8080/castvote?name=ajay
```

## Sample Output

`http http://localhost:8080/entercandidate`

```json
{
  "message": "candidate added"
}
```

`http http://localhost:8080/castvote`

```json
{
  "candidates": [
    "Chris Keniston",
    "Darrell Castle",
    "Donald Trump",
    "Gary Johnson",
    "Hillary Clinton",
    "Jill Stein"
  ]
}
```

`http http://localhost:8080/countvote`

```json
{
  "results": [
    {
      "candidate": "Gary Johnson",
      "votes": 20
    },
    {
      "candidate": "Hillary Clinton",
      "votes": 15
    },
    {
      "candidate": "Donald Trump",
      "votes": 11
    },
    {
      "candidate": "Jill Stein",
      "votes": 8
    },
    {
      "candidate": "Chris Keniston",
      "votes": 3
    },
    {
      "candidate": "Darrell Castle",
      "votes": 2
    }
  ]
}
```

`http http://localhost:8080/listvote`

```json
{
  "kiran": 14,
  "ajay": 20,
  "sunil": 22,
  "kishore": 34,
  "kamal": 69
}
```

`http http://localhost:8080/getwinner`

```json
{
  "results": [
    {
      "candidate": "Gary Johnson",
      "votes": 20
    }
  ]
}
```

## References

- [Spring Data - Reference Documentation](http://docs.spring.io/spring-data/mongodb/docs/current/reference/html/)
- [Spring Boot Testing](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-testing)
- [Installing Spring Boot applications](https://docs.spring.io/spring-boot/docs/current/reference/html/deployment-install.html#deployment-install)
- [Externalized Configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html)
