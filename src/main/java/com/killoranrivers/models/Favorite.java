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
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "game_id", referencedColumnName = "id")
//    private Game game;
//
//}
