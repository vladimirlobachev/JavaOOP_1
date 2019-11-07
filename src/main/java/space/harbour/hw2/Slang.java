import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;

public class Slang {



	public static final String fixAbbreviations(Map<String, String> abbrs, String str) {
		for (String key:abbrs.keySet()) {
			if (str.contains(key)) {
				str = str.replace(key, abbrs.get(key));
			}
		}
		return str;
	}

	public static final String fixSmiles(Map<String, String> smiles, String str) {
		for (String key:smiles.keySet()) {
			if (str.contains(key)) {
				str = str.replace(key, smiles.get(key));
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
