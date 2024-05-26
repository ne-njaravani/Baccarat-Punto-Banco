/**
 * <h1>A class for the main logic to play Baccarat</h1>
 *
 * @author Ngakudzweishe E. (Eben) Njaravani
 */
public class GameEngine {

    public static void dealFirstTwoCards(BaccaratHand hand, Shoe s) {
        while (hand.size() < 2) {
            hand.add(s.deal());
        }

    }

    public static void displayHandTotals(BaccaratHand punto, BaccaratHand banco) {
        System.out.printf("Player: %s = %d", punto.toString(), punto.value());
        System.out.printf("\nBanker: %s = %d\n", banco.toString(), banco.value());
    }


    static void gameLogic(Shoe s, BaccaratHand banco, BaccaratHand punto, GameStatistics stats) {
        char winnerFound;
        s.shuffle();
        dealFirstTwoCards(punto, s);
        dealFirstTwoCards(banco, s);

        displayHandTotals(punto, banco);
        winnerFound = DetermineWinner.winnerTwoCards(punto, banco);

        if (winnerFound == Baccarat.GameOutcome.TIE.getOutcome()
                && punto.size() == 2 && banco.size() == 2) {
            ThirdCardRules.tableauOfDrawingRules(punto, banco, s);
            winnerFound = DetermineWinner.winnerThreeCards(punto, banco);

        }
        if (winnerFound == Baccarat.GameOutcome.PLAYER.getOutcome()
                && punto.size() == 2 && banco.size() == 2) {
            winnerFound = DetermineWinner.winnerThreeCards(punto, banco);
        }
        if (winnerFound == Baccarat.GameOutcome.BANKER.getOutcome()
                && punto.size() == 2 && banco.size() == 2) {
            winnerFound = DetermineWinner.winnerThreeCards(punto, banco);
        }
        GameStatistics.updateGameStats(stats, winnerFound);
    }
}
