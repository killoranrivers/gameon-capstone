package com.killoranrivers.models;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="games")
@AllArgsConstructor @NoArgsConstructor
public class Game implements Serializable {
    public Game(Integer id) {
        this.id = id;
    }

    @Id
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "game", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

//    @OneToMany(mappedBy = "game")
//    private List<Favorite> favorites = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
