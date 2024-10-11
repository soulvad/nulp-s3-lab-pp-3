package droids;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HealerDroid extends Droid {
    private int healingPower;

    public HealerDroid(String name) {
        super(name, 80, 10, 5);
        this.healingPower = 15;
    }

    @Override
    public List<String> attack(Droid enemy, Droid teammate) {
        Random rand = new Random();
        String notification, notification2;

        //special ability of Healer
        if(rand.nextBoolean()){
            notification2 = enemy.takeDamage(this);
            notification = this.name + " attacks " + enemy.getName() + " for " + this.damage + " damage!" + ", remaining health: " + enemy.getCurrentHealth();
        }
        else {
            enemy.takeHeal(this.healingPower);
            notification = this.name + " heals " + enemy.getName() + " for " + this.healingPower + " hp!" + ", remaining health: " + enemy.getCurrentHealth();
            notification2 = "";
        }

        List<String> notifications = new ArrayList<>();
        notifications.add(notification);
        notifications.add(notification2);

        return notifications;
    }
}
