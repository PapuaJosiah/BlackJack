package Blackjack;

import java.util.ArrayList;

public class Hand {
    private int totalScore=0;

    public ArrayList<Card> hand = new ArrayList<>();

    public Hand(Shoe x){
        hand.add(x.deal());
        hand.add(x.deal());
    }

    public void hit(Shoe x){
        hand.add(x.deal());
    }
    //Jack Kearney helped me with this.
    public void printHand(){
       for(Card c:hand){
           System.out.println(c.toString());
       }
    }
    public int getScore(){
        totalScore=0;
        Integer numElevenAces=0;
        for(Card c: hand) {
            if(c.getRank()<11&&c.getRank()>1){
                totalScore+=c.getRank();
            }
            else if (c.getRank()>10) {
                totalScore+=10;
            }
            else if (c.getRank()==1){
                numElevenAces+=1;
                totalScore+=11;
            }
        }
        while(totalScore>21&&numElevenAces>0){
           numElevenAces-=1;
           totalScore-=10;
        }
        return totalScore;
    }

}
