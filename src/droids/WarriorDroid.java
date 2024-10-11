package droids;

import java.util.ArrayList;
import java.util.List;

public class WarriorDroid extends Droid {
    private int reflectDamage;

    public WarriorDroid(String name) {
        super(name, 100, 15, 8);
        this.reflectDamage = 7;
    }

    public String takeDamage(Droid enemy) {
        super.takeDamage(enemy);

        //special ability of Warrior
        enemy.takeReflectDamage(this.reflectDamage);
        String notification = this.name + " attacks " + enemy.getName() + " for " + this.reflectDamage + " reflected damage!" + ", remaining health: " + enemy.getCurrentHealth();

        return notification;
    }

    @Override
    public List<String> attack(Droid enemy, Droid teammate) {
        String notification2 = enemy.takeDamage(this);
        String notification = this.name + " attacks " + enemy.getName() + " for " + this.damage + " damage!" + ", remaining health: " + enemy.getCurrentHealth();

        List<String> notifications = new ArrayList<>();
        notifications.add(notification);
        notifications.add(notification2);

        return notifications;
    }
}