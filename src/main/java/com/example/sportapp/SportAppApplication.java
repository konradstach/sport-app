package com.example.sportapp;

import com.example.sportapp.model.Club;
import com.example.sportapp.model.Footballer;
import com.example.sportapp.model.Puzzle;
import com.example.sportapp.model.User;
import com.example.sportapp.repository.ClubRepository;
import com.example.sportapp.repository.FootballerRepository;
import com.example.sportapp.repository.PuzzleRepository;
import com.example.sportapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
// disables oauth
//@EnableResourceServer
public class SportAppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SportAppApplication.class, args);
    }

    @Autowired
    FootballerRepository footballerRepository;

    @Autowired
    PuzzleRepository puzzleRepository;

    @Autowired
    ClubRepository clubRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User();
        u1.setUsername("peter@example.com");
        u1.setPassword("$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri");
        u1.setEnabled(true);
        u1.setScore(0.0);
        userRepository.save(u1);

        User u2 = new User();
        u2.setUsername("john@example.com");
        u2.setPassword("$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri");
        u2.setEnabled(true);
        u2.setScore(0.0);
        userRepository.save(u2);

        Club c1 = new Club();
        c1.setName("Real Madrid");
        c1.setCity("Madrid");
        c1.setClubNationality("Spain");

        Footballer f1 = new Footballer();
        f1.setFirstName("Cristiano");
        f1.setLastName("Ronaldo");
        f1.setNationality("Portugal");
        Footballer f2 = new Footballer();
        f2.setFirstName("Xabi");
        f2.setLastName("Alonso");
        f2.setNationality("Spain");

        Set<Footballer> footballersSet = new HashSet();
        footballersSet.add(f1);
        footballersSet.add(f2);

        c1.setFootballersPlayedIn(footballersSet);

        Set<Club> clubsPlayed = new HashSet<>();
        clubsPlayed.add(c1);
        f1.setClubsPlayedIn(clubsPlayed);
        f2.setClubsPlayedIn(clubsPlayed);

        clubRepository.save(c1);
        footballerRepository.save(f1);
        footballerRepository.save(f2);

        Puzzle p1 = new Puzzle();
        p1.setFootballers(footballersSet);
        p1.setMutualClub(c1);
        p1.setDifficulty(50.0);
        puzzleRepository.save(p1);
    }
}

