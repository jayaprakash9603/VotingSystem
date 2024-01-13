package com.example.votingsystem.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.votingsystem.model.Candidate;
import com.example.votingsystem.model.User;

@Service
public class VotingService {
	
	private List<User> lstUsers = new ArrayList<>();

	public VotingService() {
        initializeUsers();
	}
	
	private void initializeUsers() {
        lstUsers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            lstUsers.add(new User("user" + i, "password" + i));
        }
    }
	
    private Map<String, Candidate> candidateMap = new HashMap<>();

    public void enterCandidate(String name) {
        Candidate candidate = new Candidate(name);
        candidateMap.put(name, candidate);
    }

    public int castVote(String candidateName, String username, String userPassword) {
        // Validate user credentials
        if (!isValidUser(username, userPassword)) {
            return -2; // Invalid user
        }

        Candidate candidate = candidateMap.get(candidateName);
        if (candidate != null) {
            candidate.incrementVoteCount();
            return candidate.getVoteCount();
        }
        return -1; // Invalid candidate
    }
    
    public int castVote(String candidateName) {
       
        Candidate candidate = candidateMap.get(candidateName);
        if (candidate != null) {
            candidate.incrementVoteCount();
            return candidate.getVoteCount();
        }
        return -1; // Invalid candidate
    }
    
    private boolean isValidUser(String username, String password) {
        for (User user : lstUsers) {
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public int countVote(String name) {
        Candidate candidate = candidateMap.get(name);
        return (candidate != null) ? candidate.getVoteCount() : -1; // Invalid candidate
    }

    public Map<String, Integer> listVotes() {
        Map<String, Integer> result = new HashMap<>();
        for (Candidate candidate : candidateMap.values()) {
            result.put(candidate.getName(), candidate.getVoteCount());
        }
        return result;
    }

    public String getWinner() {
        Candidate winner = candidateMap.values().stream()
                .max((c1, c2) -> Integer.compare(c1.getVoteCount(), c2.getVoteCount()))
                .orElse(null);

        return (winner != null) ? winner.getName() : null;
    }
}
