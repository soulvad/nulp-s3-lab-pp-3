package battle;

import droids.Droid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleTeam extends Battle {
    private List<Droid> team1;
    private List<Droid> team2;
    private List<Integer> initialHealthTeam1 = new ArrayList<>();
    private List<Integer> initialHealthTeam2 = new ArrayList<>();
    private Random random = new Random();

    public BattleTeam(List<Droid> team1, List<Droid> team2) {
        this.winnerName = new String[]{"Team1","Team2","Neither"};
        this.team1 = team1;
        this.team2 = team2;

        for (Droid droid : team1) {
            initialHealthTeam1.add(droid.getCurrentHealth());
        }
        for (Droid droid : team2) {
            initialHealthTeam2.add(droid.getCurrentHealth());
        }
    }

    public void startBattle() {
        printAndSaveMassage("Battle between teams!");

        loopBattle();

        String winningTeam = getWinnerName(areAnyDroidsAlive(team1), areAnyDroidsAlive(team2));
        printAndSaveMassage(winningTeam + " is a winner!");

        saveBattleLogs();

        resetDroids();
    }

    protected void loopBattle() {
        int round = 1;
        while (areDroidsAlive()) {

            printAndSaveMassage("Round " + round);

            List<String> notifications = simulateBattle(team1, team2);
            printNotifications(notifications);
            saveNotifications(notifications);

            if (areDroidsAlive()) {
                notifications = simulateBattle(team2, team1);
                printNotifications(notifications);
                saveNotifications(notifications);
            } else {
                break;
            }

            round++;
        }
    }

    private List<String> simulateBattle(List<Droid> team1, List<Droid> team2) {
        Droid attacker = getRandomAliveDroid(team1);
        Droid target = getRandomAliveDroid(team2);
        return attacker.attack(target, getRandomAliveDroid(team1));
    }

    private Droid getRandomAliveDroid(List<Droid> team) {
        List<Droid> aliveDroids = new ArrayList<>();
        for (Droid droid : team) {
            if (droid.isAlive()) {
                aliveDroids.add(droid);
            }
        }
        return aliveDroids.get(random.nextInt(aliveDroids.size()));
    }

    protected boolean areDroidsAlive() {
        return areAnyDroidsAlive(team1) && areAnyDroidsAlive(team2);
    }

    private boolean areAnyDroidsAlive(List<Droid> team) {
        for (Droid droid : team) {
            if (droid.isAlive()) {
                return true;
            }
        }
        return false;
    }

    protected void resetDroids() {
        for (int i = 0; i < team1.size(); i++) {
            team1.get(i).setCurrentHealth(initialHealthTeam1.get(i));
        }
        for (int i = 0; i < team2.size(); i++) {
            team2.get(i).setCurrentHealth(initialHealthTeam2.get(i));
        }
        System.out.println("All droids from both teams have been restored to their initial health.");
    }

}