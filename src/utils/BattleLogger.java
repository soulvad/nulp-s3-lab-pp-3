package utils;

import java.io.*;
import java.util.List;

public class BattleLogger {

    public static void logBattle(String fileName, List<String> battleLog) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String logEntry : battleLog) {
                writer.write(logEntry);
                writer.newLine();
            }
            System.out.println("Battle saved to file " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving the battle: " + e.getMessage());
        }
    }

    public static void replayBattle(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
