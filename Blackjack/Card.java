package Blackjack;

public class Card {
    private final Integer rank;
    private final Integer suit;

    private String rankWord="";

    private String suitWord="";

    public Card(int cardNum){


        rank=cardNum%13+1;
        suit=cardNum/13;
    }

    public Integer getRank(){
        return rank;
    }
    public Integer getSuit(){
        return suit;
    }

    public String toUnicode(){
        int unicodeValue=0x1F0A1;
        if( getRank()>=12){
            unicodeValue=unicodeValue+getRank();
            unicodeValue=unicodeValue+((getSuit())*16);

        }
        else{
            unicodeValue=unicodeValue+getRank()-1;
            unicodeValue=unicodeValue+((getSuit())*16);
        }
        System.out.println(unicodeValue);
        return new String( Character.toChars( unicodeValue ) );

    }

    public String toString(){
        if(getSuit()==1){
            suitWord="Hearts";
        }
        else if(getSuit()==2){
            suitWord="Diamonds";
        }
        else if(getSuit()==3){
            suitWord="Clubs";
        }
        else{
            suitWord="Spades";
        }
        if(getRank()==1){
            rankWord="Ace";
        }
        else if(getRank()==2){
            rankWord="Two";
        }
        else if(getRank()==3){
            rankWord="Three";
        }
        else if(getRank()==4){
            rankWord="Four";
        }
        else if(getRank()==5){
            rankWord="Five";
        }
        else if(getRank()==6){
            rankWord="Six";
        }
        else if(getRank()==7){
            rankWord="Seven";
        }
        else if(getRank()==8){
            rankWord="Eight";
        }
        else if(getRank()==9){
            rankWord="Nine";
        }
        else if(getRank()==10){
            rankWord="Ten";
        }
        else if(getRank()==11){
            rankWord="Jack";
        }
        else if(getRank()==12){
            rankWord="Queen";
        }
        else if(getRank()==13){
            rankWord="King";
        }
        return rankWord + "of" + suitWord;
    }
}
