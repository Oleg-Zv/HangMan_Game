import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordSelector {
    private final int COUNT_ERROR = 6;


    public void playGame(String word) {//не готово/
        StringBuilder lockWord = new StringBuilder();
        List<String> errorsList = new ArrayList<>();
        lockWord.append(word.replaceAll("[а-яА-Я]", "_"));
        int countError = 0;// для ошибок кол=во
      //  System.out.println("Введите букву: ");
        Scanner sc = new Scanner(System.in);
        String letter = "";
HangmanDrawer drawer = new HangmanDrawer();
drawer.draw(countError,word);
        while (!lockWord.toString().equalsIgnoreCase(word) && countError != COUNT_ERROR) {
            System.out.println("Введите букву: ");
            letter = sc.nextLine();
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (letter.equalsIgnoreCase(String.valueOf(word.charAt(i)))) {
                    found = true;
                    lockWord.setCharAt(i, letter.charAt(0));//заменяем символ

                }
            }
            if (!found) {
                errorsList.add(letter);
                countError++;
            }

            HangmanDrawer h = new HangmanDrawer();
            System.out.println("\tСлово : " + lockWord);
            System.out.println("\tОшибки: (" + countError + "):" + errorsList);
            System.out.println("\tБуква: " + letter);
            h.draw(countError,word);

//            System.out.println("\n\tСлово : " + lockWord);
//            System.out.println("\tОшибки: (" + countError + "):" + errorsList);
//            System.out.println("\tБуква: " + letter);

        }




    }
}
