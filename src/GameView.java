
import java.util.List;
import java.util.Scanner;

public class GameView {

    public boolean showInfo() {
        System.out.println("\t\nДобро пожаловать в Виселицу!");
        System.out.println("\tВвведите \"С\"-тарт  для начала игры,иначе \"В\"-ыход.");
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        return start.equalsIgnoreCase("С");
    }


    public void playInfo(StringBuilder lockWord, List<String> errorsList, int countError, int tryCount, String letter) {
        System.out.println("\tСлово : " + lockWord);
        System.out.println("\tОшибки: (" + countError + "):" + errorsList);
        System.out.println("\tПопыток осталось: \"" + tryCount + "\"");
        System.out.println("\tБуква: " + letter);
    }

    public void getWinAndOver(StringBuilder lockWord, String word, int countError) {

        if (lockWord.toString().equalsIgnoreCase(word)) {
            System.out.println("\n\tУра! Вы победили!");
        }
        if(countError>=6){
            System.out.println("\nУвы, но Вы проигали!\n\tСлово было: " + "<" + word + ">");
        }

    }
}
