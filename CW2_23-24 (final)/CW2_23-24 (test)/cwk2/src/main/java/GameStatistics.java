/**
 * <h1>Class to store, manipulate and output the game statistics</h1>
 *
 * @ Ngakudzweishe E. (Eben) Njaravani
 */

public class GameStatistics {
    private int roundsPlayed;
    private int playerWins;
    private int bankerWins;
    private int ties;

    public GameStatistics() {
        this.roundsPlayed = 0;
        this.playerWins = 0;
        this.bankerWins = 0;
        this.ties = 0;
    }

    public void incrementRoundsPlayed() {
        roundsPlayed++;
    }

    public void incrementPlayerWins() {
        playerWins++;
    }

    public void incrementBankerWins() {
        bankerWins++;
    }

    public void incrementTies() {
        ties++;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }


    public static void updateGameStats(GameStatistics stats, char winner) {
        switch (winner) {
            case 'P':
                stats.incrementPlayerWins();
                break;
            case 'B':
                stats.incrementBankerWins();
                break;
            case 'T':
                stats.incrementTies();
                break;
            default:
                break;
        }
    }

    public void displayScoreboard() {
        System.out.printf("\n\n%d rounds played", roundsPlayed);
        System.out.printf("\n%d player wins", playerWins);
        System.out.printf("\n%d banker wins", bankerWins);
        System.out.printf("\n%d ties\n", ties);
    }

}
