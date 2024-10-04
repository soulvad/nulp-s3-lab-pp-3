package droids;

import java.util.List;

public class HealerDroid extends Droid {
    private int healingPower;

    public HealerDroid(String name) {
        super(name, 80, 10, 5);
        this.healingPower = 15;
    }

    @Override
    public void attack(Droid enemy) {
        System.out.println(this.name + " attacks " + enemy.getName() + " for " + this.damage + " damage!" + ", remaining health: " + enemy.getHealth());
        enemy.takeDamage(this.damage);
    }

    //special ability of Healer
    public void heal(Droid enemy) {
        System.out.println(this.name + " attacks " + enemy.getName() + " for " + this.damage + " damage!" + ", remaining health: " + enemy.getHealth());
        enemy.takeHeal(this.healingPower);
    }
}
