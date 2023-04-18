package com.project.charactersheets.controller;

import com.project.charactersheets.model.Weapon;
import com.project.charactersheets.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weapons")
public class WeaponController {
    @Autowired
    WeaponService weaponService;

    @PostMapping
    public ResponseEntity<Weapon> addWeapon(@RequestBody Weapon weapon) {
        weaponService.addNewWeapon(weapon);
        return ResponseEntity.status(200).body(weapon);
    }

    @GetMapping("/{pcId}")
    public List<Weapon> getAllPcWeapons(@PathVariable int pcId) {
        return weaponService.getCharacterWeapons(pcId);
    }
}
