package com.example.votingsystem.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

@RestController
@RequestMapping("/vote")
public class VotingController2 {

	private final Map<String, Integer> candidateVotes = new HashMap<>();

	@PostMapping("/entercandidate")
	public void enterCandidate(@RequestParam String name) {
		candidateVotes.put(name, 0);
		System.out.println("Enter Candidate Controller call :- " + candidateVotes);
	}

	@PostMapping("/castvote")
	public int castVote(@RequestParam String name) {
		if (candidateVotes.containsKey(name)) {
			int currentVotes = candidateVotes.get(name);
			candidateVotes.put(name, currentVotes + 1);
			System.out.println("Cast Vote Controller call :- " + candidateVotes);
			return currentVotes + 1;
		} else {
			// Handle invalid candidate
			return -1;
		}
	}

	@GetMapping("/countvote")
	public int countVote(@RequestParam String name) {
		if (candidateVotes.containsKey(name)) {
			System.out.println("Count Vote Controller call :- " + candidateVotes);
			return candidateVotes.get(name);
		} else {
			// Handle invalid candidate
			return -1;
		}
	}

	@GetMapping("/listvote")
	public Map<String, Integer> listVotes() {
		System.out.println("List Votes Controller call :- " + candidateVotes);
		return candidateVotes;
	}

	@GetMapping("/getwinner")
	public String getWinner() {
		Map.Entry<String, Integer> maxEntry = Collections.max(candidateVotes.entrySet(), Map.Entry.comparingByValue());
		System.out.println("Get Winner Controller call :- " + candidateVotes);
		return maxEntry.getKey();
	}
}