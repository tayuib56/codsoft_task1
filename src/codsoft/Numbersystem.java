package codsoft;


import java.util.Random;
import java.util.Scanner;

public class Numbersystem {
	private static final int MAX_ATTEMPTS = 5;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;
    private static int roundsWon = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = generateRandomNumber(RANGE_MIN, RANGE_MAX);
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            System.out.println("Guess the number between " + RANGE_MIN + " and " + RANGE_MAX + ":");

            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < RANGE_MIN || userGuess > RANGE_MAX) {
                    System.out.println("Guess out of range. Please guess a number between " + RANGE_MIN + " and " + RANGE_MAX + ".");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                    attemptsLeft--;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high. Try again.");
                    attemptsLeft--;
                } else {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the correct number.");
                }

                if (!guessedCorrectly) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you're out of attempts. The correct number was " + numberToGuess + ".");
            } else {
                roundsWon++;
            }

            System.out.println("Current Score: Rounds Won = " + roundsWon);
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();

            if (response.equals("no")) {
                playAgain = false;
                System.out.println("Final Score: Rounds Won = " + roundsWon);
            }
        }

        scanner.close();
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

}
