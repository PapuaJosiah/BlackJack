package Blackjack;

public class BlackJackGameDriver {
    public static void main( String[] args ){
        BlackjackGame bg = new BlackjackGame(new AtlanticCityDealer(), new AtlanticCityDealer());
        bg.printAndPlay(bg,500);
    }
}


