package com.project.charactersheets.model;

import com.project.charactersheets.enums.DamageType;
import com.project.charactersheets.enums.MagicEffectType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long weaponId;

    @NonNull
    @org.springframework.lang.NonNull
    private Long ownerId;
    @NonNull
    @org.springframework.lang.NonNull
    private String weaponName;
    private int damage;

    @Enumerated(EnumType.STRING)
    private DamageType damageType;
    private int range;
    private boolean isRanged;
    private boolean isMagical;

    @Enumerated(EnumType.STRING)
    private MagicEffectType magicEffectType;

    private String effectsDescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return damage == weapon.damage && range == weapon.range && isRanged == weapon.isRanged && isMagical == weapon.isMagical && weaponId.equals(weapon.weaponId) && ownerId.equals(weapon.ownerId) && weaponName.equals(weapon.weaponName) && damageType == weapon.damageType && magicEffectType == weapon.magicEffectType && Objects.equals(effectsDescription, weapon.effectsDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weaponId, ownerId, weaponName, damage, damageType
                , range, isRanged, isMagical, magicEffectType, effectsDescription);
    }
}
