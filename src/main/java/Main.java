import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static int GANG_SIZE = 10;
    public static ArrayList<Base> whiteteam = new ArrayList<Base>();
    public static ArrayList<Base> blackteam = new ArrayList<Base>();
    public static void main(String[] args) {

        FillWhiteTeam (whiteteam, GANG_SIZE);
        FillBlackTeam (blackteam, GANG_SIZE);
        ArrayList<Base> sortedWhiteTeam = new ArrayList<>();
        ArrayList<Base> sortedBlackTeam = new ArrayList<>();
        sortedWhiteTeam = Base.sortedTeam(whiteteam);
        sortedBlackTeam = Base.sortedTeam(blackteam);
//        whiteteam.forEach(System.out::println);
//        blackteam.forEach(System.out::println);
//        ConsoleView.view();





        while (true){
            Scanner scanner =  new Scanner(System.in);
            ConsoleView.view();
            scanner.nextLine();
            for (int i = 0; i < whiteteam.size(); i++){
                sortedWhiteTeam.get(i).step (blackteam, whiteteam);
                sortedBlackTeam.get(i).step (whiteteam, blackteam);
            }

        }


//        list.get(3).getdamage();
//        System.out.println("Damage");
//        System.out.println(list.get(3));
//        list.get(0).step(list);
//        System.out.println("Healled");
//        list.forEach(System.out::println);

    }

    static void FillWhiteTeam(ArrayList<Base> list, int GANG_SIZE) {
        int x=1;
        int y=1;
        Random random = new Random();
        for (int i = 0; i < GANG_SIZE; i++) {
            int random_hero = random.nextInt(4);
            if (random_hero == 0)
                list.add(new Peasant(x++, y));
            if (random_hero == 1)
                list.add(new Robber(x++, y));
            if (random_hero == 2)
                list.add(new Sniper(x++, y));
            if (random_hero == 3)
                list.add(new Wizard(x++, y));
        }}
    static void FillBlackTeam(ArrayList<Base> list, int GANG_SIZE)
        {
            int x=1;
            int y=10;
        Random random = new Random();
        for (int i = 0; i < GANG_SIZE; i++) {
            int random_hero = random.nextInt(4);
            if (random_hero == 0)
                list.add(new Peasant(x++, y));
            if (random_hero == 1)
                list.add(new Monk(x++,y));
            if (random_hero == 2)
                list.add(new Spearman(x++, y));
            if (random_hero == 3)
                list.add(new Xbowman(x++, y));
        }
    }


//    static void choose_hero(ArrayList<Base> list, String name) {
//        for (int i = 0; i < 10; i++) {
//            if (list.get(i).getClass().getSimpleName() == name)
//                System.out.println(list.get(i));

        }

