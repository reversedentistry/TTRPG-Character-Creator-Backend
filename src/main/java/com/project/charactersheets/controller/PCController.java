package com.project.charactersheets.controller;

import com.project.charactersheets.model.PlayerCharacter;
import com.project.charactersheets.service.PCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
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
    public ResponseEntity<PlayerCharacter> getCharacter(@PathVariable Long pcId) {
        Optional<PlayerCharacter> pc = pcService.retrieveCharacter(pcId);
        return pc.map(playerCharacter -> ResponseEntity.status(200).body(playerCharacter)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/players/{playerId}")
    public List<PlayerCharacter> getAllCharactersOfPlayer(@PathVariable Long playerId) {
        return pcService.getAllCharactersOfPlayer(playerId);
    }

    @PutMapping("/{pcId}")
    public ResponseEntity<PlayerCharacter> updateCharacter(@PathVariable Long pcId
            , @RequestBody PlayerCharacter playerCharacter) {
        if (pcService.updateCharacter(pcId, playerCharacter) != null) {
            return ResponseEntity.status(200).body(playerCharacter);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }


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
