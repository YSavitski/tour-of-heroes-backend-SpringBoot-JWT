package com.example.angular.tour_of_heroes_backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor
public class Hero {
    @Id
    @GeneratedValue
    private long id;

    private String name;
}
