package droids;

import java.util.ArrayList;
import java.util.List;
import battle.*;
import utils.BattleLogger;

public class WarriorDroid extends Droid {
    private int reflectDamage;

    public WarriorDroid(String name) {
        super(name, 100, 15, 10);
        this.reflectDamage = 7;
    }

    public String takeDamage(Droid enemy) {
        super.takeDamage(enemy.damage);

        //special ability of Warrior
        String notification = this.name + " attacks " + enemy.getName() + " for " + reflectDamage + " reflected damage!" + ", remaining health: " + enemy.getHealth();
        System.out.println(notification);
        enemy.takeReflectDamage(this.reflectDamage);

        return notification;
    }

    @Override
    public List<String> attack(Droid enemy, Droid teammate) {
        String notification = this.name + " attacks " + enemy.getName() + " for " + damage + " damage!" + ", remaining health: " + enemy.getHealth();
        System.out.println(notification);
        String notification2 = enemy.takeDamage(this.damage);

        List<String> notifications = new ArrayList<>();
        notifications.add(notification);
        notifications.add(notification2);

        return notifications;
    }
}