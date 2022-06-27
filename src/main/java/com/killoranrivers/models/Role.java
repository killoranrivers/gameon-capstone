package com.killoranrivers.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor
public class Role {
    public Role(String name) {
        this.name = name;
    }

    @Id
    @SequenceGenerator(name = "role_sequence", sequenceName = "role_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sequence")
    Integer id;

    private String name;


}
