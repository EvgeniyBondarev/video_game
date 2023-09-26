public class Player extends Creature {
    private int cure = 4;
    private int maxHealth;

    Player(int attack, int protection, int health, int damageMin, int damageMax) {
        super(attack, protection, health, damageMin, damageMax);
        maxHealth = health;
    }

    @Override
    public int hitHim(Creature creature) {
        cure();
        return hit(creature);
    }

    private void cure() {
        if (cure > 0) {
            int currentHealth = getHealth();
            if (currentHealth < maxHealth * 0.7) {
                setHealth((int) (currentHealth + maxHealth * 0.3));
                cure--;
                System.out.printf("The player was cured by %s points. There are %s cures left.\n", (int) (maxHealth * 0.3), cure);
            }
        }
    }
}
