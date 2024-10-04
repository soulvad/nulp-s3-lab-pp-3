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
        int damageDealt = this.damage;
        Random rand = new Random();
        String damageString = " damage!";
        if(rand.nextDouble() < this.critChance) {
            damageDealt *= 2;
            damageString = " critical damage!";
        }
        enemy.takeDamage(damageDealt);
        System.out.println(this.name + " attacks " + enemy.getName() + " for " + damageDealt + damageString + ", remaining health: " + enemy.getHealth());
    }
}