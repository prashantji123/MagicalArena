

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void testPlayerCreation() {
        Player player = new Player(50, 5, 10);
        assertEquals(50, player.getHealth());
        assertEquals(5, player.getStrength());
        assertEquals(10, player.getAttack());
    }

    @Test
    public void testReduceHealth() {
        Player player = new Player(50, 5, 10);
        player.reduceHealth(10);
        assertEquals(40, player.getHealth());
        player.reduceHealth(50);
        assertEquals(0, player.getHealth());
    }

    @Test
    public void testReduceHealthToZero() {
        Player player = new Player(50, 5, 10);
        player.reduceHealth(60);
        assertEquals(0, player.getHealth());
    }

    @Test
    public void testIsAlive() {
        Player player = new Player(50, 5, 10);
        assertTrue(player.isAlive());
        player.reduceHealth(50);
        assertFalse(player.isAlive());
    }

    @Test
    public void testReduceHealthNegativeDamage() {
        Player player = new Player(50, 5, 10);
        player.reduceHealth(-10);
        assertEquals(50, player.getHealth());
    }

    @Test
    public void testReduceHealthEdgeCase() {
        Player player = new Player(1, 5, 10);
        player.reduceHealth(1);
        assertFalse(player.isAlive());
    }

    @Test
    public void testIsAliveAtZeroHealth() {
        Player player = new Player(0, 5, 10);
        assertFalse(player.isAlive());
    }

}
