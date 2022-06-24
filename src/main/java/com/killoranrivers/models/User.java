//package com.killoranrivers.models;
//
//import lombok.*;
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name="users")
//@Data @NoArgsConstructor
//public class User {
//    @Id
//    @SequenceGenerator(
//            name = "user_sequence",
//            sequenceName = "user_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "user_sequence"
//    )
//    private Long id;
//    private String username;
//    private String email;
//    private String password;
//
//    @OneToMany(mappedBy = "user")
//    private List<Comment> comments = new ArrayList<>();
//
//    @OneToMany(mappedBy = "user")
//    private List<Favorite> favorites = new ArrayList<>();
//
//}
