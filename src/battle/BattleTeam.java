package battle;

import droids.Droid;
import droids.HealerDroid;
import droids.WarriorDroid;
import utils.BattleLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BattleTeam {
    private List<Droid> team1;
    private List<Droid> team2;
    private List<String> battleLog = new ArrayList<>();
    private List<Integer> initialHealthTeam1 = new ArrayList<>();
    private List<Integer> initialHealthTeam2 = new ArrayList<>();
    private Random random = new Random();

    public BattleTeam(List<Droid> team1, List<Droid> team2) {
        this.team1 = team1;
        this.team2 = team2;

        for (Droid droid : team1) {
            initialHealthTeam1.add(droid.getHealth());
        }
        for (Droid droid : team2) {
            initialHealthTeam2.add(droid.getHealth());
        }
    }

    public void startTeamBattle() {
        battleLog.add("Battle between teams!");

        int round = 1;
        while (areAnyDroidsAlive(team1) && areAnyDroidsAlive(team2)) {
            battleLog.add("Round " + round);
            System.out.println("Round " + round);

            Droid attacker1 = getRandomAliveDroid(team1);
            Droid target2 = getRandomAliveDroid(team2);
            performAction(attacker1, team1, target2);

            if (areAnyDroidsAlive(team2)) {
                Droid attacker2 = getRandomAliveDroid(team2);
                Droid target1 = getRandomAliveDroid(team1);
                performAction(attacker2, team2, target1);
            }

            round++;
        }

        String winningTeam = areAnyDroidsAlive(team1) ? "Team 1" : "Team 2";
        battleLog.add(winningTeam + " wins!");
        System.out.println(winningTeam + " wins!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to save the battle:");
        String fileName = scanner.nextLine();

        BattleLogger.logBattle(fileName, battleLog);

        resetTeams();
    }

    private void performAction(Droid attacker, List<Droid> team, Droid target) {
        List<String> notifications = attacker.attack(target, getRandomAliveDroid(team));
        battleLog.add(notifications.get(0));
        battleLog.add(notifications.get(1));
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

    private boolean areAnyDroidsAlive(List<Droid> team) {
        for (Droid droid : team) {
            if (droid.isAlive()) {
                return true;
            }
        }
        return false;
    }

    private void resetTeams() {
        for (int i = 0; i < team1.size(); i++) {
            team1.get(i).setHealth(initialHealthTeam1.get(i));
        }
        for (int i = 0; i < team2.size(); i++) {
            team2.get(i).setHealth(initialHealthTeam2.get(i));
        }
        System.out.println("All droids from both teams have been restored to their initial health.");
    }

}
