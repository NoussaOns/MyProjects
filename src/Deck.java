import java.util.Random;

import java.util.Scanner;


public class Deck {

    private static final int ROYAL_FLUSH = 8;
    private static final int FOUR_OF_A_KIND = 7;
    private static final int FULL_HOUSE = 6;
    private static final int FLUSH = 5;
    private static final int STRAIGHT = 4;
    private static final int THREE_OF_A_KIND = 3;
    private static final int TWO_PAIRS = 2;
    private static final int ONE_PAIR = 1;
    private static final int NO_PAIR = 0;
    private static String[] CardOrder = {"NO Pair", "One Pair", "Two Pair", "Three Of a Kind", "Straight", "Flush", "Full House", "Four Of A Kind", "Royal Flush"};
    private final int NUMBER_OF_CARDS = 52;
    private Card[] deck;
    private int currentCard = 0;
    private Random randomNumbers = new Random();
    private Hand handPlayer = new Hand();

// Constructor for creating a deck of cards

    public Deck() {

        deck = new Card[NUMBER_OF_CARDS];

        for (int count = 0; count < deck.length; count++) {

            deck[count] = new Card(count % 13, count / 13);

        }

    }

// Method to shuffle cards using Random Class from java.lang

    public void shuffle() {

        for (int first = 0; first < deck.length; first++) {

            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            Card temp = deck[first];
            deck[first] = deck[second];

            deck[second] = temp;

        }

    }

    public void dealHand() {

        for (int i = 0; i < 5; i++) {

            handPlayer.setHand(i, deck[currentCard++]);

        }

    }

    public void playPoker() {

        shuffle();

        dealHand();

        System.out.println("Your hand is:");

        handPlayer.printHand();

        Scanner input = new Scanner(System.in);

        System.out.println("specify number of cards you want to change");

        int choice = input.nextInt();

        if (choice == 5) {

            for (int i = 0; i < 5; i++) {

                changeHand(i);

            }

        } else if (choice != 0) {

            for (int i = choice; i > 0; i--) {

                System.out.println("Enter the position of card you want change");
                changeHand(input.nextInt());

            }

        }

        System.out.printf("Your Result is : %s", CardOrder[handPlayer.score()]);

        System.out.println("Your hand is:");

        handPlayer.printHand();

    }

    public void changeHand(int cardIndex) {

        handPlayer.setHand(cardIndex, deck[currentCard++]);

    }

}