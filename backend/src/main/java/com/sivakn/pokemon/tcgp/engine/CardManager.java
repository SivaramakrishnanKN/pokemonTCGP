package com.sivakn.pokemon.tcgp.engine;

import org.springframework.beans.factory.annotation.Autowired;

import com.sivakn.pokemon.tcgp.entities.Card;
import com.sivakn.pokemon.tcgp.repository.CardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cards")
public class CardManager {

    @Autowired
    private final CardRepository cardRepository;

    public CardManager(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @PostMapping
    public Card createCard(@RequestBody Card card) {
        return cardRepository.save(card);
    }

    public Card getCardByName(String name) {
        return cardRepository.findCardByName(name);
    }

    @GetMapping
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
}
