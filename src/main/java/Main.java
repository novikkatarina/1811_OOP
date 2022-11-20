import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Base> list = new ArrayList<>();
        // list.add(new Monk());
        // list.add(new Peasant());
        // list.add(new Robber());
        // list.add(new Sniper());
        // list.add(new Spearman());
        // list.add(new Wizard());
        // list.add(new Xbowman());
        get_hero (list);
        list.forEach(System.out::println);
        choose_hero (list, "Wizard");

    }
        static void get_hero (ArrayList<Base> list){
            Random random = new Random(); 
            for (int i = 0; i < 50; i++){
                int random_hero = random.nextInt(6);
            if (random_hero == 0) list.add(new Monk());
            if (random_hero == 1) list.add(new Peasant());
            if (random_hero == 2) list.add(new Robber());
            if (random_hero == 3) list.add(new Sniper());
            if (random_hero == 4) list.add(new Spearman());
            if (random_hero == 5) list.add(new Wizard());
            if (random_hero == 6) list.add(new Xbowman());
          }
        }
        static void choose_hero (ArrayList<Base> list, String name){
            for (int i = 0; i < 50; i++){
                if (list.get(i).getClass().getSimpleName() == name) System.out.println(list.get(i));
               
            }
        }


}
