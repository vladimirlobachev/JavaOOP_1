import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;

public final class Slang {

    private Slang() {
        // stop
    }

    public static String fixAbbr(final Map<String, String> m, final String st) {
	    for (String key:m.keySet()) {
			if (st.contains(key)) {
				st = str.replace(key, m.get(key));
			}
		}
		return str;
	}

    public static String fixSmile(final Map<String, String> m, final String st) {
		for (String key:smiles.keySet()) {
			if (st.contains(key)) {
				st = st2.replace(key, m.get(key));
			}
		}
		return str;

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

		String res = fixAbbreviations(abbrs, getInput());
		res = fixAbbreviations(smiles, res);
		System.out.println(res);
	}
}
