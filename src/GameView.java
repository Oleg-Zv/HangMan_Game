
import java.util.Scanner;
import java.util.Set;

public class GameView {

    public void showInfo() {
       // System.out.println("\t\nДобро пожаловать в Виселицу!");
        System.out.println("\n\tВвведите \"С\"для Старта, иначе \"В\"для Выхода.");
        Scanner scanner = new Scanner(System.in);

      while (true){
          String start = scanner.nextLine();
          if(start.equalsIgnoreCase("С")){
              break;
          } else if (start.equalsIgnoreCase("В")) {
              System.exit(0);
          }else {
              System.out.println("Повторите попытку! Введите:");
              System.out.println("\t\"С\"для старта, иначе \"В\"для выхода.");
          }
      }
    }

    public void playInfo(StringBuilder lockWord, Set<String> enteredLetters, int countError, int tryCount, String letter) {
        System.out.println("\tСлово : " + lockWord);
        System.out.println("\tОшибки: (" + countError + "):" + enteredLetters);
        System.out.println("\tПопыток осталось: \"" + tryCount + "\"");
        System.out.println("\tБуква: " + letter);
    }

    public void winGameMessage(StringBuilder lockWord, String word) {

        if (lockWord.toString().equalsIgnoreCase(word)) {
            System.out.println("\n\tУра! Вы победили! ^_^");
        }
    }

public void overGameMessage(int countError,String word){
        if(countError>=6) {
            System.out.printf("\nОй! Вы проиграли! -_-\tСлово было: [%s", word + "]");
        }
    }

}
