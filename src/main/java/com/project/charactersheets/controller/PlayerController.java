package com.project.charactersheets.controller;

import com.project.charactersheets.model.Player;
import com.project.charactersheets.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player newPlayer = playerService.createNewPlayer(player);
        return ResponseEntity.status(200).body(newPlayer);
    }
}
