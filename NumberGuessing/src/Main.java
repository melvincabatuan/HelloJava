import java.util.Random;
import java.util.Scanner;

public class Main {

	public static int number, guess, maxValue;
	public static Scanner keyboard;
	public static Random rand;

	public static void main(String[] args) {

		keyboard = new Scanner(System.in);
		rand = new Random();
		System.out.println("Please set the maximum value:");
		maxValue = keyboard.nextInt();
		number = rand.nextInt(maxValue + 1);
		System.out
				.println("Please input your guess: (1 to " + maxValue + ") ");

		while (guess != number) {
			guess = keyboard.nextInt();
			if (guess < number)
				System.out.println("Your guess is too low! ");
			if (guess > number)
				System.out.println("Your guess is too high! ");
		}
		System.out.println("Your win! ");
	}
}
