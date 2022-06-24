//package com.killoranrivers.models;
//
//import lombok.*;
//import javax.persistence.*;
//
//@Entity
//@Table(name="favorites")
//@Data @NoArgsConstructor
//public class Favorite {
//    @Id
//    @SequenceGenerator(
//            name = "favorite_sequence",
//            sequenceName = "favorite_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "favorite_sequence"
//    )
//    private Integer id;
//
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "game_id")
//    private Game game;
//
//}
