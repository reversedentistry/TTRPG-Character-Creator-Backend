package com.project.charactersheets.controller;

import com.project.charactersheets.model.PlayerCharacter;
import com.project.charactersheets.service.PCService;
import lombok.Getter;
import org.apache.coyote.Response;
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
    public ResponseEntity<PlayerCharacter> newCharacter(@RequestBody PlayerCharacter playerCharacter) {
        pcService.createNewCharacter(playerCharacter);
        return ResponseEntity.status(200).body(playerCharacter);
    }

    @GetMapping("/{pcId}")
    public Optional<PlayerCharacter> getCharacter(@PathVariable Long pcId) {
        Optional<PlayerCharacter> pc = pcService.retrieveCharacter(pcId);
        if (pc.isPresent()) {
            return ResponseEntity.status(200).body(pc).getBody();
        } else {
            return ResponseEntity.status(400).body(pc).getBody();
        }
    }

    @GetMapping("/players/{playerId}")
    public List<PlayerCharacter> getAllCharactersOfPlayer(@PathVariable Long playerId) {
        return pcService.getAllCharactersOfPlayer(playerId);
    }

    @DeleteMapping("/{pcId}")
    public ResponseEntity<String> deleteCharacter(@PathVariable long pcId) {
        if (pcService.deleteCharacter(pcId)) {
            return ResponseEntity.status(200).body("Player character " +
                    "successfully deleted.");
        } else {
            return ResponseEntity.status(400).body("This player character " +
                    "does not exist!");
        }
    }
}
