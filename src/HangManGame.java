
import java.io.IOException;
import java.util.Scanner;


public class HangManGame {
    public static void main(String[] args) throws IOException {

HangManGame game = new HangManGame();
game.showInfo();
game.startsGame();

RandomWord word = new RandomWord();

WordSelector wordSelector = new WordSelector();
wordSelector.playGame(word.randomWord());



    }
        public void showInfo () {
            System.out.printf( "Добро пожаловать в Висилицу!");
            System.out.println("Ввведите \"s\"-tart  для начала игры,иначе \"e\"-xit для выхода.");

        }

        public  boolean startsGame() {//старт
            Scanner scanner = new Scanner(System.in);
            String start = scanner.nextLine();
            return start.equalsIgnoreCase("s");

        }
    }

