package com.project.charactersheets.controller;

import com.project.charactersheets.model.PlayerCharacter;
import com.project.charactersheets.service.PCService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Optional<PlayerCharacter> getCharacter(int pcId) {
        Optional<PlayerCharacter> pc = pcService.retrieveCharacter(pcId);
        if (pc.isPresent()) {
            return ResponseEntity.status(200).body(pc).getBody();
        } else {
            return ResponseEntity.status(400).body(pc).getBody();
        }
    }
}
