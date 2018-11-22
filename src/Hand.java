import java.util.Arrays;

public class Hand {

    private static final int ROYAL_FLUSH = 8;
    private static final int FOUR_OF_A_KIND = 7;
    private static final int FULL_HOUSE = 6;
    private static final int FLUSH = 5;
    private static final int STRAIGHT = 4;
    private static final int THREE_OF_A_KIND = 3;
    private static final int TWO_PAIRS = 2;
    private static final int ONE_PAIR = 1;
    private static final int NO_PAIR = 0;
    private Card[] hand = new Card[5];
    private int count = 0;

    public void setHand(int number, Card dealtCard) {

        hand[number] = dealtCard;

        count++;

    }

    public Card getCard(int number) {

        return hand[number];

    }

    public void sortHand() {

        Arrays.sort(hand);

    }

    public void printHand() {

        for (int i = 0; i < 5; i++) {

            System.out.printf("%d.%s\n", i + 1, hand[i]);

        }

    }

    public int score() {

        sortHand();

        if (royalFlush())

            return ROYAL_FLUSH;

        else if (fourOfaKind())

            return FOUR_OF_A_KIND;

        else if (fullHouse())

            return FULL_HOUSE;

        else if (flush())

            return FLUSH;

        else if (straight())

            return STRAIGHT;

        else if (threeOfaKind())

            return THREE_OF_A_KIND;

        else if (twoPairs())

            return TWO_PAIRS;

        else if (onePair())

            return ONE_PAIR;

        else

            return NO_PAIR;

    }

    public boolean royalFlush() {

        if (straight() && flush())

            return true;

        else

            return false;

    }

    public boolean fullHouse() {

        if (threeOfaKind()) {

            if (hand[3].getFace() == hand[4].getFace())

                return true;

        }

        return false;

    }

    public boolean straight() {

        for (int i = 0; i < 4; i++) {

            if (!(hand[i].getFace() == hand[i + 1].getFace() - 1)) ;

            return false;

        }

        return true;

    }

    public boolean flush() {

        for (int i = 0; i < 4; i++) {

            if (!(hand[i].getSuit() == hand[i + 1].getSuit()))

                return false;

        }

        return true;

    }

    public boolean fourOfaKind() {

        if (threeOfaKind()) {

            if (hand[2].getFace() == hand[3].getFace())

                return true;

            else if (hand[2].getFace() == hand[4].getFace()) {

                Card temp = hand[3];

                hand[3] = hand[4];

                hand[4] = temp;

                return true;

            }

        }

        return false;

    }

    public boolean threeOfaKind() {

        for (int i = 0; i < 3; i++) {

            if (hand[i].getFace() == hand[i + 2].getFace()) {

                for (int j = 0; j < i; j++) {

                    Card temp = hand[j];

                    hand[j] = hand[j + 3];

                    hand[j + 3] = temp;

                }

                return true;

            }

        }

        return false;

    }

    public boolean twoPairs() {

        int[] pair = {5, 5};

        int count = 0;

        for (int i = 0; i < 4; i++) {

            if (hand[i].getFace() == hand[i + 1].getFace()) {

                pair[count] = i;

                count++;

            }

        }

        if (count == 2) {

            if (!(pair[0] == 0)) {

                Card temp = hand[0];

                hand[0] = hand[2];

                hand[2] = hand[4];

                hand[4] = temp;

            } else {

                if (!(pair[1] == 2)) {

                    Card temp = hand[2];

                    hand[2] = hand[4];

                    hand[4] = temp;

                }

            }

            return true;

        }

        return false;

    }

    public boolean onePair() {

        for (int i = 0; i < 4; i++) {

            if (hand[i].getFace() == hand[i + 1].getFace()) {

                Card temp = hand[0];

                hand[0] = hand[i];

                hand[i] = temp;

                temp = hand[1];

                hand[1] = hand[i + 1];

                hand[i + 1] = temp;

                Arrays.sort(hand, 2, 4);

                return true;

            }

        }

        return false;

    }

}