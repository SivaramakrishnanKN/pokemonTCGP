package com.sivakn.pokemon.tcgp.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Deck {
    @Id
    private int id;
    @OneToMany
    private List<Card> cards;

    public void addCard(Card card) {
        cards.add(card);
    }
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

}
