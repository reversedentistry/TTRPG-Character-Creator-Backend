package com.project.charactersheets.service;

import com.project.charactersheets.model.PlayerCharacter;
import com.project.charactersheets.repository.PCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PCService {
    @Autowired
    PCRepository pcRepository;

    public PlayerCharacter createNewCharacter(PlayerCharacter pc) {
        return pcRepository.save(pc);
    }
}
