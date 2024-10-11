package droids;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AssassinDroid extends Droid {
    private double critChance;
    private int defaultDamage;

    public AssassinDroid(String name) {
        super(name, 90, 25, 0);
        this.critChance = 0.2;
        this.defaultDamage = this.damage;
    }

    @Override
    public List<String> attack(Droid enemy, Droid teammate) {
        this.damage = calculateCriticalDamage();
        String damageString;
        if(this.defaultDamage == this.damage) {
            damageString = " damage!";
        } else {
            damageString = " critical damage!";
        }

        String notification2 = enemy.takeDamage(this);
        String notification = this.name + " attacks " + enemy.getName() + " for " + this.damage + damageString + ", remaining health: " + enemy.getCurrentHealth();

        this.damage = this.defaultDamage;

        List<String> notifications = new ArrayList<>();
        notifications.add(notification);
        notifications.add(notification2);

        return notifications;
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