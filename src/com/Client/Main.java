package com.Client;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import com.House.Rooms;
//import com.house.Map;
import com.Util.*;


public class Main {

    private static ArrayList <Rooms>map;
    private Actor player; // Adding player to map

    public static void parseCommand(List<String> wordlist) {
        String verb;
        String noun;
        List<String> commands = new ArrayList<>(Arrays.asList("move", "take", "drop"));
        List<String> objects = new ArrayList<>(Arrays.asList("key", "book", "north", "south", "east", "west"));

        if (wordlist.size() != 2) {
            System.out.println("You can only enter two-word commands.");
        } else {
            verb = wordlist.get(0);
            noun = wordlist.get(1);
            if (!commands.contains(verb)) {
                System.out.println("I don't know how to " + verb + ".");
            }
            if (!objects.contains(noun)) {
                System.out.println("I don't know what a " + noun + " is.");
            }
        }
    }

    public static List<String> worldList(String input) {
        String delims = " \t,.:;?!\"'";
        List<String> strlist = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, delims);
        String t;

        while(tokenizer.hasMoreTokens()) {
            t = tokenizer.nextToken();
            strlist.add(t);
        }
        return strlist;
    }

    public static String runCommand(String inputstr) {
        List<String> wl;
        String s = "ok";
        String lowstr = inputstr.trim().toLowerCase();

        if (!lowstr.equals("q")) {
            if (lowstr.equals("")) {
                s = "You may enter a command";
            } else {
                wl = worldList(lowstr);
                wl.forEach((astr) -> System.out.println(astr));
                parseCommand(wl);
            }
        }
        return s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in;
        String input;
        String output;

        File file = new File("SplashScreen.txt");
        Scanner scan = new Scanner(file);

        map = new ArrayList<Rooms>();

        map.add(new Rooms("Entrance", "The place you entered", -1, 2, -2, 1));
        map.add(new Rooms("Kitchen", "Where you cook food", 1, 2, 0, -1));
        map.add(new Rooms("Library", "Books are stored here", -1, 1, 0, 1));
        map.add(new Rooms("Dining Room", "Where you eat the food", 0, -1, 0, 0));

//        player = new Actor("player", "This is me", map.get(0));

        in = new BufferedReader(new InputStreamReader(System.in));
        do {
            while(scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
            System.out.print("> ");
            input = in.readLine();
            output = runCommand(input);
            System.out.println("You entered '" + input + "'");
        }while (!"q".equals(input));

    }


}
