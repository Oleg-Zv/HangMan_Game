import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordSelector {


    public void  playGame(String word, HangmanDrawer drawer, GameView view, Scanner sc){
        StringBuilder lockWord = new StringBuilder();
        lockWord.append(word.replaceAll("[а-яА-Я]", "_"));

        List<String> errorsList = new ArrayList<>();
        int countError = 0;
        int tryCount =6;

        while (!lockWord.toString().equalsIgnoreCase(word) && countError!=6) {
            System.out.println("\nВведите букву: ");

           String letter = sc.nextLine();
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (letter.equalsIgnoreCase(String.valueOf(word.charAt(i)))) {
                    found = true;
                    lockWord.setCharAt(i, letter.charAt(0));//заменяем символ _ на букву
                }
            }
            if (!found) {
                errorsList.add(letter);
                countError++;
                tryCount--;
            }
            drawer.draw(countError,word);
            view.playInfo(lockWord, errorsList, countError,tryCount, letter);

        }

        view.getWinAndOver(lockWord, word, countError);
    }
}
