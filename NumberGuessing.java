import java.util.Scanner;
import java.util.Random;

public class NumberGuessing {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    System.out.println("Welcome to the Number Guessing Game!");
    System.out.println("You have 10 attempts to guess the correct number between 1 and 100.");

    int correctNumber = random.nextInt(100) + 1;
    int remainingAttempts = 10;

    while (remainingAttempts > 0) {
      System.out.print("Enter your guess: ");
      int userGuess = scanner.nextInt();

      // Check if the user guess is too high, too low, or correct
      if (userGuess > correctNumber) {
        System.out.println("Too high! Try again.");
      } else if (userGuess < correctNumber) {
        System.out.println("Too low! Try again.");
      } else {
        System.out.println("Congratulations! You guessed the correct number!");
        calculateScore(remainingAttempts); 
        break; 
      }

      // Decrease remaining attempts and notify the user
      remainingAttempts--;
      if (remainingAttempts > 0) {
        System.out.println("You have " + remainingAttempts + " attempts left.");
      } else {
        System.out.println("Game over! The correct number was: " + correctNumber);
      }
    }

        scanner.close();
  }
    private static void calculateScore(int attemptsLeft) {
    int score = attemptsLeft*10;
    System.out.println("Your score: " + score + " out of 100.");
  }
}