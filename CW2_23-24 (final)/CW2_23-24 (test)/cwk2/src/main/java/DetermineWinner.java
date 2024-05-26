/**
 * <h1>A class to determine the winner of Baccarat</h1>
 *
 * @author Ngakudzweishe E. (Eben) Njaravani
 */
public class DetermineWinner {

    public static char winnerTwoCards(BaccaratHand punto, BaccaratHand banco) {
        if (punto.isNatural() && !banco.isNatural()) {
            System.out.println("Player wins with a natural!");
            return Baccarat.GameOutcome.PLAYER.getOutcome();
        } else if (!punto.isNatural() && banco.isNatural()) {
            System.out.println("Banker wins with a natural!");
            return Baccarat.GameOutcome.BANKER.getOutcome();
        } else if (punto.isNatural() && banco.isNatural()) {
            // In case both have a natural, the higher value wins
            if (punto.value() > banco.value()) {
                System.out.println("Player wins with the higher natural!");
                return Baccarat.GameOutcome.PLAYER.getOutcome();
            } else if (punto.value() < banco.value()) {
                System.out.println("Banker wins with the higher natural!");
                return Baccarat.GameOutcome.BANKER.getOutcome();
            }
        }
        // Consult the Tableau of Drawing rules
        return Baccarat.GameOutcome.TIE.getOutcome();
    }

    public static char winnerThreeCards(BaccaratHand punto, BaccaratHand banco) {
        GameEngine.displayHandTotals(punto, banco);
        if (punto.value() > banco.value()) {
            System.out.println("Player wins!");
            return Baccarat.GameOutcome.PLAYER.getOutcome();
        } else if (punto.value() < banco.value()) {
            System.out.println("Banker wins!");
            return Baccarat.GameOutcome.BANKER.getOutcome();
        } else {
            System.out.println("It's a tie!");
            return Baccarat.GameOutcome.TIE.getOutcome();
        }
    }
}
