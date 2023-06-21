package com.project.charactersheets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.charactersheets.model.Weapon;
import com.project.charactersheets.repository.WeaponRepository;

import java.util.List;

@Service
public class WeaponService {
    @Autowired
    WeaponRepository weaponRepo;

    public Weapon addNewWeapon(Weapon newWeapon) {
        return weaponRepo.save(newWeapon);
    }

    public List<Weapon> getCharacterWeapons(Long charId) {
        return weaponRepo.findAllByOwnerId(charId);
    }

    public boolean deleteWeapon(Long weaponId) {
        if (weaponRepo.findById(weaponId).isPresent()) {
            weaponRepo.deleteById(weaponId);
            return true;
        } else {
            return false;
        }
    }
}
