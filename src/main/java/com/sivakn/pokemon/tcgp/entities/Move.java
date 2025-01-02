package com.sivakn.pokemon.tcgp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // Generates getters, setters, equals, hashCode, and toString
@NoArgsConstructor // Default constructor
@AllArgsConstructor // Constructor with all arguments
@Builder // Builder pattern support
public class Move {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String damage;
}
