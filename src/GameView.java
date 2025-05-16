import java.util.ArrayList;
import java.util.List;

public class GameView {

    public void  playInfo(StringBuilder lockWord, List<String>errorsList, int countError,int tryCount, String letter) {
        System.out.println("\tСлово : " + lockWord);
        System.out.println("\tОшибки: (" + countError + "):" + errorsList);
        System.out.println("\tПопыток осталось: \"" + tryCount + "\"");
        System.out.println("\tБуква: " + letter);
    }

}

