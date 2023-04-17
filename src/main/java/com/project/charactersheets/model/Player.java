package com.project.charactersheets.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int playerId;
    private String playerName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "player", referencedColumnName = "playerId")
    private List<PlayerCharacter> characters;
}