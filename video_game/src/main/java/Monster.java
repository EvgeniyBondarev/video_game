public class Monster extends Creature {
    Monster(int attack, int protection, int health, int damageMin, int damageMax) {
        super(attack, protection, health, damageMin, damageMax);
    }

    @Override
    public int hitHim(Creature creature) {
        return hit(creature);
    }
}
