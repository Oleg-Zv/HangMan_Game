import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordSelector {

    private final int COUNT_ERROR = 6;


    public void  playGame(String word, HangmanDrawer drawer, GameView view, Scanner sc){
        StringBuilder lockWord = new StringBuilder();
        lockWord.append(word.replaceAll("[а-яА-Я]", "_"));

        List<String> errorsList = new ArrayList<>();
        int countError = 0;
        int tryCount =6;
        drawer.draw(countError,word);

        while (!lockWord.toString().equalsIgnoreCase(word) && countError != COUNT_ERROR) {
            System.out.println("Введите букву: ");

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

            view.playInfo(lockWord, errorsList, countError,tryCount, letter);
            drawer.draw(countError,word);

        }
        if(lockWord.toString().equalsIgnoreCase(word))
            System.out.println("\tУра! Вы победили!");

    }
}
