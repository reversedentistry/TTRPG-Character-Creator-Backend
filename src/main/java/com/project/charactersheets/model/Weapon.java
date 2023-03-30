package com.project.charactersheets.model;

import lombok.Data;

@Data
public class Weapon {
    protected int weaponId;
    protected String weaponName;
    protected int damage;

    protected enum damageType {
        STRENGTH, FINESSE, NONE
    };
    protected int range;
    protected boolean isRangedWeapon;
    protected int ownerId;

}
