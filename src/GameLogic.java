import java.util.*;

public class GameLogic {
    private final String  word;
    private final HangmanDrawer drawer;
    private final GameView view;
    private final Scanner scanner;
    private StringBuilder lockWord;
    private Set<String> enteredLetters;
    private int countError;
    private int tryCount;
    private String letter;

    private final int MAX_ERROR = 6;

    public GameLogic(String word, HangmanDrawer drawer, GameView view, Scanner scanner) {
        this.word = word;
        this.drawer = drawer;
        this.view = view;
        this.scanner = scanner;
        this.tryCount = 6;

    }

    public  void  playGame(){
        do {
            initGame();
            globalCheckLetter();
            winOrOver();
            restartGame();
        } while (true);
        }

    private void initGame() {
        lockWord = new StringBuilder(word.replaceAll("[а-яА-Я]", "_"));
        enteredLetters = new HashSet<>();
        countError = 0;
        tryCount = 6;
        letter = "";

    }

    private void globalCheckLetter(){
            while (!lockWord.toString().equalsIgnoreCase(word) && countError != MAX_ERROR) {
                System.out.println("\nВведите букву: ");
                letter = scanner.nextLine();
                while (isCheckLetterLength(letter) || isRepeatLetter(enteredLetters, letter) || !isRusEntered(letter)) {

                    if (isCheckLetterLength(letter)) {
                        System.out.println("Ошибка! Введите Одну букву");
                    } else if (isRepeatLetter(enteredLetters, letter)) {
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


            private void winOrOver() {
                if (lockWord.toString().equalsIgnoreCase(word)) {
                    view.winGameMessage(lockWord, word);
                } else {
                    view.overGameMessage(countError, word, MAX_ERROR);
                }
            }

             private void restartGame() {
                System.out.println("\n\tСыграем ещё?");
                view.startMenu();
            }

    private boolean isRusEntered(String letter){
        return letter.matches("[а-яА-Я]");

    }
    private boolean isCheckLetterLength(String letter) {
        return letter.length() > 1;
    }

    private boolean isRepeatLetter(Set<String> enteredLetters, String letter) {
        return enteredLetters.contains(letter);
    }

}