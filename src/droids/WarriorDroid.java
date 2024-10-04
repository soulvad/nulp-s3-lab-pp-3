package droids;

import java.util.List;
import battle.*;

public class WarriorDroid extends Droid {
    private int reflectDamage;

    public WarriorDroid(String name) {
        super(name, 100, 15, 10);
        this.reflectDamage = 7;
    }

    @Override
    public void attack(Droid enemy) {
        System.out.println(this.name + " attacks " + enemy.getName() + " for " + damage + " damage!" + ", remaining health: " + enemy.getHealth());
        enemy.takeDamage(this.damage);
    }

    //special ability of Warrior
    public void reflectAttack(Droid enemy) {
        System.out.println(this.name + " attacks " + enemy.getName() + " for " + reflectDamage + " reflected damage!" + ", remaining health: " + enemy.getHealth());
        enemy.takeReflectDamage(this.reflectDamage);
    }
}