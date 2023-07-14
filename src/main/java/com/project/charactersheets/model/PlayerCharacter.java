package com.project.charactersheets.model;

import com.project.charactersheets.enums.CharacterClass;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
public  class PlayerCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pcId;

    @NonNull
    @org.springframework.lang.NonNull
    private String pcName;
    @NonNull
    @org.springframework.lang.NonNull
    private Long player;
    private int level;
    private int hitPoints;
    private int strength;
    private int intelligence;
    private int dexterity;
    private int wisdom;
    private int charisma;
    private int constitution;
    @Enumerated(EnumType.STRING)
    private CharacterClass characterClass;

    @OneToMany(cascade = CascadeType.ALL, fetch =
            FetchType.LAZY)
    @JoinColumn(name = "ownerId", referencedColumnName = "pcId")
    @ToString.Exclude
    private List<Weapon> weapons;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerCharacter that = (PlayerCharacter) o;
        return pcId == that.pcId && level == that.level && hitPoints == that.hitPoints && strength == that.strength && intelligence == that.intelligence && dexterity == that.dexterity && wisdom == that.wisdom && charisma == that.charisma && constitution == that.constitution && pcName.equals(that.pcName) && player.equals(that.player) && characterClass == that.characterClass && Objects.equals(weapons, that.weapons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pcId, pcName, player, level, hitPoints, strength,
                intelligence, dexterity, wisdom, charisma, constitution, characterClass, weapons);
    }
}
