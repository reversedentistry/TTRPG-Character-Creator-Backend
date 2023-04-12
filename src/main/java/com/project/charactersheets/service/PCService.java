package com.project.charactersheets.service;

import com.project.charactersheets.model.PlayerCharacter;
import com.project.charactersheets.repository.PCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PCService {
    @Autowired
    PCRepository pcRepository;

    public PlayerCharacter createNewCharacter(PlayerCharacter pc) {
        return pcRepository.save(pc);
    }

    public Optional<PlayerCharacter> retrieveCharacter(int pcId) {
        Optional<PlayerCharacter> pc = pcRepository.findById(pcId);
        return pc;
    }
}