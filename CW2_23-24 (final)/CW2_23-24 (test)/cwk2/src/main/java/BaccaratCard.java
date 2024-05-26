/**
 * <h1>A class to represent a hand of cards in Baccarat</h1>
 *
 * @author Ngakudzweishe E. (Eben) Njaravani
 */

public class BaccaratCard extends Card {

    /**
     * Store the rank and suit of the card.
     *
     * @param r Rank of the card
     * @param s Suit of the card
     */
    public BaccaratCard(Rank r, Suit s) {
        super(r, s);

    }


    /**
     * Calculates the points value of a card in the game of Baccarat.
     *
     * @return the points value of a card in the game of Baccarat.
     */

    @Override
    public int value() {
        if (getRank() == Rank.TEN || getRank() == Rank.JACK
                || getRank() == Rank.QUEEN || getRank() == Rank.KING) {
            return 0;
        }
        return super.value();
    }
}