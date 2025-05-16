import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordSelector {

    //обработка на любой некорректный ввод  при запуске/кроме а или в
    // обработка длины буквы
    //и запрос на повтор игры

    public void  playGame(String word, HangmanDrawer drawer, GameView view, Scanner sc){
        System.out.println("\tИгра начинается ^_^");
        System.out.println("\tСлово Загадано!\n");

        StringBuilder lockWord = new StringBuilder();
        lockWord.append(word.replaceAll("[а-яА-Я]", "_"));

        List<String> errorsList = new ArrayList<>();
        int countError = 0;
        int tryCount =6;


        while (!lockWord.toString().equalsIgnoreCase(word) && countError!=6) {
            System.out.println("\nВведите букву: ");

           String letter = sc.nextLine();
           checkLetter(letter);

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
            drawer.draw(countError);
            view.playInfo(lockWord, errorsList, countError,tryCount, letter);

        }
        if(lockWord.toString().equalsIgnoreCase(word)){
            view.winGameMessage(lockWord, word);
    } else {
          view.overGameMessage(countError, word);
        }
        }

        public void checkLetter(String letter){
        if(letter.length()>1){
            System.out.println("Некорректный ввод! Введите одну букву!");
        }
    }
}
