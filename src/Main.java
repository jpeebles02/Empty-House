import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;


public class Main {

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

        in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("> ");
            input = in.readLine();
            output = runCommand(input);
            System.out.println("You entered '" + input + "'");
        }while (!"q".equals(input));

    }


}
