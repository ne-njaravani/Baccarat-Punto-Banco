/**
 * <h1>A class to determine if a new round should be played</h1>
 *
 * @author Ngakudzweishe E. (Eben) Njaravani
 */
import java.util.Scanner;

public class NewRound {

    public static boolean promptForNewRound(BaccaratHand punto, BaccaratHand banco, Shoe s) {
        while (true) {
            System.out.print("Another round? (y/n): ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().toLowerCase();
            try {
                char resume = input.charAt(0);
                if (resume == 'n') {
                    punto.discard();
                    banco.discard();
                    s.discard();
                    return true;
                } else if (resume == 'y') {
                    punto.discardTo(s);
                    banco.discardTo(s);
                    return false;
                } else {
                    throw new IllegalArgumentException
                            ("\nInvalid input. Please enter 'y' or 'n'.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }

    public static boolean checkShoeForNewRound
            (BaccaratHand punto, BaccaratHand banco, Shoe s) {

        if (s.size() < Baccarat.ACCEPTABLE_SHOE_SIZE) {
            punto.discard();
            banco.discard();
            s.discard();
            return true;
        } else {
            punto.discard();
            banco.discard();
            return false;
        }
    }
}
