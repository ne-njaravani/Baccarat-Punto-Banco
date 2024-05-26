import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <h1>A class to represent the shoe from which cards are dealt in Baccarat.</h1>
 *
 * @author Ngakudzweishe E. (Eben) Njaravani
 */

public class Shoe extends CardCollection {

    private final List<BaccaratCard> shoe = new LinkedList<>();

    // initialises a shoe

    public Shoe(int decks) {
        if (!(decks == 8 || decks == 6)) {
            throw new CardException("Error");
        }

        int count = 0;

        while (count < decks) {
            for (Card.Suit suits : Card.Suit.values()) {
                for (Card.Rank rank : Card.Rank.values()) {
                    shoe.add(new BaccaratCard(rank, suits));
                }
            }
            count++;
        }
    }


    /**
     * Provides the number of cards in shoe.
     *
     * @return Number of cards in shoe.
     */
    @Override
    public int size() {
        return shoe.size();
    }

    /**
     * Shuffles the order of the cards in the shoe
     */
    public void shuffle() {
        Collections.shuffle(shoe);
    }


    /**
     * Deals the card to the caller or the hand.
     *
     * @return the first card in the shoe.
     */
    public BaccaratCard deal() {
        if (shoe.isEmpty()) {
            throw new CardException("Error: Empty shoe");
        }

        BaccaratCard firstStoredCard = shoe.getFirst();
        shoe.removeFirst();
        return firstStoredCard;
    }
}