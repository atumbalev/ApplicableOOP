// Fig. 7.11: DeckOfCardsTest.java
// Card shuffling and dealing application.

public class DeckOfCardsTest
{
   // execute application
   public static void main( String args[] )
   {
      DeckOfCards myDeckOfCards = new DeckOfCards();
      myDeckOfCards.shuffle(); // place Cards in random order

      /*
      // print all 52 Cards in the order in which they are dealt
      for ( int i = 0; i < 13; i++ )
      {
         // deal and print 4 Cards
         System.out.printf( "%-20s%-20s%-20s%-20s\n",
            myDeckOfCards.dealCard(), myDeckOfCards.dealCard(),  
            myDeckOfCards.dealCard(), myDeckOfCards.dealCard() );
      } // end for
       */

      Card[] leftHand = myDeckOfCards.dealHand();
      for (int i = 0; i < leftHand.length; i++) {
         System.out.printf( "%-20s", leftHand[i].getFace() + " " + leftHand[i].getSuit());
      }
      System.out.println();
      int[] leftHandStrengt = strengths(leftHand, myDeckOfCards);
      System.out.println();

      Card[] rightHand = myDeckOfCards.dealHand();
      for (int i = 0; i < rightHand.length; i++) {
         System.out.printf( "%-20s", rightHand[i].getFace() + " " + rightHand[i].getSuit());
      }
      System.out.println();
      int[] rightHandStrengt = strengths(rightHand, myDeckOfCards);
      System.out.println();

      for (int i = 0; i < leftHandStrengt.length; i++) {
         if (leftHandStrengt[i] > rightHandStrengt[i]) {
            System.out.println("\n\nLeft Hand is Better");
            return;
         }
         if (leftHandStrengt[i] < rightHandStrengt[i]) {
            System.out.println("\n\nRight Hand is Better");
            return;
         }
      }

      System.out.println("\n\nBoth hands are equal");
   } // end main

   public static int[] strengths(Card[] hand, DeckOfCards myDeck) {
      int[] strength = new int[7];

      int couples = myDeck.getPairs(hand);
      int triples = myDeck.triples(hand);

      if (myDeck.hasFourOfAKind(hand)) {
         strength[0] = 1;
         System.out.printf("%-20s", "Four of a kind");
         return strength;
      }

      if (myDeck.hasFullHouse(couples, triples)) {
         strength[1] = 1;
         System.out.printf("%-20s", "Full house");
         return strength;
      }

      if (myDeck.flush(hand)) {
         strength[2] = 1;
         System.out.printf("%-20s", "Flush");
         return strength;
      }

      if (myDeck.straight(hand)) {
         strength[3] = 1;
         System.out.printf("%-20s", "Straight");
         return strength;
      }

      if (myDeck.hasTriple(triples)) {
         strength[4] = 1;
         System.out.printf("%-20s", "Triple");
         return strength;
      }

      if (myDeck.twoPairs(couples)) {
         strength[5] = 1;
         System.out.printf("%-20s", "Two Pairs");
         return strength;
      }

      if (myDeck.pair(couples)) {
         strength[6] = 1;
         System.out.printf("%-20s", "Pair");
         return strength;
      }

      System.out.printf("%-20s", "None");
      return strength;
   }
} // end class DeckOfCardsTest

