package battle;

import droids.Droid;
import utils.BattleLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BattleOneOnOne {
    private Droid droid1;
    private Droid droid2;
    private List<String> battleLog = new ArrayList<>();
    private int initialHealth1;
    private int initialHealth2;

    public BattleOneOnOne(Droid droid1, Droid droid2) {
        this.droid1 = droid1;
        this.droid2 = droid2;
        this.initialHealth1 = droid1.getHealth();
        this.initialHealth2 = droid2.getHealth();
    }

    public void startBattle() {
        battleLog.add("Battle between " + droid1.getName() + " and " + droid2.getName());
        int round = 1;

        battleLog.add("Round " + round);
        System.out.println("Round " + round);
        while (droid1.isAlive() && droid2.isAlive()) {
            droid1.attack(droid2);
            battleLog.add(droid1.getName() + " attacks " + droid2.getName() + ", remaining health: " + droid2.getHealth());
            if (droid2.isAlive()) {
                droid2.attack(droid1);
                battleLog.add(droid2.getName() + " attacks " + droid1.getName() + ", remaining health: " + droid1.getHealth());
            }
            round++;
        }

        String winner = droid1.isAlive() ? droid1.getName() : droid2.getName();
        battleLog.add(winner + " wins!");
        System.out.println(winner + " wins!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to save the battle:");
        String fileName = scanner.nextLine();

        BattleLogger.logBattle(fileName, battleLog);

        resetDroids();
    }

    private void resetDroids() {
        droid1.setHealth(initialHealth1);
        droid2.setHealth(initialHealth2);
        System.out.println(droid1.getName() + " and " + droid2.getName() + " have been restored to their initial health.");
    }
}
