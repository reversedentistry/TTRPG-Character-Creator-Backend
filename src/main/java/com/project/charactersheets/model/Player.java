package com.project.charactersheets.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long playerId;
    @NonNull
    @Column(unique = true)
    @org.springframework.lang.NonNull
    private String playerName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "player", referencedColumnName = "playerId")
    @ToString.Exclude
    private List<PlayerCharacter> characters;
}