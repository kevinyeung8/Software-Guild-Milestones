
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevinyeung
 */
public class App {
    
    private static String chosenNum = "";

	private static void printWelcomeMessage() {
		System.out.println("Welcome to the game of BULLS and COWS.");
		System.out.println("The objective in this game is for you to guess a 4-digit number.");
		System.out.println("The computer responds with how close your guess is to the target.");
		System.out.println("BULLS = # common digits with exact matches.");
		System.out.println("COWS = # common digits in wrong position.");
		System.out.println();
	}

	private static String produceRandomTarget() {
		int randomNumber = 1000 + ((int) (Math.random() * 10000) % 9000);
		chosenNum = Integer.toString(randomNumber);
		while (hasRepeatingDigits(chosenNum)) {
			produceRandomTarget();
		}
		return chosenNum;
	}

	private static boolean hasRepeatingDigits(String num) {
		for (int i = 0; i < num.length() - 1; i++) {
			for (int j = i + 1; j < num.length(); j++) {
				if (num.charAt(i) == num.charAt(j)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean containsNonDigits(String num) {
		if (!num.matches("^[0-9]+$")) {
			return true;
		}
		return false;
	}

	private static int computeBulls(String num1, String num2) {
		int bullCounter = 0;

		for (int i = 0; i < num1.length(); i++) {
			if (num1.charAt(i) == num2.charAt(i)) {
				bullCounter++;
			}
		}
		return bullCounter;
	}

	private static int computeCows(String num1, String num2) {
		int cowsCounter = 0;
		for (int i = 0; i < num1.length(); i++) {
			for (int j = 0; j < num2.length(); j++) {
				if (i != j) {
					if (num1.charAt(i) == num2.charAt(j)) {
						cowsCounter++;
					}
				}
			}
		}
		return cowsCounter;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		printWelcomeMessage();
		produceRandomTarget();

		int bulls = 0;
		int cows = 0;
		int guesses = 1;
		boolean notFound = true;

		while (notFound) {
			System.out.print("Enter guess number " + guesses + ": ");
			String guessedNumber = sc.nextLine();
			bulls = computeBulls(guessedNumber, chosenNum);
			cows = computeCows(guessedNumber, chosenNum);

			if (guesses >= 10) {
				System.out.println("Bulls = " + bulls + "\tCows = " + cows);
				System.out.println("Sorry! You ran out of guesses.");
				System.out.println("The correct number was: " + chosenNum);
				notFound = false;
			} else if (hasRepeatingDigits(guessedNumber)) {
				System.out.println("Your guess should not contain repeating digits.");
			} else if (guessedNumber.length() != 4) {
				System.out.println("Your guess should contain 4 symbols (Digits)");
			} else if (containsNonDigits(guessedNumber)) {
				System.out.println("Your guess should not contain non-digits.");
			} else if (bulls == 4) {
				System.out.println("Bulls = " + bulls + "\tCows = " + cows);
				System.out.println("Congratulations! You won with " + guesses + " guesses.");
				notFound = false;
			} else if (!hasRepeatingDigits(guessedNumber) && !containsNonDigits(guessedNumber)) {
				System.out.println("Bulls = " + bulls + "\tCows = " + cows);
				guesses++;
			}
		}
		sc.close();
	}
}
