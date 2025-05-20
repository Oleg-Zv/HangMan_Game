import java.io.IOException;
import java.util.*;

public class GameLogic {
    private String word;
    private String letter;
    private Set<String> enteredLetters;
    private StringBuilder lockWord;

    private final HangmanDrawer drawer;
    private final GameView view;
    private final Scanner scanner;

    private final int MAX_ERRORS = 6;
    private int countError;
    private int tryCount;


    public GameLogic(String word, HangmanDrawer drawer, GameView view, Scanner scanner) {
        this.word = word;
        this.drawer = drawer;
        this.view = view;
        this.scanner = scanner;
        this.tryCount = 6;

    }
    public void playGame() {
          try {
              RandomWord wordRand = new RandomWord();
              initGame(wordRand.randomWord());
              globalCheckLetter();
              checkWinOrOver();
              restartGame();
          }catch (IOException e){
              System.out.println("Ошибка чтения файла: " + e.getMessage());
          }
    }

    private void initGame(String word) {
       this.word = word;
        lockWord = new StringBuilder(word.replaceAll("[а-яА-Я]", "_"));
        enteredLetters = new HashSet<>();
        countError = 0;
        tryCount = 6;
        letter = "";

    }
    private void globalCheckLetter() {
        while (!lockWord.toString().equalsIgnoreCase(word) && countError != MAX_ERRORS) {
            System.out.println("\nВведите букву: ");
            letter = scanner.nextLine();
            while (isCheckLetterLength(letter) || isCheckRepeatLetter(enteredLetters, letter) || !isRusEnteredLetter(letter)) {

                if (isCheckLetterLength(letter)) {
                    System.out.println("Ошибка! Введите Одну букву");
                } else if (isCheckRepeatLetter(enteredLetters, letter)) {
                    System.out.println("Эта буква уже была! Введите другую букву");
                } else {
                    System.out.println("Буква должна быть из Русского алфавита!");
                }
                letter = scanner.nextLine();
            }
            checkContainsLetter(letter);
        }
    }

    private void checkContainsLetter(String letter) {
        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if (letter.equalsIgnoreCase(String.valueOf(word.charAt(i)))) {
                enteredLetters.add(letter);
                found = true;
                lockWord.setCharAt(i, letter.charAt(0));
            }
        }
        if (!found) {
            enteredLetters.add(letter);
            countError++;
            tryCount--;
        }
        currentInfoView();
    }

    private void currentInfoView() {
        drawer.draw(countError);
        view.playInfo(lockWord, enteredLetters, countError, tryCount, letter);
    }

    private void checkWinOrOver() {
        if (lockWord.toString().equalsIgnoreCase(word)) {
            view.winGameMessage(lockWord, word);
        } else {
            view.overGameMessage(countError, word, MAX_ERRORS);
        }
    }

    private void restartGame() {

        System.out.println("\n\tСыграем ещё?");
        view.startMenu();
        playGame();
    }

    private boolean isRusEnteredLetter(String letter) {
        return letter.matches("[а-яА-Я]");

    }

    private boolean isCheckLetterLength(String letter) {
        return letter.length() > 1;
    }

    private boolean isCheckRepeatLetter(Set<String> enteredLetters, String letter) {
        return enteredLetters.contains(letter);
    }
}