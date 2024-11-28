/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen")); // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass)
				break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String string1 = preProcess(str1);
		String string2 = preProcess(str2);

		if (string1.length() != string2.length())
			return false;
		for (int i = 0; i < string1.length(); i++) {
			int detected = 0;
			for (int j = 0; j < string2.length(); j++) {
				if (string1.charAt(i) == string2.charAt(j)) {
					detected++;
					break;
				}
			}
			if (detected == 0) {
				return false;
			}
		}
		return true;
	}

	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted, except for spaces,
	// which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
		int i = 0;
		while (i < str.length() && str.charAt(i) != ' ') {
			i++;
		}
		String part1 = i < str.length() ? str.substring(0, i + 1) : str;
		String part2 = i + 1 < str.length() ? str.substring(i + 1).replaceAll("[^a-zA-Z]", "") : "";
		return part1 + part2;
	}

	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		String randomString = "";
		String value = str;

		for (int i = 0; i < str.length(); i++) {
			int index = (int) (Math.random() * (value.length() - 1));
			char ch = value.charAt(index);
			value = value.substring(0, index) + value.substring(index + 1);
			randomString += ch;
		}
		//last, return random string
		return randomString;
	}
}
