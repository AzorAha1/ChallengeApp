package com.azor.ChallengeApp;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
   
    private ChallengeService challengeService;
    
    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public List<Challenge> getAllChallenges(){
        return challengeService.allChallenges();
    }
    // add a method to add a challenge
    @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
        boolean challengeadded = challengeService.addChallenge(challenge);
        if (!challengeadded) {
            return ResponseEntity.status(404).body("Challenge not Added"); // Returns HTTP 404
        }
        return ResponseEntity.ok("Challenge Added"); // Returns HTTP 201
    }
    // @GetMapping("/challenges/{month}")
    // public Challenge getChallenge(@PathVariable String month) {
    //     return challengeService.getChallenge(month);
    // }
    // In ChallengeController.java
    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month) {
        Challenge challenge = challengeService.getChallenge(month);
        if (challenge == null) {
            return ResponseEntity.notFound().build(); // Returns HTTP 404
        }
        return ResponseEntity.ok(challenge); // Returns HTTP 200 + Challenge
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge updatedChallenge) {
        boolean isChallengeupdate = challengeService.updateChallenge(id, updatedChallenge);
        if (!isChallengeupdate) {
            return ResponseEntity.status(404).body("Challenge not updated"); // Returns HTTP 404
        }
        return ResponseEntity.ok("Challenge updated"); // Returns HTTP 200
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Challenge> getChallengebyid(@PathVariable Long id) {
        Challenge challenge = challengeService.getChallengebyid(id);
        if (challenge == null) {
            return ResponseEntity.notFound().build(); // Returns HTTP 404
        }
        return ResponseEntity.ok(challenge); // Returns ok
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if (!isChallengeDeleted) {
            return ResponseEntity.status(404).body("Challenge not deleted"); // Returns HTTP 404
        }
        return ResponseEntity.ok("Challenge deleted"); // Returns HTTP 200
    }
}
