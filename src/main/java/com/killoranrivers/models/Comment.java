package com.killoranrivers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="comments")
@AllArgsConstructor @NoArgsConstructor
public class Comment implements Serializable {
    public Comment(String text) {
        this.text = text;
    }

    @Id
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comment_sequence"
    )
    private Integer id;

    @Column(length = 10000)
    private String text;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL) // Need optional=false if you use LAZY loading. If I did FetchType.EAGER, it would return an object with the comment I wanted, PLUS all the data for the associated game, which I don't need.
    @JoinColumn(name = "game_id", referencedColumnName = "id") // ReferencedColumnName tells it that game_id is referring to the variable called "id" in the Game model
    private Game game; // This variable is referred to in CommentRepository when I do the custom query, and Comment Service when I create game objects (rows in games table) (?)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
