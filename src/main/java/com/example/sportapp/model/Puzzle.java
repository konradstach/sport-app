package com.example.sportapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "puzzles")
public class Puzzle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "puzzle_id", nullable = false, updatable = false)
    private long id;

    @ManyToMany
    @JoinTable(name = "puzzles_footballers", joinColumns = @JoinColumn(name = "puzzle_id"), inverseJoinColumns = @JoinColumn(name = "footballer_id"))
    private Set<Footballer> footballers;

    @ManyToOne()
//    @Column(name = "mutual_club_id")
    private Club mutualClub;

    private double difficulty;

    private int timesUsed;

    private int timesSolved;
}
