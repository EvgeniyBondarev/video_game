import java.util.Random;

public abstract class Creature {
    private int attack;
    private int protection;
    private int health;
    private int damageMin;
    private int damageMax;
    protected Creature(int attack, int protection, int health, int damageMin, int damageMax){
        setAttack(attack);
        setProtection(protection);
        setHealth(health);
        setDamageMin(damageMin);
        setDamageMax(damageMax);
    }
    public abstract int hitHim(Creature creature);
    public int getProtection() {
        return protection;
    }

    public int getHealth() {
        return health;
    }

    public int getDamageMin() {
        return damageMin;
    }

    public int getDamageMax() {
        return damageMax;
    }

    public int getAttack() {
        return attack;
    }
    protected int hit (Creature creature) {
        int exit = 1;
        int damage = 0;
        boolean isHit = false;
        int healthCreature = creature.getHealth();
        int rolls = getAttack() - creature.getProtection() +  1;
        rolls = (rolls > 0) ? rolls : 1;
        Random random = new Random();
        for (;rolls > 0; rolls--){
            int r = random.nextInt(6) + 1;
            if (r > 4) {
                isHit = true;
                damage = random.nextInt(getDamageMax() - getDamageMin() + 1) + getDamageMin();
                if (healthCreature > damage)
                    creature.setHealth(healthCreature - damage);
                else {
                   exit = -1;
                }
                break;
            }
        }
        printBattle(creature, healthCreature, isHit, damage);
        return exit;
    }
    protected void setHealth(int health) {
        if (health > 0)
            this.health = health;
        else
            throw new IllegalArgumentException("The value of the health parameter must be greater than 0.");
    }
    private void printBattle (Creature creature, int healthCreature, boolean isHit, int damage) {
        String name = getClass().getName();
        String nameCreature = creature.getClass().getName();
        if (isHit) {
            System.out.printf("%s has dealt damage %s to %s.\n", name, damage, nameCreature);
            if (damage < healthCreature)
                System.out.println(nameCreature + " health " + healthCreature + ">" + creature.getHealth());
            else
                System.out.println(nameCreature + " is dead");
        }
        else
            System.out.println(name + " missed!");
    }
    private void setAttack(int attack) {
        if (attack > 0 & attack < 30)
            this.attack = attack;
        else
            throw new IllegalArgumentException("The value of the attack parameter should be in the range from 1 to 30.");
    }

    private void setProtection(int protection) {
        if (protection > 0 & protection < 30)
            this.protection = protection;
        else
            throw new IllegalArgumentException("The value of the protection parameter should be in the range from 1 to 30.");
    }

    private void setDamageMin(int damageMin) {
        if (damageMin > 0)
            this.damageMin = damageMin;
        else
            throw new IllegalArgumentException("The value of the minimum damage parameter must be greater than 0.");
    }

    private void setDamageMax(int damageMax) {
        if (damageMax > damageMin)
            this.damageMax = damageMax;
        else if (damageMax < 0)
            throw new IllegalArgumentException("The value of the maximum damage parameter must be greater than 0.");
        else
            throw new IllegalArgumentException("The value of the maximum damage parameter should be greater than the value of the minimum damage parameter.");
    }




}

