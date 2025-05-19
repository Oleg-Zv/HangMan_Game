import java.util.*;

public class WordSelector {

    //обработка на любой некорректный ввод  при запуске/кроме а или в = +
    // обработка длины буквы = + )
    //обработка повторных букв верных =+ и неверных = +
    //и запрос на повтор игры = в процессе

    public void playGame(String word, HangmanDrawer drawer, GameView view, Scanner sc) {

        do {
            System.out.println("\tИгра начинается ^_^");
            System.out.println("\tСлово Загадано!\n");

            StringBuilder lockWord = new StringBuilder();
            lockWord.append(word.replaceAll("[а-яА-Я]", "_"));


            Set<String> enteredLetters = new HashSet<>();
            int countError = 0;
            int tryCount = 6;


            while (!lockWord.toString().equalsIgnoreCase(word) && countError != 6) {
                System.out.println("\nВведите букву: ");
              String letter = sc.nextLine();

                while (isCheckLetterLength(letter) || isRepeatLetter(enteredLetters, letter) || !isRusEntered(letter)) {
                    if (isCheckLetterLength(letter)) {
                        System.out.println("Ошибка! Введите Одну букву");
                    } else if(isRepeatLetter(enteredLetters,letter)){
                        System.out.println("Эта буква уже была! Введите другую букву");
                    }else{
                        System.out.println("Буква должна быть из Русского алфавита!");
                    }
                    letter = sc.nextLine();
                }


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
                drawer.draw(countError);
                view.playInfo(lockWord, enteredLetters, countError, tryCount, letter);

            }
            if (lockWord.toString().equalsIgnoreCase(word)) {
                view.winGameMessage(lockWord, word);
            } else {
                view.overGameMessage(countError, word);
            }
            System.out.println("\n\tСыграем ещё?");
         view.showInfo();


        } while (true);

    }
    public boolean isRusEntered(String letter){
        return letter.matches("[а-яА-Я]");

    }
    public boolean isCheckLetterLength(String letter) {
        return letter.length() > 1;
    }

    public boolean isRepeatLetter(Set<String> enteredLetters, String letter) {
        return enteredLetters.contains(letter);
    }

}

