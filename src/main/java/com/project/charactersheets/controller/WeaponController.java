package com.project.charactersheets.controller;

import com.project.charactersheets.model.Weapon;
import com.project.charactersheets.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/weapons")
public class WeaponController {
    @Autowired
    WeaponService weaponService;

    @PostMapping
    public Weapon addWeapon(@RequestBody Weapon weapon) {
        weaponService.addNewWeapon(weapon);
        return weapon;
    }

    @GetMapping("/{pcId}")
    public List<Weapon> getAllPcWeapons(@PathVariable Long pcId) {
        return weaponService.getCharacterWeapons(pcId);
    }

    @DeleteMapping("/{weaponId}")
    public ResponseEntity<String> deleteWeapon(Long weaponId) {
        if (weaponService.deleteWeapon(weaponId)) {
            return ResponseEntity.status(HttpStatus.OK).body("Weapon " +
                    "successfully deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An " +
                    "error occurred.");
        }
    }
}
