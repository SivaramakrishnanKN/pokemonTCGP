package com.sivakn.pokemon.tcgp.engine;


import com.sivakn.pokemon.tcgp.entities.Player;

import java.util.Scanner;

public class Battle {
    Player playerOne;
    Player playerTwo;
    public void battle() {
        System.out.println("Toss");
        Scanner sc = new Scanner(System.in);
        sc.next();
        boolean first = Math.random()>0.5?false:true;
        if(first) {
            System.out.println("Player One goes first.");
        } else {
            System.out.println("Player Two goes first.");
        }

    }
}
