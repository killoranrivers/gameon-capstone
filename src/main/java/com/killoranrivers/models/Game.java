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
    private Long id;

    @Column
    private String title;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "games", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

//    @OneToMany(mappedBy = "games")
//    private List<Favorite> favorites = new ArrayList<>();
}
