package com.azor.ChallengeApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ChallengeService {
    public List<Challenge> challenges = new ArrayList<>();
    public long setID = 1;

    public ChallengeService() {
    }
    public List<Challenge> allChallenges() {
        return challenges;
    }
    public boolean addChallenge(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(setID++);
            challenges.add(challenge);
            return true;
        }
        return false;
    }
    // public Challenge getChallenge(String month) {
    //     for (Challenge challenge : challenges) {
    //         if (challenge.getMonth().equals(month)) {
    //             return challenge;
    //         }
    //     }
    //     return null;
    // }   
    public Challenge getChallenge(String month) {
        for (Challenge challenge : challenges) {
            String challengeMonth = challenge.getMonth();
            // Handle nulls and case sensitivity
            if (challengeMonth != null && challengeMonth.equalsIgnoreCase(month)) {
                return challenge;
            }
        }
        return null;
    }
    boolean updateChallenge(Long id, Challenge updatedChallenge) {
        for (Challenge challenge : challenges) {
            Long Challengeid = challenge.getId();
            if (Challengeid.equals(id) && Challengeid != null){
                challenge.setMonth(updatedChallenge.getMonth());
                challenge.setStatus(updatedChallenge.getStatus());
                challenge.setDescription(updatedChallenge.getDescription());
                return true;
            }
            
        }
        return false;
    }
    public Challenge getChallengebyid(Long id) {
        for (Challenge challenge : challenges) {

            if (challenge.getId().equals(id) && challenge != null) {
                return challenge;
            }
        }
        return null;
    }
    public boolean deleteChallenge(Long id) {
        for (Challenge challenge : challenges) {
            Long Challengeid = challenge.getId();
            if (Challengeid.equals(id) && Challengeid != null) {
                challenges.remove(challenge);
                return true;
            }
        }
        return false;
    }
}
