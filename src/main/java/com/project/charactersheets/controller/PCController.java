package com.project.charactersheets.controller;

import com.project.charactersheets.model.PlayerCharacter;
import com.project.charactersheets.service.PCService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pcs")
public class PCController {
    @Autowired
    PCService pcService;

    @PostMapping
    public ResponseEntity<PlayerCharacter> newCharacter(PlayerCharacter playerCharacter) {
        pcService.createNewCharacter(playerCharacter);
        return ResponseEntity.status(200).body(playerCharacter);
    }

    @GetMapping("/{pcId}")
    public Optional<PlayerCharacter> getCharacter(@PathVariable int pcId) {
        Optional<PlayerCharacter> pc = pcService.retrieveCharacter(pcId);
        if (pc.isPresent()) {
            return ResponseEntity.status(200).body(pc).getBody();
        } else {
            return ResponseEntity.status(400).body(pc).getBody();
        }
    }

    @GetMapping("/{playerId}")
    public List<PlayerCharacter> getAllCharactersOfPlayer(@PathVariable int playerId) {
        return pcService.getAllCharactersOfPlayer(playerId);
    }
}
