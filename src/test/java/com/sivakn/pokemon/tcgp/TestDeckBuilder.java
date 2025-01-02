package com.sivakn.pokemon.tcgp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sivakn.pokemon.tcgp.engine.CardManager;
import com.sivakn.pokemon.tcgp.entities.Card;
import com.sivakn.pokemon.tcgp.entities.Type;
import com.sivakn.pokemon.tcgp.repository.CardRepository;

public class TestDeckBuilder {
    @Autowired
    private CardRepository cardRepository;

    public TestDeckBuilder() {

    }
    @Test
    void testCreateCard() {
        Card charizard = createCharizardCard();
        CardManager cardManager = new CardManager(cardRepository);
        cardManager.createCard(charizard);

        System.out.println(charizard);
    }

    private Card createCharizardCard() {
        return Card.builder()
                .name("Charizard")
                .hp(180)
                .basic(false)
                .type(Type.FIRE)
                .ex(true)
                .build();
    }
}
