package com.project.charactersheets.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
public @Data class PlayerCharacter {
    @Id
    private int pcId;
    private String pcName;
    private int level;
    private int hitPoints;
    private int strength;
    private int intelligence;
    private int dexterity;
    private int wisdom;
    private int charisma;
    private int constitution;
    private enum characterClass {
        WIZARD, FIGHTER, BARBARIAN, RANGER, CLERIC, BARD, PALADIN, DRUID,
        ROGUE, SORCERER, MONK, WARLOCK
    }

    @OneToMany
    private List<Weapon> weapons;
}
