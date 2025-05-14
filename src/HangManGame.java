import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class HangManGame {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Добро пожаловать в Висилицу!");
        System.out.println("Ввведите \"s\"-tart  для начала игры,иначе \"e\"-xit для выхода.");
        startsGame();
        randomWord();


    }

    public static void startsGame() {//старт
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        if (start.equalsIgnoreCase("s")) {
            System.out.println("Игра начиналась!");
        }else{
            System.out.println("Вы вышли из игры");

        }
    }

    public static void randomWord() throws FileNotFoundException {//рандом слово из файла
        Random random = new Random();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/Words.txt"));
        List<String> list = new ArrayList<>();
        while (true) {
            try {
                if (!bufferedReader.ready()) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                list.add(bufferedReader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String secretWord = list.get(random.nextInt(list.size()));
        System.out.println("Слово загадано\n");
        getSecretWords(secretWord);

    }

    public static void getSecretWords(String word) {//не готово/
      String lockWord ="";
             lockWord= word.replaceAll("[а-яА-Я]", "_");

        for (int i = 0; i <word.length(); i++) {
            for (int j = 0; j < lockWord.length(); j++) {

            }
        }
        System.out.println("\tСлово : " + lockWord);

}






















    }

