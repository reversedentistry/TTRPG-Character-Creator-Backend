package com.project.charactersheets.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long weaponId;

    @NonNull
    @org.springframework.lang.NonNull
    private Long ownerId;
    @NonNull
    @org.springframework.lang.NonNull
    private String weaponName;
    private int damage;

    private enum damageType {
        STRENGTH, FINESSE, NONE
    };
    private int range;
    private boolean isRanged;
    private boolean isMagical;

    private enum magicEffectType {
        OFFENSE, SUPPORT
    }

    private String effectsDescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return weaponId == weapon.weaponId && ownerId == weapon.ownerId && damage == weapon.damage && range == weapon.range && isRanged == weapon.isRanged && isMagical == weapon.isMagical && Objects.equals(weaponName, weapon.weaponName) && Objects.equals(effectsDescription, weapon.effectsDescription);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
