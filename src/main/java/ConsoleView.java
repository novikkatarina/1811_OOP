
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ConsoleView {
    public static int step = 0;
    private static final String top10 = formatDiv("a") + String.join("",
            Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String mid10 = formatDiv("d") + String.join("",
            Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("",
            Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");

    public static void view() {
        if (step++ == 0) {
            System.out.println(AnsiColors.ANSI_RED + "First step!" + AnsiColors.ANSI_RESET);
        } else {
            System.out.println(AnsiColors.ANSI_RED + "Step: " + step + AnsiColors.ANSI_RESET);
        }

        System.out.println(ConsoleView.top10);
        String infoHeroWhiteTeam = "null";
        String infoHeroBlackTeam = "null";
        for (int i = 1; i <= Main.GANG_SIZE - 1; i++) {
            for (int j = 1; j <= Main.GANG_SIZE; j++) {
                System.out.print(getChar(new Vector2(i, j)));
                if (Main.whiteteam.get(i-1).getPosition().isEqual(new Vector2(i, j)))
                    infoHeroWhiteTeam = printwithspaces(AnsiColors.ANSI_BLUE + Main.whiteteam.get(i).toString()+ AnsiColors.ANSI_RESET);
                if (Main.blackteam.get(i-1).getPosition().isEqual(new Vector2(i, j)))
                    infoHeroBlackTeam = printwithspaces(AnsiColors.ANSI_GREEN + Main.blackteam.get(i).toString()+ AnsiColors.ANSI_RESET);
            }

            System.out.print("|");
            System.out.print(infoHeroWhiteTeam + "  "+  infoHeroBlackTeam);
            System.out.println();


            System.out.print(ConsoleView.mid10);

            System.out.println();
        }
        for (int j = 1; j <= Main.GANG_SIZE; j++) {
            System.out.print(getChar(new Vector2(10, j)));
            if (Main.whiteteam.get(9).getPosition().isEqual(new Vector2(10, j)))
                infoHeroWhiteTeam = printwithspaces(AnsiColors.ANSI_BLUE + Main.whiteteam.get(9).toString()+ AnsiColors.ANSI_RESET);
            if (Main.blackteam.get(9).getPosition().isEqual(new Vector2(10, j)))
                infoHeroBlackTeam = printwithspaces(AnsiColors.ANSI_GREEN + Main.blackteam.get(9).toString()+ AnsiColors.ANSI_RESET);

        }
        System.out.print("|");
        System.out.print("");
        System.out.println(infoHeroWhiteTeam + "  "+  infoHeroBlackTeam);
        System.out.println(ConsoleView.bottom10);
    }

    private static String getChar(Vector2 position) {
        String str = "| ";
        for (int i = 0; i < Main.GANG_SIZE; i++) {
            if (Main.blackteam.get(i).getPosition().isEqual(position))
                str = "|" + AnsiColors.ANSI_GREEN + Main.blackteam.get(i).getName().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
            if (Main.whiteteam.get(i).getPosition().isEqual(position))
                str = "|" + AnsiColors.ANSI_BLUE + Main.whiteteam.get(i).getName().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
        }
        return str;
    }


    public static String addspace (int s){
        String strspaces = "";
        for (int i = 1; i < s ; i++)
            strspaces = strspaces + " ";
        return strspaces;
    }
    public static String printwithspaces(String infohero) {

        if (infohero.length() < 93){
            int s = 93 - infohero.length();
            infohero = infohero + addspace(s);
        }
        return infohero;}



        private static String printInfo(Vector2 position, int i)
    {
        return "";
    }

    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500')
                .replace("s", "...")
                .replace("o", "___");
    }
}
