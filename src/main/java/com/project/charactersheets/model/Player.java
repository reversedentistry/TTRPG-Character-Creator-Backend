package com.project.charactersheets.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Player {
    @Id
    private int playerId;
    private String playerName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PlayerCharacter> characters;
}