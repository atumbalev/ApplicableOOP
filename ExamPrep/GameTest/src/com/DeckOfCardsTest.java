package com;

import java.util.Arrays;

public class DeckOfCardsTest {

    public static void main(String[] args) {
        System.out.println("\nSORT TEST\n");
        DeckOfCards deckOfCards = new DeckOfCards();
        System.out.println("After construction:");
        System.out.println(deckOfCards.getDistinctFaces());
        System.out.println("After shuffle:");
        deckOfCards.shuffleCards();
        System.out.println(deckOfCards.getDistinctFaces());
        System.out.println("After sort:");
        deckOfCards.sortByFaceCards();
        System.out.println(deckOfCards.getDistinctFaces());

        System.out.println("\nDEAL TEST\n");
        DeckOfCards deckOfCards1 = new DeckOfCards();
        deckOfCards1.shuffleCards();
        System.out.println("After shuffle (faces):");
        System.out.println(deckOfCards1.getDistinctFaces());

        System.out.println("\nBEGIN DEALING\n");
        for (int i = 0; i < 12; i++) {
            System.out.println(Arrays.toString(deckOfCards1.dealFive()));
        }
    }

}