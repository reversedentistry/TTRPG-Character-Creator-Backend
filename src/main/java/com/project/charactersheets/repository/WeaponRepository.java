package com.project.charactersheets.repository;

import com.project.charactersheets.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Long> {
    List<Weapon> findAllByOwnerId(long ownerId);
}
