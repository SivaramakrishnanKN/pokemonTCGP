package com.sivakn.pokemon.tcgp.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Collections;
import java.util.List;

@Entity
public class Deck {
    @Id
    private int id;
    @OneToMany
    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

}
