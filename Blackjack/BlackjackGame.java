package Blackjack;

public class BlackjackGame {
    private final player dealer;
    private final player player;

    private int playerScore=0;
    private int dealerScore=0;

    public BlackjackGame(player player, player dealer){
        this.dealer=dealer;
        this.player=player;
    }
    public void playRound(){
        Shoe s=new Shoe(4);
        Hand dealerHand=new Hand(s);
        Hand playerHand=new Hand(s);

        while (player.willHit(playerHand)){
            playerHand.hit(s);
        }
        if(playerHand.getScore()<=21){
        //    dealerScore+=1;
        //    System.out.println("Dealer Wins!");
        //}
        // if(playerHand.getScore()<=21&&dealer.willHit(dealerHand)){
            while (dealer.willHit(dealerHand)){
                dealerHand.hit(s);
            }
        }



        if(dealerHand.getScore()>21){
            playerScore+=1;
            System.out.println("Player Wins!");
        }
        else if(playerHand.getScore()>21){
            dealerScore+=1;
            System.out.println("Dealer Wins!");
        }
        else if(dealerHand.getScore()<playerHand.getScore()) {
            playerScore += 1;
            System.out.println("Player Wins!");
        }
        else if(dealerHand.getScore()>playerHand.getScore()){
                dealerScore+=1;
                System.out.println("Dealer Wins!");

        }
        else if(playerHand.getScore()==dealerHand.getScore()){
            System.out.println("Tie!");
        }
        System.out.println("The player's hand was:");
        playerHand.printHand();
        System.out.println("The dealer's hand was:");
        dealerHand.printHand();
    }
    public void printAndPlay(BlackjackGame bjg, int numRounds){
        for(Integer i=0; i<numRounds; i++){
            bjg.playRound();
        }


    }
}
