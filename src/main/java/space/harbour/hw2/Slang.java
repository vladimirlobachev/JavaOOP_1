import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;

public final class Slang {

    private Slang() {
        // stop
    }

    public static String fixAbbr(final Map<String, String> m, final String s) {
        for (String key:m.keySet()) {
            if (s.contains(key)) {
                s = s.replace(key, m.get(key));
            }
        }
        return s;
    }

    public static String fixSmile(final Map<String, String> m, final String s) {
        // look I made the above line exactly 80 characters. Code looks much
        // more convenient with those argument names. doesnt it.
        for (String key:m.keySet()) {
            if (s.contains(key)) {
                s = s.replace(key, m.get(key));
            }
        }
        return s;

    }

    public static String getInput() {
        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter your phrase");
            String input = keyboard.nextLine();
            return input;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {

        HashMap<String, String> abbrs = new HashMap<>();
        HashMap<String, String> smiles = new HashMap<>();

        abbrs.put("PLZ", "please");
        abbrs.put("FYI", "for your information");
        abbrs.put("GTFO", "please, leave me alone");
        abbrs.put("ASAP", "as soon as possible");

        smiles.put(":)", "smiling");
        smiles.put(":(", "sad");
        smiles.put("¯\\_(ツ)_/¯", "such is life ");

        String res = fixAbbr(abbrs, getInput());
        res = fixSmile(smiles, res);
        System.out.println(res);
    }
}
