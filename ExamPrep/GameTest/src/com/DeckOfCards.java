package com;

import cards.Card;
import cards.FaceOfCard;
import cards.SuitOfCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DeckOfCards {
    private ArrayList<Card> cards;
    int currentCard;

    public DeckOfCards() {
        initializeDeck();
        shuffleCards();
        currentCard = 0;
    }

    private void initializeDeck() {

        cards = new ArrayList<>(52);

        for (SuitOfCard suit : SuitOfCard.values()) {
            for (FaceOfCard face : FaceOfCard.values()) {
                cards.add(new Card(face, suit));
            }
        }
    }

    void shuffleCards() {
        Random random = new Random();

        int index;
        Card card;
        Card tmp;
        for (int i = cards.size(); i > 1; i--) {
            card = cards.get(i - 1);
            index = random.nextInt(i);
            tmp = cards.get(index);
            cards.set(index, card);
            cards.set(i - 1, tmp);

        }

        currentCard = 0;
    }

    public Card[] dealFive() {
        Card[] result = new Card[5];

        for (int i = 0; i < 5; i++) {
            if (currentCard < cards.size()) {
                result[i] = cards.get(currentCard);
            } else {
                result[i] = null;
            }
            ++currentCard;
        }

        return result;
    }

    public void sortByFaceCards() {
        int size;
        ArrayList<FaceOfCard> faces = new ArrayList<>(Arrays.asList(FaceOfCard.values()));

        size = cards.size();

        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < size; j++) {
                if(faces.indexOf(cards.get(j).getFace()) < faces.indexOf(cards.get(minIndex).getFace())) {
                    minIndex = j;
                }
            }

            if(minIndex != i) {
                Card c = cards.get(i);
                cards.set(i, cards.get(minIndex));
                cards.set(minIndex, c);
            }
        }
    }

    public void printBySuits() {
        ArrayList<Card> currentGroup;

        currentGroup = new ArrayList<>(13);

        for (SuitOfCard s : SuitOfCard.values()) {

            for (int i = currentCard; i < 52; i++) {
                Card currentCard = cards.get(i);
                if (currentCard.getSuit() == s) {
                    currentGroup.add(currentCard);
                }
            }

            System.out.printf("%s - %s\n", s, currentGroup);
            currentGroup.clear();
        }
    }

    public ArrayList<FaceOfCard> getDistinctFaces() {
        ArrayList<FaceOfCard> result;

        result = new ArrayList<>(52);

        for (int i = currentCard; i < 52; i++) {
            result.add(cards.get(i).getFace());
        }

        return result;
    }
}
