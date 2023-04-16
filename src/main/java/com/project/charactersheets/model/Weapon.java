package com.project.charactersheets.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Weapon {
    @Id
    protected int weaponId;
    protected int ownerId;
    protected String weaponName;
    protected int damage;

    protected enum damageType {
        STRENGTH, FINESSE, NONE
    };
    protected int range;
    protected boolean isRangedWeapon;
    protected boolean isMagicalWeapon;

    protected enum magicEffectType {
        OFFENSE, SUPPORT
    }

    protected String effectsDescription;

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
