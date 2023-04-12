package com.project.charactersheets.model;

import lombok.Data;

@Data
public class Weapon {
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

    protected enum effectType {
        OFFENSE, SUPPORT
    }

    protected String effectsDescription;


}
