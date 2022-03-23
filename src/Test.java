import com.players.Player;
import com.players.npc.Animal1;
import com.players.npc.Friend1;
import com.players.playable.PrimaryPlayer;

public class Test {
    public static void main(String[] args) {
        Player f1 = new Friend1("Hector");
        System.out.println(f1);
        f1.doAction();
        f1.move();
        f1.talk();
        f1.think();

        System.out.println("*****");

        Player a1 = new Animal1("Spot");
        System.out.println(a1);
        a1.doAction();
        a1.move();
        a1.talk();
        a1.think();

        System.out.println("*****");


        Player p1 = new PrimaryPlayer("Josh");
        System.out.println(p1);
        p1.doAction();
        p1.move();
        p1.talk();
        p1.think();

    }
}
