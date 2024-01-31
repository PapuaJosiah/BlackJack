package Blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Shoe implements Iterable<Card> {
    public ArrayList<Card> shoe;
    public ArrayList<Deck> decks = new ArrayList<>( );

    public Shoe(int deckNum) {
        BuildShoe(deckNum);
    }


    public void BuildShoe(int DeckNum) {
        shoe = new ArrayList<Card>();
        for (Integer i = 1; i <= DeckNum; i++) {
            Deck newDeck = new Deck();
            decks.add(newDeck);

            for (Card c: newDeck) {
                shoe.add(c);
            }

        }
        Collections.shuffle(shoe);
        System.out.println("New shoe created.");
    }
    public Card deal(){
        return shoe.remove(0);
    }


    public Iterator<Card> iterator() {
        return shoe.iterator();
    }
}
