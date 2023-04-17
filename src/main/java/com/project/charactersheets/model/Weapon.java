package com.project.charactersheets.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int weaponId;
    private int ownerId;
    private String weaponName;
    private int damage;

    private enum damageType {
        STRENGTH, FINESSE, NONE
    };
    private int range;
    private boolean isRangedWeapon;
    private boolean isMagicalWeapon;

    private enum magicEffectType {
        OFFENSE, SUPPORT
    }

    private String effectsDescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return weaponId == weapon.weaponId && ownerId == weapon.ownerId && damage == weapon.damage && range == weapon.range && isRangedWeapon == weapon.isRangedWeapon && isMagicalWeapon == weapon.isMagicalWeapon && Objects.equals(weaponName, weapon.weaponName) && Objects.equals(effectsDescription, weapon.effectsDescription);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
