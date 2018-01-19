package com.example.angular.tour_of_heroes_backend.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class JwtAuthenticationResponse implements Serializable {
    private static final long serialVersionUID = -7137777451323881264L;
    private final String token;
}
