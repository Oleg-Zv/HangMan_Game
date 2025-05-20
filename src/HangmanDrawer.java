
public class HangmanDrawer {

    public void draw(int countError) {
        String[] hangman = {
                """
     *=========* \s
     |         | \s
               | \s
               | \s
               | \s
               | \s
    ==================\
""",

                """
      *============** \s
      │            || \s
      o            ||   \s
                   || \s
                   || \s
                   || \s
                   || \s
    =========================\
""",

                """
      *============** \s
      |            || \s
      o            ||   \s
      |            || \s
                   || \s
                   || \s
                   || \s
    =========================\
""",

                """
      *============** \s
      │            || \s
      o            || \s
     /|            || \s
                   || \s
                   || \s
                   || \s
    =========================\
""",

                """
      *============** \s
      │            || \s
      o            || \s
     /|\\           || \s
                   || \s
                   || \s
                   || \s
    =========================\
""",

                """
      *============** \s
      │            || \s
      o            || \s
     /|\\           || \s
     /             || \s
                   || \s
                   || \s
    =========================\
""",

                """
      *==============** \s
      │              || \s
      o              || \s
     /|\\             || \s
     / \\             || \s
                     || \s
         _______     || \s
        | _RIP_ |    || \s
    ==============================\
""",

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
