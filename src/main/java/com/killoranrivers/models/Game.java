package com.killoranrivers.models;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="games")
@Data @NoArgsConstructor
public class Game {
    @Id
    @SequenceGenerator(
            name = "game_sequence",
            sequenceName = "game_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "game_sequence"
    )
    private Long id;
    private String title;

    @OneToMany(mappedBy = "games")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "games")
    private List<Favorite> favorites = new ArrayList<>();
}
