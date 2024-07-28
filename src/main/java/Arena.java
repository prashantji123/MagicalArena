

public class Arena {
    private Player playerA;
    private Player playerB;

    public Arena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    protected Dice createDice() {
        return new Dice(6);
    }

    public void startBattle() {
        Dice attackDice = createDice();
        Dice defendDice = createDice();

        while (playerA.isAlive() && playerB.isAlive()) {
            Player attacker = playerA.getHealth() <= playerB.getHealth() ? playerA : playerB;
            Player defender = attacker == playerA ? playerB : playerA;

            int attackRoll = attackDice.roll();
            int defendRoll = defendDice.roll();

            int attackDamage = attacker.getAttack() * attackRoll;
            int defendStrength = defender.getStrength() * defendRoll;
            int damage = Math.max(attackDamage - defendStrength, 0);

            defender.reduceHealth(damage);

            if (!defender.isAlive()) break;

            // Swap roles
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
    }
}
