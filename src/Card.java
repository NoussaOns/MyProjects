//class Card implements interface Comparable which is used for sorting an array of Card objects based on the card face values. It's

public class Card implements Comparable<Card> {

    private int face;

    private int suit;

    private String faces[] = {"Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};

    private String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};

    public Card(int cardFace, int cardSuit) {

        face = cardFace;

        suit = cardSuit;

    }

    public String toString() {

        return faces[face] + " of " + suits[suit];

    }

    public int getFace() {

        return face;

    }

    public int getSuit() {

        return suit;

    }

    public int compareTo(Card compareCard) {

        int compareFace = ((Card) compareCard).getFace();

        return compareFace - this.face;

    }

}