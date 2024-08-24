package BasicPrg;
import java.util.Random;
import java.util.Scanner;

public class Number_Game {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		boolean playagain = true;
		int score = 0;

		System.out.println("Welcome to the guess the number game!");
		System.out.println("You have 3 chances to win. Try to guess a number between 1 and 100.");

		while (playagain) {
			int generatedNo = random.nextInt(100) + 1;
			int numberOfTries = 0;
			boolean win = false;

			while (numberOfTries < 3) {
				System.out.print("Enter your guess : ");
				if (scanner.hasNextInt()) {
					int guess = scanner.nextInt();
					numberOfTries++;

					if (guess < 1 || guess > 100) {
						System.out.println("Invalid input!");
					} else if (guess < generatedNo) {
						System.out.println("Too low! Try again.");
					} else if (guess > generatedNo) {
						System.out.println("Too high! Try again.");
					} else {
						win = true;
						score++;
						System.out.println("Congratulations! You guessed the number in " + numberOfTries + " tries.");
						break;
					}
				} else {
					System.out.println("Invalid input! Please enter a valid number.");
					scanner.next();
				}
			}

			if (!win) {
				System.out.println("Sorry! You lost the Game . The correct number was: " + generatedNo);
			}

			System.out.println("Your current score: " + score);
			System.out.print("Do you want to play again? (yes/no): ");
			String playagainInput = scanner.next().toLowerCase();
			scanner.nextLine();

			if (!playagainInput.equals("yes")) {
				playagain = false;
			}
		}

		System.out.println("Thanks for playing!");
		scanner.close();
	}
}