import java.util.ArrayList;
import java.util.List;

public class GameView {

    public void  playInfo(StringBuilder lockWord, List<String>errorsList, int countError, String letter) {
        System.out.println("\tСлово : " + lockWord);
        System.out.println("\tОшибки: (" + countError + "):" + errorsList);
        System.out.println("\tБуква: " + letter);
    }

}

