// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.BlockingDeque;

public class DeckOfCards
{
   private Card[] deck; // array of Card objects
   private int currentCard; // index of next Card to be dealt
   private final int NUMBER_OF_CARDS = 52; // constant number of Cards
   private Random randomNumbers; // random number generator

   private static final int HAND_SIZE = 5;

   private String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
           "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
   private String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };

   // constructor fills deck of Cards
   public DeckOfCards()
   {
      String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
      String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };

      deck = new Card[ NUMBER_OF_CARDS ]; // create array of Card objects
      currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]
      randomNumbers = new Random(); // create random number generator

      // populate deck with Card objects
      for ( int count = 0; count < deck.length; count++ ) 
         deck[ count ] = 
            new Card( faces[ count % 13 ], suits[ count / 13 ] );
   } // end DeckOfCards constructor

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle()
   {
      // after shuffling, dealing should start at deck[ 0 ] again
      currentCard = 0; // reinitialize currentCard

      // for each Card, pick another random Card and swap them
      for ( int first = 0; first < deck.length; first++ ) 
      {
         // select a random number between 0 and 51 
         int second =  randomNumbers.nextInt( NUMBER_OF_CARDS );
         
         // swap current Card with randomly selected Card
         Card temp = deck[ first ];        
         deck[ first ] = deck[ second ];   
         deck[ second ] = temp;            
      } // end for
   } // end method shuffle

   // deal one Card
   public Card dealCard()
   {
      // determine whether Cards remain to be dealt
      if ( currentCard < deck.length )
         return deck[ currentCard++ ]; // return current Card in array
      else        
         return null; // return null to indicate that all Cards were dealt
   } // end method dealCard

   public Card[] dealHand() {
      Card[] hand = new Card[HAND_SIZE];

      for (int i = 0; i < HAND_SIZE; i++) {
         hand[i] = dealCard();
      }

      return hand;
   }

   private int[] handStrength(Card[] hand) {
      int[] cardStrength = new int[faces.length];

      for (int i = 0; i < hand.length; i++) {
         for (int j = 0; j < faces.length; j++) {
            if (hand[i].getFace().equals(faces[j])) {
               ++cardStrength[j];
            }
         }
      }

      return cardStrength;
   }

   public int getPairs(Card[] hand) {
      int couples = 0;
      int[] handStrength = handStrength(hand);

      for (int i = 0; i < handStrength.length; i++) {
         if (handStrength[i] > 1) {
            ++couples;
         }
      }

      return couples;
   }

   public boolean pair(int couples) {
      return couples == 1 ? true : false;
   }

   public boolean twoPairs(int couples) {
      return couples == 2 ? true : false;
   }

   public int triples(Card[] hand) {
      int triples = 0;
      int[] number = handStrength(hand);

      for (int i = 0; i < number.length; i++) {
         if (number[i] == 3) {
            ++triples;
         }
      }

      return triples;
   }

   public boolean hasTriple(int numberOfTriples) {
      return numberOfTriples == 1;
   }

   public boolean hasFourOfAKind(Card[] hand) {

      int[] power = handStrength(hand);

      for (int i = 0; i < power.length; i++) {
         if (power[i] == 4) {
            return true;
         }
      }

      return false;
   }

   public boolean flush(Card[] hand) {

      String suit = hand[0].getSuit();

      for (int i = 1; i < hand.length; i++) {
         if (!hand[i].getSuit().equals(suit)) {
            return false;
         }
      }
         return true;
   }

   public boolean straight(Card[] hand) {
      int[] locations = new int[HAND_SIZE];

      int l = 0;
      int[] power = handStrength(hand);

      for (int i = 0; i < power.length; i++) {
         if (power[i] == 1) {
            locations[l++] = 1;
         }
         if (power[i] > 1) {
            return false;
         }
      }

      if (locations[0] + 4 == locations[4] || (locations[0]  == 0 && locations[4] == 12 && locations[1] + 3 == locations[4])) {
         return true;
      }
      return false;
   }

   public boolean hasFullHouse(int couples, int triples) {
      if (couples == 1 && triples == 1) {
         return true;
      }
      return false;
   }
} // end class DeckOfCards


