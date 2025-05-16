
import java.io.IOException;
import java.util.Scanner;


public class HangManGame {
    public static void main(String[] args) throws IOException {
        GameView gameView = new GameView();
        gameView.showInfo();

        RandomWord word = new RandomWord();

        HangmanDrawer drawer = new HangmanDrawer();

        WordSelector wordSelector = new WordSelector();
        wordSelector.playGame(word.randomWord(), drawer, gameView, new Scanner(System.in));


    }

}

