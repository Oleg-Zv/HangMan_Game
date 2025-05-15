import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordSelector{
    private final int COUNT_ERROR = 5;


    public static void playGame(String word,int COUNT_ERROR) {//не готово/
        StringBuilder lockWord = new StringBuilder();
        List<String> errorsList = new ArrayList<>();
        lockWord.append(word.replaceAll("[а-яА-Я]", "_"));
        int countError = 0;// для ошибок кол=во
        System.out.println("Введите букву: ");
        Scanner sc = new Scanner(System.in);
        String letter = "";

        while (!lockWord.toString().equalsIgnoreCase(word) && countError != COUNT_ERROR) {
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

            System.out.println("\tСлово : " + lockWord);
            System.out.println("\tОшибки: (" + countError + "):" + errorsList);
            System.out.println("\tБуква: " + letter );

        }
    }
}
