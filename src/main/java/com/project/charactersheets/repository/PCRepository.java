package com.project.charactersheets.repository;

import com.project.charactersheets.model.Player;
import com.project.charactersheets.model.PlayerCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PCRepository extends JpaRepository<PlayerCharacter, Long> {
    List<PlayerCharacter> findAllByPlayer(Long player);
}
