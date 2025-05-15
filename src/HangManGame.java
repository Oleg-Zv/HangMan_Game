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
draw();

    }

    public static void startsGame() {//старт
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        if (start.equalsIgnoreCase("s")) {
            System.out.println("Игра начиналась!");
        } else {
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
        System.out.println(secretWord);
        getSecretWords(secretWord);

    }


    public  static  void  draw(){

    }









    public static void getSecretWords(String word) {//не готово/
        StringBuilder lockWord = new StringBuilder();
        List<String> list = new ArrayList<>();
        lockWord.append(word.replaceAll("[а-яА-Я]", "_"));
        int countError = 0;// для ошибок кол=во
        System.out.println("Введите букву: ");
        Scanner sc = new Scanner(System.in);
        String letter = "";

        while (!lockWord.toString().equalsIgnoreCase(word) && countError != 5) {
            letter = sc.nextLine();
            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                System.out.print("-");
                if (letter.equalsIgnoreCase(String.valueOf(word.charAt(i)))) {
                    found = true;
                    lockWord.setCharAt(i, letter.charAt(0));//заменяем символ
                }
            }
            if (!found) {
                list.add(letter);
                countError++;
            }

            System.out.println();
                System.out.println("\tСлово : " + lockWord + "\n\tОшибки: (" + countError + "):" + list + "\n\tБуква: " + letter );


        }
}

























    }

