package Blackjack;

public class AtlanticCityDealer implements player {

    public boolean willHit(Hand h){
        if(h.getScore()<17){
            return true;
        }
        else{
            return false;
        }
        //return (h.getScore()<17);
    }
    public void showLastHand( Hand h){}
    public void shoeWasReset(){}
}
