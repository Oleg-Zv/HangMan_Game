import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomWord {
    private static final String PATH = "src/wordlist/Words.txt";

    public String randomWord() throws IOException {

        Random random = new Random();
        List<String> wordsList = new ArrayList<>();
        try
          (BufferedReader buffer = new BufferedReader(new FileReader(PATH))) {

            String line;
            while ((line = buffer.readLine()) != null) {
                wordsList.add(line);
            }
        } catch (FileNotFoundException e) {
           throw new IOException("Файл не найден! Проверьте путь");
        }
        if (wordsList.isEmpty()) {
            throw new IOException("Лист пуст, проверьте содержимое файла: " + PATH);
        }
        //System.out.println(secretWord);
        return wordsList.get(random.nextInt(wordsList.size()));
    }
}


