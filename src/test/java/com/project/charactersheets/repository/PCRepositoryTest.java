package com.project.charactersheets.repository;

import com.project.charactersheets.enums.CharacterClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.charactersheets.model.Player;
import com.project.charactersheets.model.PlayerCharacter;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class PCRepositoryTest {
    @Autowired
    private PCRepository pcRepo;
    @Autowired
    private PlayerRepository playerRepo;
    List<PlayerCharacter> pcs = new ArrayList<PlayerCharacter>();

    long player;

    @BeforeEach
    void setUp() {
        Player player1 = new Player("player1", "player1", "testpw");
        PlayerCharacter pc1 = new PlayerCharacter(1L, "PCOne", 1L, 3, 25, 10,
                10,
                10, 10, 10, 10, CharacterClass.FIGHTER, null);
        PlayerCharacter pc2 = new PlayerCharacter(2L, "PCTwo", 1L, 3, 25, 10,
                10,
                10, 10, 10, 10, CharacterClass.WIZARD, null);
        PlayerCharacter pc3 = new PlayerCharacter(3L, "PCThree", 2L, 3, 25, 10,
                10,
                10, 10, 10, 10, CharacterClass.WIZARD, null);

        pcs.add(pc1);
        pcs.add(pc2);


        playerRepo.save(player1);
        pcRepo.save(pc1);
        pcRepo.save(pc2);
        pcRepo.save(pc3);

        player = pc1.getPlayer();
    }

    @AfterEach
    void tearDown() {
        pcRepo.deleteAll();
        pcs.clear();
    }

    @Test
    void checkToFindAllCharactersByPlayer() {
        List<PlayerCharacter> expected = pcRepo.findAllByPlayer(player);
        assertThat(expected).isEqualTo(pcs);
    }
}