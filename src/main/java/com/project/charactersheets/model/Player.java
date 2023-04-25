package com.project.charactersheets.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

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

    @NonNull
    @Column(unique = true)
    @org.springframework.lang.NonNull
    private String username;

    @NonNull
    @org.springframework.lang.NonNull
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "player", referencedColumnName = "playerId")
    @ToString.Exclude
    private List<PlayerCharacter> characters;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerId.equals(player.playerId) && playerName.equals(player.playerName) && Objects.equals(characters, player.characters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, playerName, characters);
    }
}