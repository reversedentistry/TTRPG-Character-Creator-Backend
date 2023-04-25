package com.project.charactersheets.service;

import com.project.charactersheets.model.Player;
import com.project.charactersheets.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepo;

    public Player createNewPlayer(Player player) {
        return playerRepo.save(player);
    }

    //TODO: Login
    public boolean login(Player player) {
        Player loginAttempt = playerRepo.findByUsername(player.getUsername());
        if (loginAttempt != null) {
            String passwordAttempt = player.getPassword();
            return passwordAttempt.equals(loginAttempt.getPassword());
        } else {
            return false;
        }
    }
}
