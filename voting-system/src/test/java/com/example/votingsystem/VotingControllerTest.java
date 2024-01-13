package com.example.votingsystem;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.votingsystem.controller.VotingController;
import com.example.votingsystem.service.VotingService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = VotingController.class)
class VotingControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private VotingService votingService;

	@InjectMocks
	private VotingController votingController;

	@Test
	void testEnterCandidate() throws Exception {
		mockMvc.perform(post("/entercandidate").param("name", "ajay")).andExpect(status().isOk());
		// You can add additional assertions based on your business logic.
	}

	@Test
    void testCastVoteValidCandidate() throws Exception {
        when(votingService.castVote("ajay")).thenReturn(1);

        mockMvc.perform(post("/castvote").param("name", "ajay"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

	@Test
    void testCastVoteInvalidCandidate() throws Exception {
        when(votingService.castVote("invalidCandidate")).thenReturn(-1);

        mockMvc.perform(post("/castvote").param("name", "invalidCandidate"))
                .andExpect(status().isOk())
                .andExpect(content().string("-1"));
    }

	@Test
    void testCountVote() throws Exception {
        when(votingService.countVote("ajay")).thenReturn(3);

        mockMvc.perform(get("/countvote").param("name", "ajay"))
                .andExpect(status().isOk())
                .andExpect(content().string("3"));
    }

	@Test
    void testListVote() throws Exception {
        when(votingService.listVotes()).thenReturn(Map.of("candidate1", 5, "candidate2", 3));

        ResultActions resultActions = mockMvc.perform(get("/listvote"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.candidate1").value(5))
                .andExpect(jsonPath("$.candidate2").value(3));
    }

	
	
	@Test
    void testGetWinner() throws Exception {
        when(votingService.getWinner()).thenReturn("ajay");

        mockMvc.perform(get("/getwinner"))
                .andExpect(status().isOk())
                .andExpect(content().string("ajay"));
    }
}
