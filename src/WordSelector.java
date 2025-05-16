import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordSelector {

    private final int COUNT_ERROR = 6;


    public void  playGame(String word, HangmanDrawer drawer, Scanner sc, GameView view){
        StringBuilder lockWord = new StringBuilder();
        lockWord.append(word.replaceAll("[а-яА-Я]", "_"));

        List<String> errorsList = new ArrayList<>();
        int countError = 0;// для ошибок кол=во

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
            }

            view.playInfo(lockWord, errorsList, countError, letter);
//          playInfo(lockWord, errorsList, countError, letter);
            drawer.draw(countError,word);

        }
    }
//    public void playInfo(StringBuilder lockWord, List<String> errorsList, int countError, String letter){
//        System.out.println("\tСлово : " + lockWord);
//        System.out.println("\tОшибки: (" + countError + "):" + errorsList);
//        System.out.println("\tБуква: " + letter);
//    }
}
