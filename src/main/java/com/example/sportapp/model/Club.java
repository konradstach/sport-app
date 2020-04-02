package com.example.sportapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clubs")
@Data
@NoArgsConstructor
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "club_id", nullable = false, updatable = false)
    private long id;

    private String name;

    private String clubNationality;

    private String city;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "clubsPlayedIn")
    private Set<Footballer> footballersPlayedIn;
}
