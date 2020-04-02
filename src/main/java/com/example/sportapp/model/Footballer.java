package com.example.sportapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "footballers")
@Data
@NoArgsConstructor
public class Footballer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "footballer_id", nullable = false, updatable = false)
    private long id;

    private String firstName;

    private String lastName;

    private String nationality;

    // private photo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "footballers_clubs", joinColumns = @JoinColumn(name = "footballer_id"), inverseJoinColumns = @JoinColumn(name = "club_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Club> clubsPlayedIn;
}
