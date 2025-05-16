
import java.util.List;
import java.util.Scanner;

public class GameView {

    public void showInfo() {
        System.out.println("\t\nДобро пожаловать в Виселицу!");
        System.out.println("\tВвведите \"С\"для Старта, иначе \"В\"для Выхода.");
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
      while (true){
          if(start.equalsIgnoreCase("С")){
              System.out.println("\tИгра начинается ^_^");
              break;
          } else if (start.equalsIgnoreCase("В")) {
              System.exit(0);
          }else {
              System.out.println("Неверный ввод! Повторите попытку");
             showInfo();
             break;
          }
      }
    }

    public void playInfo(StringBuilder lockWord, List<String> errorsList, int countError, int tryCount, String letter) {
        System.out.println("\tСлово : " + lockWord);
        System.out.println("\tОшибки: (" + countError + "):" + errorsList);
        System.out.println("\tПопыток осталось: \"" + tryCount + "\"");
        System.out.println("\tБуква: " + letter);
    }

    public void winAndOver(StringBuilder lockWord, String word, int countError) {

        if (lockWord.toString().equalsIgnoreCase(word)) {
            System.out.println("\n\tУра! Вы победили! ^_^");
        }
        if(countError>=6){
            System.out.printf("\nОй! Вы проиграли! -_-\n\tСлово было: %s", word);
        }

    }
}
