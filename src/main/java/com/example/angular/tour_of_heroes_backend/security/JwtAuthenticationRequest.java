package com.example.angular.tour_of_heroes_backend.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationRequest implements Serializable {
    private static final long serialVersionUID = 6365784203953100903L;

    private String username;
    private String password;
}
