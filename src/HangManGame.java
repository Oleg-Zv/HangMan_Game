import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class HangManGame {
    public static void main(String[] args) {

    }


    public static  void showInfo(){
        System.out.println("Добро пожаловать в Висилицу!");
        System.out.println("Ввведите \"s\"-tart  для начала игры,иначе \"e\"-xit для выхода.");

      }

    public static boolean startsGame() {//старт
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
       return start.equalsIgnoreCase("s");

      }
    }

