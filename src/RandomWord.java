import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomWord {
    private static final String PATH = "src/Words.txt";


    public static String randomWord() throws IOException {//рандом слово из файла
        Random random = new Random();
        List<String> wordsList = new ArrayList<>();
        try
                (BufferedReader buffer = new BufferedReader(new FileReader(PATH))) {

            String line;
            while ((line = buffer.readLine()) != null) {
                wordsList.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (wordsList.isEmpty()) {
            throw new IOException("Лист пуст " + PATH);
        }

        String secretWord = wordsList.get(random.nextInt(wordsList.size()));
        System.out.println("Слово загадано\n");

        //System.out.println(secretWord);
        return secretWord;
    }
}


