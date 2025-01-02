package com.sivakn.pokemon.tcgp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sivakn.pokemon.tcgp.entities.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
//    @PersistenceContext
//    private EntityManager entityManager;
    @Query("SELECT c FROM Card c WHERE c.name = :name")
    Card findCardByName(String name);
}
