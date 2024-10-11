import droids.*;
import battle.*;
import utils.BattleLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DroidBattleGame {
    private static List<Droid> droids = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Create a droid");
            System.out.println("2. Show list of droids");
            System.out.println("3. Start 1v1 battle");
            System.out.println("4. Start team vs team battle");
            System.out.println("5. Load and replay a battle from file");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createDroid(scanner);
                    break;
                case 2:
                    listDroids();
                    break;
                case 3:
                    startOneOnOneBattle(scanner);
                    break;
                case 4:
                    startTeamBattle(scanner);
                    break;
                case 5:
                    replayBattle(scanner);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void createDroid(Scanner scanner) {
        System.out.println("Select droid type: 1 - Warrior, 2 - Healer, 3 - Assassin");
        int type = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter droid name:");
        String name = scanner.nextLine();

        switch (type) {
            case 1:
                droids.add(new WarriorDroid(name));
                break;
            case 2:
                droids.add(new HealerDroid(name));
                break;
            case 3:
                droids.add(new AssassinDroid(name));
                break;
            default:
                System.out.println("Invalid type");
        }
    }

    private static void listDroids() {
        if (droids.isEmpty()) {
            System.out.println("No droids have been created.");
            return;
        }
        int i = 1;
        for (Droid droid : droids) {
            System.out.println(i + ") " + droid.getName() + " - " + droid.getClass().getSimpleName());
            i++;
        }

    }

    private static void startOneOnOneBattle(Scanner scanner) {
        if (droids.size() < 2) {
            System.out.println("Not enough droids for a battle.");
            return;
        }
        System.out.println("Select two droids for 1v1 battle:");
        listDroids();
        int droid1Index = scanner.nextInt() - 1;
        int droid2Index = scanner.nextInt() - 1;

        Droid droid1Copy = droids.get(droid1Index);
        Droid droid2Copy = droids.get(droid2Index);

        BattleOneOnOne battle = new BattleOneOnOne(droids.get(droid1Index), droids.get(droid2Index));
        battle.startBattle();
    }

    private static void startTeamBattle(Scanner scanner) {
        if (droids.size() < 6) {
            System.out.println("Not enough droids for a team battle.");
            return;
        }

        List<Droid> team1 = new ArrayList<>();
        List<Droid> team2 = new ArrayList<>();

        System.out.println("Select droids for team 1:");
        listDroids();
        for (int i = 0; i < 3; i++) {
            int index = scanner.nextInt() - 1;
            team1.add(droids.get(index));
        }

        System.out.println("Select droids for team 2:");
        listDroids();
        for (int i = 0; i < 3; i++) {
            int index = scanner.nextInt() - 1;
            team2.add(droids.get(index));
        }

        BattleTeam battle = new BattleTeam(team1, team2);
        battle.startBattle();
    }

    private static void replayBattle(Scanner scanner) {
        System.out.println("Enter the file name to replay the battle:");
        scanner.nextLine();
        String fileName = scanner.nextLine();

        System.out.println("Replaying the battle from file '" + fileName + "':");
        BattleLogger.replayBattle(fileName);
    }
}
