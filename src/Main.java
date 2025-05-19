import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        GameView gameView = new GameView();
        gameView.startMenu();

        HangmanDrawer drawer = new HangmanDrawer();
        RandomWord word = new RandomWord();
        GameView view = new GameView();

        GameLogic gameLogic = new GameLogic(word.randomWord(),drawer, view, scanner);
        gameLogic.playGame();

        scanner.close();
    }

}

