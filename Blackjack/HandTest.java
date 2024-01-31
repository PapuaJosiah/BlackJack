package Blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class HandTest {
    @Test
    public void testAces(){
        Hand h=new Hand(new fixedShoe(5));
        assertEquals(12, h.getScore());
    }

    @Test
    public void testHand(){
        fixedShoe shoe = new fixedShoe(5);
        player p=new AtlanticCityDealer();
        Hand t=new Hand(shoe);
        Hand h=new Hand(shoe);

        assertEquals(12, t.getScore());
        assertEquals(15, h.getScore());
        assertTrue(p.willHit(t));
        assertTrue(p.willHit(h));
        h.hit(shoe);
        assertEquals(25, h.getScore());
        assertFalse(p.willHit(h));


    }
    @Test
    public void testUnicode(){
        Card c=new Card(38);
        assertEquals(0x1F0CE,c.toUnicode());

    }

}

class fixedShoe extends Shoe{
    private ArrayList<Card> c=new ArrayList<>();
    public Card deal(){
        return c.remove(0);
    }
    public fixedShoe(int deckNum) {
        super(deckNum);
        c.add(new Card(0));
        c.add(new Card(0));
        c.add(new Card(17));
        c.add(new Card(12));
        c.add(new Card(12));
    }
}
