package battle;

import droids.Droid;
import utils.BattleLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Battle {
    protected List<String> battleLog = new ArrayList<>();
    protected String[] winnerName;

    public abstract void startBattle();

    protected abstract void loopBattle();

    protected abstract boolean areDroidsAlive();

    protected String getWinnerName(boolean isFirstEntityAlive, boolean isSecondEntityAlive) {
        if (isFirstEntityAlive) {
            return winnerName[0];
        } else if (isSecondEntityAlive) {
            return winnerName[1];
        } else {
            return winnerName[2];
        }
    }

    protected void printAndSaveMassage(String massage) {
        System.out.println(massage);
        battleLog.add(massage);
    }

    protected void printNotifications(List<String> notifications) {
        for(String notification : notifications) {
            System.out.println(notification);
        }
    }

    protected void saveNotifications(List<String> notifications) {
        for(String notification : notifications) {
            battleLog.add(notification);
        }
    }

    protected void saveBattleLogs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name to save the battle:");
        String fileName = scanner.nextLine();

        BattleLogger.logBattle(fileName, battleLog);
    }

    protected abstract void resetDroids();
}
