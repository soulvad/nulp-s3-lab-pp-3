package battle;

import droids.Droid;
import utils.BattleLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BattleOneOnOne extends Battle {
    private Droid droid1;
    private Droid droid2;
    private int initialHealth1;
    private int initialHealth2;

    public BattleOneOnOne(Droid droid1, Droid droid2) {
        this.winnerName = new String[]{"Droid1","Droid2","Neither"};
        this.droid1 = droid1;
        this.droid2 = droid2;
        this.initialHealth1 = droid1.getCurrentHealth();
        this.initialHealth2 = droid2.getCurrentHealth();
    }

    public void startBattle() {
        printAndSaveMassage("Battle between " + droid1.getName() + " and " + droid2.getName());

        loopBattle();

        String winner = getWinnerName(droid1.isAlive(), droid2.isAlive());
        printAndSaveMassage(winner + " wins!");

        saveBattleLogs();

        resetDroids();
    }

    protected void loopBattle() {
        int round = 1;
        while (areDroidsAlive()) {

            printAndSaveMassage("Round " + round);

            List<String> notifications = simulateBattle(droid1, droid2);
            printNotifications(notifications);
            saveNotifications(notifications);

            if (areDroidsAlive()) {
                notifications = simulateBattle(droid2, droid1);
                printNotifications(notifications);
                saveNotifications(notifications);
            }
            round++;
        }
    }

    private List<String> simulateBattle(Droid attacker, Droid defender) {
        return attacker.attack(defender, attacker);
    }

    protected boolean areDroidsAlive() {
        return droid1.isAlive() && droid2.isAlive();
    }

    protected void resetDroids() {
        droid1.setCurrentHealth(initialHealth1);
        droid2.setCurrentHealth(initialHealth2);
        System.out.println(droid1.getName() + " and " + droid2.getName() + " have been restored to their initial health.");
    }
}
