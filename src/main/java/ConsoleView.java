
//
//import Base;
//import Vector2;

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

        for (int i = 1; i <= Main.GANG_SIZE - 1; i++) {
            for (int j = 1; j <= Main.GANG_SIZE; j++) {
                System.out.print(getChar(new OOP.Vector2(i, j)));
            }
            System.out.println("|");
            System.out.println(ConsoleView.mid10);
        }

        for (int j = 1; j <= Main.GANG_SIZE; j++) {
            System.out.print(getChar(new OOP.Vector2(10, j)));
        }
        System.out.println("|");
        System.out.println(ConsoleView.bottom10);
    }

    private static String getChar(OOP.Vector2 position) {
        String str = "| ";
        for (int i = 0; i < Main.GANG_SIZE; i++) {
            if (Main.darkSide.get(i).getPosition().isEqual(position))
                str = "|" + AnsiColors.ANSI_GREEN + Main.darkSide.get(i).getName().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
            if (Main.whiteSide.get(i).getPosition().isEqual(position))
                str = "|" + AnsiColors.ANSI_BLUE + Main.whiteSide.get(i).getName().toUpperCase().charAt(0) + AnsiColors.ANSI_RESET;
        }
        return str;
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
