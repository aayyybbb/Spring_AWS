package com.jojoldu.book.sbws.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(of = {"name","age"})
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamId")
    private Teams team;

    public Members(String name, int age , Teams team) {
        this.name = name;
        this.age = age;
        if(team != null) {
            changeTeam(team);
        }
    }
    private void changeTeam(Teams team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
