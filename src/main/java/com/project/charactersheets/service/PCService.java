package com.project.charactersheets.service;

import com.project.charactersheets.model.PlayerCharacter;
import com.project.charactersheets.repository.PCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PCService {
    @Autowired
    PCRepository pcRepository;

    public PlayerCharacter createNewCharacter(PlayerCharacter pc) {
        return pcRepository.save(pc);
    }

    public boolean deleteCharacter(Long pcId) {
        Optional<PlayerCharacter> pcTbd = pcRepository.findById(pcId);
        if (pcTbd.isPresent()) {
            pcRepository.deleteById(pcId);
            return true;
        } else {
            return false;
        }
    }

    public Optional<PlayerCharacter> retrieveCharacter(Long pcId) {
        return pcRepository.findById(pcId);
    }

    public List<PlayerCharacter> getAllCharactersOfPlayer(Long playerId) {
        return pcRepository.findAllByPlayer(playerId);
    }
}
