
package csci2010.dotyprogram4;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

/**
 * CSCI 2010 Program Assignment 4
 * 
 * @author Jason Doty
 * 
 * 
 */
public class DotyProgram4 {

      // Assuming the maximum number of players is known or can be set to a reasonable limit
    private static final int MAX_PLAYERS = 128;
    private static final Player[] players = new Player[MAX_PLAYERS];

    public static void loadPlayers(String filename) throws IOException {
        Path file = Paths.get(filename);
        if (!Files.exists(file)) {
            throw new FileNotFoundException("The file " + filename + " was not found.");
        }
        
        List<String> lines = Files.readAllLines(file);
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            players[i] = new Player(parts[0].trim(), Integer.parseInt(parts[1].trim()), Integer.parseInt(parts[2].trim()), parts[3].trim());
        }
    }

    public static void displayMenu() {
        System.out.println("\nChoose one of the following options:");
        System.out.println("1. Find a player by name");
        System.out.println("2. Find all players from a country");
        System.out.println("3. Find the youngest player");
        System.out.println("4. Find the oldest player");
        System.out.println("5. Exit");
    }

    public static Player findPlayerByName(String name) throws NoSuchPlayerException {
        return Arrays.stream(players)
                .filter(Objects::nonNull)
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchPlayerException("There is no player named " + name));
    }

    public static Player[] findPlayersByCountry(String country) throws NoSuchPlayerException {
        Player[] playersFromCountry = Arrays.stream(players)
                .filter(Objects::nonNull)
                .filter(p -> p.getCountry().equalsIgnoreCase(country))
                .toArray(Player[]::new);
        if (playersFromCountry.length == 0) {
            throw new NoSuchPlayerException("There are no players from " + country);
        }
        return playersFromCountry;
    }

    public static Player findYoungestPlayer() throws NoSuchPlayerException {
        return Arrays.stream(players)
                .filter(Objects::nonNull)
                .min(Comparator.comparingInt(Player::getAge))
                .orElseThrow(() -> new NoSuchPlayerException("There are no players to compare."));
    }

    public static Player findOldestPlayer() throws NoSuchPlayerException {
        return Arrays.stream(players)
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(Player::getAge))
                .orElseThrow(() -> new NoSuchPlayerException("There are no players to compare."));
    }

    public static void main(String[] args) {
        try {
            loadPlayers("womenSinglesDraw.txt");
            System.out.println("Loading players from file\n");

            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                displayMenu();
                System.out.print("Enter choice: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("\nPlease enter the player's name: ");
                        String name = scanner.nextLine();
                        try {
                            Player player = findPlayerByName(name);
                            System.out.println(player);
                        } catch (NoSuchPlayerException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.print("\nPlease enter the country: ");
                        String country = scanner.nextLine();
                        try {
                            Player[] playersFromCountry = findPlayersByCountry(country);
                            for (Player p : playersFromCountry) {
                                System.out.println(p.getName());
                            }
                        } catch (NoSuchPlayerException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            Player youngest = findYoungestPlayer();
                            System.out.println(youngest);
                        } catch (NoSuchPlayerException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            Player oldest = findOldestPlayer();
                            System.out.println(oldest);
                        } catch (NoSuchPlayerException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        System.out.println("Program Exiting.");
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            } while (choice != 5);
        } catch (IOException e) {
            System.out.println("An error occurred while loading the players from the file.");
            e.printStackTrace();
        }
    }
}

