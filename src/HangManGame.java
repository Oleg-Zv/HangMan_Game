
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
            System.out.println("\t\nДобро пожаловать в Виселицу!");
            System.out.println("\tВвведите \"С\"-тарт  для начала игры,иначе \"В\"-ыход.");

        }

        public  boolean startsGame() {//старт
            Scanner scanner = new Scanner(System.in);
            String start = scanner.nextLine();
            return start.equalsIgnoreCase("С");
        }

    }

