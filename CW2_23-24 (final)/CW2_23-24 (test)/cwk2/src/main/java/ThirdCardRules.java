/**
 * <h1>The Third Card Rules - Punto Banco</h1>
 *
 * <p>The class makes a decision of whether a third card should
 * be drawn by either the player or the banker</p>
 *
 * @author Ngakudzweishe E. (Eben) Njaravani
 */

public class ThirdCardRules {
    private static void dealThirdCard(String role, BaccaratHand hand, Shoe s) {
        System.out.printf("Dealing third card to %s...\n", role);
        hand.add(s.deal());
    }

    private static boolean bankerShouldDraw(BaccaratHand punto, BaccaratHand banco) {
        // Add logic to determine if the banker should draw a third card
        // This can be based on the current value of the punto and banco hands
        // and the rules of Baccarat
        if (punto.size() == 2) {
            if (banco.value() <= 5) {
                return true;
            }
        }
        if (punto.value() == 3) {
            if (banco.value() <= 2) {
                return true;
            }

            if (banco.value() == 3 && punto.cards.get(2).getRank() != Card.Rank.EIGHT) {
                return true;
            }
            if (banco.value() == 4 && (punto.cards.get(2).getRank() == Card.Rank.TWO
                    || punto.cards.get(2).getRank() == Card.Rank.THREE ||
                    punto.cards.get(2).getRank() ==
                            Card.Rank.FOUR || punto.cards.get(2).getRank() == Card.Rank.FIVE
                    || punto.cards.get(2).getRank()
                    == Card.Rank.SIX || punto.cards.get(2).getRank() == Card.Rank.SEVEN)) {
                return true;
            }
            if (banco.value() == 5 && (punto.cards.get(2).getRank() == Card.Rank.FOUR ||
                    punto.cards.get(2).getRank() == Card.Rank.FIVE ||
                    punto.cards.get(2).getRank() == Card.Rank.SIX
                    || punto.cards.get(2).getRank() == Card.Rank.SEVEN)) {
                return true;
            }
            if (banco.value() == 6 && (punto.cards.get(2).getRank() == Card.Rank.SIX ||
                    punto.cards.get(2).getRank() == Card.Rank.SEVEN)) {
                return true;
            }

        }
        return false;
    }

    public static void tableauOfDrawingRules(BaccaratHand punto, BaccaratHand banco, Shoe s) {
        // Player's rules
        if (punto.value() <= 5) {
            dealThirdCard("player", punto, s);
        }
        // Banker's rules
        if (bankerShouldDraw(punto, banco)) {
            dealThirdCard("banker", banco, s);
        }
    }
}
