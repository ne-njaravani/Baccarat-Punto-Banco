/**
 * <h1>The main class that implements the game of Baccarat</h1>
 *
 * <p>This will be the Punto Banco version of the game</p>
 *
 * @author Ngakudzweishe E. (Eben) Njaravani
 */

public class Baccarat {

    // Constants
    static final int ACCEPTABLE_SHOE_SIZE = 6;


    public enum GameOutcome {
        PLAYER('P'), BANKER('B'), TIE('T');

        private final char outcome;

        GameOutcome(char winner) {
            this.outcome = winner;
        }

        public char getOutcome() {
            return outcome;
        }
    }


    public static void main(String[] args) {

        Shoe shoe = new Shoe(8);
        shoe.shuffle();
        BaccaratHand banker = new BaccaratHand();
        BaccaratHand player = new BaccaratHand();
        boolean endGame = false;
        GameStatistics stats = new GameStatistics();

        if (args.length == 1 && (args[0].equals("-i") || args[0].equals("--interactive"))) {

            while (!endGame) {

                stats.incrementRoundsPlayed();
                System.out.printf("\nRound %d\n", stats.getRoundsPlayed());
                shoe = new Shoe(8);
                GameEngine.gameLogic(shoe, banker, player, stats);
                endGame = NewRound.promptForNewRound(player, banker, shoe);
            }

            stats.displayScoreboard();

        } else if (args.length == 0) {

            shoe = new Shoe(8);

            while (!endGame) {
                stats.incrementRoundsPlayed();
                System.out.printf("\nRound %d\n", stats.getRoundsPlayed());
                GameEngine.gameLogic(shoe, banker, player, stats);
                endGame = NewRound.checkShoeForNewRound(player, banker, shoe);
            }

            stats.displayScoreboard();
        }
    }
}



