import com.players.Character;
import com.players.npc.Animal;
import com.players.npc.Friend;
import com.players.player.Player;

public class Test {
    public static void main(String[] args) {
        Character aCat = new Animal("Sparky");
        System.out.println(aCat);



        Player p1 = new Player("Meri");
        p1.listCommands();

    }
}
