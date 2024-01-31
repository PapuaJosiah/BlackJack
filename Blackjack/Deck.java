package Blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Deck implements Iterable<Card> {
    public ArrayList<Card> deck = new ArrayList<>();

    public Deck(){
        BuildDeck();
    }

    public void BuildDeck(){
        for (Integer n = 0; n <= (51); n++) {
            deck.add(new Card(n));
        }
        Collections.shuffle(deck);
    }
    public Iterator<Card> iterator() {
        return deck.iterator();
    }
}
