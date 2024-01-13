# Voter Service Architecture and Design Documentation

## Table of Contents

## Table of Contents

1. [Introduction](#introduction)
2. [Architecture Overview](#architecture-overview)
3. [Components](#components)
   1. [Voter Controller](#1-voter-controller)
   2. [Candidate Service](#2-candidate-service)
   3. [Vote Service](#3-vote-service)
4. [Database Schema](#database-schema)
5. [Sequence Diagrams](#sequence-diagrams)
   1. [Enter Candidate](#1-enter-candidate-sequence-diagram)
   2. [Cast Vote](#2-cast-vote-sequence-diagram)
   3. [Count Vote](#3-count-vote-sequence-diagram)
   4. [List Votes](#4-list-votes-sequence-diagram)
   5. [Get Winner](#5-get-winner-sequence-diagram)
6. [Testing](#testing)
7. [Deployment](#deployment)
   1. [Prerequisites](#i-prerequisites)
   2. [Clone the Repository](#ii-clone-the-repository)
8. [Conclusion](#conclusion)

## Introduction

This document provides an overview of the architecture and design of the Voter service. The service is designed to manage candidate information, allow users to cast votes, and provide insights into voting results.

## Architecture Overview

The Voter service follows a microservices architecture, with separate components handling candidate-related operations, vote processing, and result retrieval.

## Components

### 1. Voter-Controller

- Responsible for handling HTTP requests and routing them to the appropriate services.
- Implements the API endpoints for entering candidates, casting votes, counting votes, listing votes, and retrieving the winner.

### 2. Candidate Service

- Manages candidate information, including storing candidate names and their respective vote counts.
- Exposes APIs for entering candidates and retrieving the list of candidates.

### 3. Vote Service

- Handles the logic for casting votes, counting votes, and determining the winner.
- Ensures data consistency and integrity during the voting process.

## Database Schema

- Utilizes a simple schema with tables for candidates and votes.
- Candidate Table:
  - Columns: `candidate_id` (Primary Key), `name`, `vote_count`.
- Vote Table:
  - Columns: `vote_id` (Primary Key), `candidate_id` (Foreign Key), `voter_id`, `timestamp`.

...

## 5. Sequence Diagrams

### 1. Enter Candidate Sequence Diagram

![Enter Candidate Sequence Diagram](images/candidate%20sequence%20diagram.png)

### 2. Cast Vote Sequence Diagram

![Cast Vote Sequence Diagram](images/cast%20vote%20diagram.png)

### 3. Count Vote Sequence Diagram

![Count Vote Sequence Diagram](images/count%20vote%20diagram.png)

### 4. List Votes Sequence Diagram

![List Votes Sequence Diagram](images/list%20votes%20diagram.png)

### 5. Get Winner Sequence Diagram

![Get Winner Sequence Diagram](images/winner%20diagram.png)
...

Note that these sequence diagrams are simplified representations intended to illustrate key interactions within each component. Act

# 6. Testing

## Overview

The `VotingControllerTest` class is designed to test the functionalities of the `VotingController` class in the Voting System project. The tests utilize the Spring WebMvcTest annotation for testing the controller layer in isolation.

## Test Methods

### 1. testEnterCandidate

**Objective:** Verify that the enterCandidate endpoint successfully adds a candidate to the system.

**Test Steps:**

1. Perform a POST request to "/entercandidate" with the candidate name parameter set to "ajay".
2. Expect an HTTP OK status (200).

### 2. testCastVoteValidCandidate

**Objective:** Confirm that the castVote endpoint correctly registers a vote for a valid candidate.

**Test Steps:**

1. Mock the `votingService.castVote` method to return 1 when called with the name "ajay".
2. Perform a POST request to "/castvote" with the candidate name parameter set to "ajay".
3. Expect an HTTP OK status (200) and response content "1".

### 3. testCastVoteInvalidCandidate

**Objective:** Validate that the castVote endpoint handles invalid candidates and returns the expected result.

**Test Steps:**

1. Mock the `votingService.castVote` method to return -1 when called with the name "invalidCandidate".
2. Perform a POST request to "/castvote" with the candidate name parameter set to "invalidCandidate".
3. Expect an HTTP OK status (200) and response content "-1".

### 4. testCountVote

**Objective:** Ensure that the countVote endpoint retrieves the correct vote count for a specific candidate.

**Test Steps:**

1. Mock the `votingService.countVote` method to return 3 when called with the name "ajay".
2. Perform a GET request to "/countvote" with the candidate name parameter set to "ajay".
3. Expect an HTTP OK status (200) and response content "3".

### 5. testListVote

**Objective:** Validate that the listVotes endpoint returns the expected JSON response for a list of candidates and their vote counts.

**Test Steps:**

1. Mock the `votingService.listVotes` method to return a map with candidate names and respective vote counts.
2. Perform a GET request to "/listvote".
3. Expect an HTTP OK status (200) and JSON response with the correct candidate names and vote counts.

### 6. testGetWinner

**Objective:** Confirm that the getWinner endpoint returns the correct winner.

**Test Steps:**

1. Mock the `votingService.getWinner` method to return "ajay".
2. Perform a GET request to "/getwinner".
3. Expect an HTTP OK status (200) and response content "ajay".

## Conclusion

The unit tests for the VotingController have been designed to ensure the correct behavior of the various endpoints in the Voting System project. These tests cover scenarios such as candidate entry, vote casting, vote counting, and winner determination.

## 7. Deployment

## i. Prerequisites

Before deploying the Voter service, make sure you have the following prerequisites installed:

- Java Development Kit (JDK)
- Git

## ii. Clone the Repository

```bash
git clone --depth 1 --branch master https://github.com/jayaprakash9603/VotingSystem.git
cd voter-service

```

Example API usage

`http://localhost:8080/entercandidate?name=ajay`

`http://localhost:8080/castvote?name=ajay`

`http://localhost:8080/countvote?name=ajay`

`http://localhost:8080/listvote`

`http://localhost:8080/getwinner`
