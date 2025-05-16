import java.util.Scanner;

public class HangmanDrawer {

    public void draw(int countError) {
        String[] hangman = {
                        "     *=========*  \n" +
                        "     |         |  \n" +
                        "               |  \n" +
                        "               |  \n" +
                        "               |  \n" +
                        "               |  \n" +
                        "    ==================",

                        "      *============**  \n" +
                        "      │            ||  \n" +
                        "      O            ||    \n" +
                        "                   ||  \n" +
                        "                   ||  \n" +
                        "                   ||  \n" +
                        "                   ||  \n" +
                        "    =========================",

                       "      *============**  \n" +
                       "      |            ||  \n" +
                       "      O            ||    \n" +
                       "      |            ||  \n" +
                       "                   ||  \n" +
                       "                   ||  \n" +
                       "                   ||  \n" +
                       "    =========================",

                        "      *============**  \n" +
                        "      │            ||  \n" +
                        "      O            ||  \n" +
                        "     /|            ||  \n" +
                        "                   ||  \n" +
                        "                   ||  \n" +
                        "                   ||  \n" +
                        "    =========================",

                        "      *============**  \n" +
                        "      │            ||  \n" +
                        "      O            ||  \n" +
                        "     /|\\           ||  \n" +
                        "                   ||  \n" +
                        "                   ||  \n" +
                        "                   ||  \n" +
                        "    =========================",

                         "      *============**  \n" +
                         "      │            ||  \n" +
                         "      O            ||  \n" +
                         "     /|\\           ||  \n" +
                         "     /             ||  \n" +
                         "                   ||  \n" +
                         "                   ||  \n" +
                         "    =========================",

                         "      *==============**  \n" +
                         "      │              ||  \n" +
                         "      O              ||  \n" +
                         "     /|\\             ||  \n" +
                         "     / \\             ||  \n" +
                         "                     ||  \n" +
                         "         _______     ||  \n" +
                         "        | _RIP_ |    ||  \n" +
                         "    ==============================",

        };

     switch (countError){
         case 1 -> System.out.println(hangman[1]);
         case 2 -> System.out.println(hangman[2]);
         case 3 -> System.out.println(hangman[3]);
         case 4 -> System.out.println(hangman[4]);
         case 5 -> System.out.println(hangman[5]);
         case 6 -> System.out.println(hangman[6] );
     }

    }

}
