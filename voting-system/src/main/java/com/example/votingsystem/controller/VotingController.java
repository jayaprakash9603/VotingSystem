package com.example.votingsystem.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.votingsystem.service.VotingService;

@RestController
public class VotingController {

	@Autowired 
	private VotingService votingService;

	@PostMapping("/entercandidate")
	public void enterCandidate(@RequestParam String name) {
		votingService.enterCandidate(name);
	}

	@PostMapping("/castvote")
	public int castVote(@RequestParam String name) {
		return votingService.castVote(name);
	}
	
	@PostMapping("/castvote-authenticate")
	public int castVoteAuthenticated(@RequestParam String name,@RequestParam String username,@RequestParam String userpassword) {
		return votingService.castVote(name,username,userpassword);
	}

	@GetMapping("/countvote")
	public int countVote(@RequestParam String name) {
		return votingService.countVote(name);
	}

	@GetMapping("/listvote")
	public Map<String, Integer> listVotes() {
		return votingService.listVotes();
	}

	@GetMapping("/getwinner")
	public String getWinner() {
		return votingService.getWinner();
	}
}