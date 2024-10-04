package droids;

import java.util.Random;

public class AssassinDroid extends Droid {
    private double critChance;

    public AssassinDroid(String name) {
        super(name, 90, 25, 0);
        this.critChance = 0.2;
    }

    @Override
    public void attack(Droid enemy) {
        int damageDealt = calculateCriticalDamage();
        String damageString;
        if(damageDealt == this.damage) {
            damageString = " damage!";
        } else {
            damageString = " critical damage!";
        }
        enemy.takeDamage(damageDealt);
        System.out.println(this.name + " attacks " + enemy.getName() + " for " + damageDealt + damageString + ", remaining health: " + enemy.getHealth());
    }

    //special ability of Assassin
    public int calculateCriticalDamage() {
        Random rand = new Random();
        if(rand.nextDouble() < this.critChance) {
            return this.damage * 2;
        } else {
            return this.damage;
        }
    }
}