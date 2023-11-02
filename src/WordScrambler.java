import java.util.Scanner;

public class WordScrambler {
	/*
	 * Output every possible combination of a word. Each recursive call moves a
	 * letter from remainLetters" to scramLetters".
	 */
	public static void scrambleLetters(String remainLetters, // Remaining letters (J.O.: another name
																// extendPartialOrdering
			String scramLetters) { // Scrambled letters

		if (remainLetters.length() == 0) {
			System.out.println(scramLetters);
		}

		for (int s = 0; s < remainLetters.length(); s++) {

			String extensionLetter = remainLetters.substring(s, s + 1);
			remainLetters = removeFromIndex(remainLetters, s);
			scramLetters = scramLetters + extensionLetter;

			scrambleLetters(remainLetters, scramLetters);

			remainLetters = insertAtIndex(remainLetters, extensionLetter, s);
			scramLetters = removeFromIndex(scramLetters, scramLetters.length() - 1);
		}
	}

	// Returns a new String without the character at location remLoc
	public static String removeFromIndex(String origStr, int remLoc) {
		String finalStr; // Temp string to extract char

		finalStr = origStr.substring(0, remLoc); // Copy before location remLoc
		finalStr += origStr.substring(remLoc + 1, origStr.length()); // Copy after location remLoc

		return finalStr;
	}

	// Returns a new String with the character specified by insertStr
	// inserted at location addLoc
	public static String insertAtIndex(String origStr, String insertStr, int addLoc) {
		String finalStr; // Temp string to extract char

		finalStr = origStr.substring(0, addLoc); // Copy before location addLoc
		finalStr += insertStr; // Copy character to location addLoc
		finalStr += origStr.substring(addLoc, origStr.length()); // Copy after location addLoc

		return finalStr;
	}

	public static void main(String[] args) {

		Scanner myScan = new Scanner(System.in);

		System.out.println("Enter the word to generate permutations for:");
		String word = myScan.next();

		scrambleLetters(word, "");
	}
}