package Blackjack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class CardJPanel extends JPanel {
    ArrayList<Card> cards;
    public CardJPanel() {
        cards = new ArrayList<Card>();
        cards. add(new Card(10));
        cards.add(new Card(24));
        cards.add(new Card(33));
        cards.add(new Card(51));
        for(Card c:cards) {
            JLabel label = new JLabel(c.toUnicode());
            label.setFont(new Font("Serif",Font.BOLD,75));
            label.addMouseListener(new MouseAdapter(){
                int mouseClicks=0;
                public void mouseClicked(MouseEvent e){
                    mouseClicks+=1;
                    if(mouseClicks%2==1) {
                        label.setForeground(Color.blue);
                        System.out.println("Mouse Clicked");
                    }
                    else{
                        label.setForeground(Color.black);
                    }
                }
            });
            add(label);
        }



    }
    public static void main(String[] args){
        JFrame jf=new JFrame("Card Selection");

        jf.add(new CardJPanel());

        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }
}
