package com.killoranrivers.models;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="games")
@AllArgsConstructor @NoArgsConstructor
public class Game implements Serializable {
    public Game(Integer id) {
        this.id = id;
    }

    public Game(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    @Id
    private Integer id;

    @Column
    private String title;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "game", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "game", cascade = CascadeType.ALL)
//    private List<Favorite> favorites = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
