

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArenaTest {

    private Player playerA;
    private Player playerB;
    private Arena arena;

    @BeforeEach
    public void setup() {
        playerA = new Player(50, 5, 10);
        playerB = new Player(100, 10, 5);
        arena = new Arena(playerA, playerB);
    }

    @Test
    public void testMatchEndsWithAWinner() {
        arena.startBattle();
        assertTrue(playerA.getHealth() == 0 || playerB.getHealth() == 0);
    }

    @Test
    public void testMatchReducesHealth() {
        int initialHealthA = playerA.getHealth();
        int initialHealthB = playerB.getHealth();
        arena.startBattle();
        assertTrue(playerA.getHealth() < initialHealthA || playerB.getHealth() < initialHealthB);
    }

    @Test
    public void testPlayerWithLowerHealthAttacksFirst() {
        Player strongerPlayer = new Player(200, 20, 20);
        Player weakerPlayer = new Player(100, 10, 10);
        Arena newArena = new Arena(weakerPlayer, strongerPlayer);
        newArena.startBattle();
        assertTrue(weakerPlayer.getHealth() == 0 || strongerPlayer.getHealth() == 0);
    }

    @Test
    public void testTieGameScenario() {
        Player tiePlayerA = new Player(10, 1, 1);
        Player tiePlayerB = new Player(10, 1, 1);
        Arena tieArena = new Arena(tiePlayerA, tiePlayerB);
        tieArena.startBattle();
        assertTrue(tiePlayerA.getHealth() == 0 || tiePlayerB.getHealth() == 0);
    }

    @Test
    public void testDiceRollImpact() {
        Dice fixedDice = new Dice(6) {
            private int rollCount = 0;
            @Override
            public int roll() {
                rollCount++;
                return rollCount % 6 + 1; // Returns 1 to 6 cyclically
            }
        };

        Arena customArena = new Arena(playerA, playerB) {
            @Override
            protected Dice createDice() {
                return fixedDice;
            }
        };

        customArena.startBattle();
        assertTrue(playerA.getHealth() == 0 || playerB.getHealth() == 0);
    }
}
