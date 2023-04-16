package com.project.charactersheets.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public  class PlayerCharacter {
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

    @OneToMany(cascade = CascadeType.ALL, fetch =
            FetchType.EAGER)
    @JoinColumn(name = "ownerId", referencedColumnName = "pcId")
    @ToString.Exclude
    private List<Weapon> weapons;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerCharacter that = (PlayerCharacter) o;
        return pcId == that.pcId && level == that.level && hitPoints == that.hitPoints && strength == that.strength && intelligence == that.intelligence && dexterity == that.dexterity && wisdom == that.wisdom && charisma == that.charisma && constitution == that.constitution && Objects.equals(pcName, that.pcName) && Objects.equals(weapons, that.weapons);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
