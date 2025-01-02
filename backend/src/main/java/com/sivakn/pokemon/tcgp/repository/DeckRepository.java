package com.sivakn.pokemon.tcgp.repository;

import com.sivakn.pokemon.tcgp.entities.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepository extends JpaRepository<Deck, Integer> {
}
