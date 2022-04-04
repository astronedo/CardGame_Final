
package content;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Card {
        //The game is called Close Guess that Number!
    public static String [] userDeck=new String[26];
    public static String [] comDeck=new String[26];//COMPUTER DECK
    
    private static String[] SUITS = {
            "Clubs", "Diamonds", "Hearts", "Spades"
        };

    private static String[] VALUES = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
    };
    private static int n = SUITS.length * VALUES.length;
    private static String [] shufDeck=new String[n];
    public String[] cardDeck(){
            //------------------------------------Deck of Card Generator
        //Initiator

        String[] deck = new String[n];
        for (int i = 0; i < VALUES.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                deck[SUITS.length*i + j] = VALUES[i] + " of " + SUITS[j];
            }
        }

        // shuffle
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }
                

        for(int i=0;i<n;i++){
            shufDeck[i]=deck[i];
        }
       return shufDeck;
    }
    public String[] userDeck(){
        for(int i=0;i<26;i++){
            userDeck[i]=shufDeck[i];
        }
        return userDeck;
    }
    public String[] compDeck(){
        for(int i=0;i<26;i++){
            comDeck[i]=shufDeck[i+26];
        }
        return comDeck;
    }
        
        //The shuffled cards will be on a new array[]
        //after creating the card identities, the card is shuffled, then I stored the shuffled cards into an array to make it its own identity

}
