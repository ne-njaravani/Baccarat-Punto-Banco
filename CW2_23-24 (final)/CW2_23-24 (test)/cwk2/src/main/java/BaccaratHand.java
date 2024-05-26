/**
 * <h1>A class to represent a hand of cards in Baccarat</h1>
 *
 * @author Ngakudzweishe E. (Eben) Njaravani
 */
public class BaccaratHand extends CardCollection {

    public BaccaratHand() {
        super();
    }


    /**
     * Checks if the hand is a Natural.
     *
     * @return true if the hand is a Natural and false otherwise.
     */
    public boolean isNatural() {
        return size() == 2 && (value() == 8 || value() == 9);
    }


    /**
     * Displays the card details of the cards in the hand.
     *
     * @return the details of the cards in the hand.
     */
    @Override
    public String toString() {
        StringBuilder cardDetails = new StringBuilder();
        for (Card item : cards) {
            cardDetails.append(item.toString());
            cardDetails.append(" ");
        }
        if (!cardDetails.isEmpty()) {
            cardDetails.deleteCharAt(cardDetails.length() - 1);
        }
        return cardDetails.toString();
    }


    /**
     * Calculates the points value of a hand in the game of Baccarat.
     *
     * @return the points value of a hand in the game of Baccarat.
     */
    @Override
    public int value() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.value();
        }
        return sum % 10;
    }


}
