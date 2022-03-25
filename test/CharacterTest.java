import com.players.Character;
import com.players.player.Commands;
import com.players.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class CharacterTest {
    Player c1 = new Player();
    Commands[] commands = Commands.values();


    @Test
    public void testPlayerName(){
        String result = c1.getName();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testSetName(){
        String result = c1.getName();
        Assert.assertEquals(null, result);
    }

    @Test
    public void testToString(){
        String result = c1.toString();
        Assert.assertEquals("Player: null", result);
    }


}
