package com.sivakn.pokemon.tcgp.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;
    private int hp;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Move> moves;
    private boolean basic;
    private boolean ex;
}
