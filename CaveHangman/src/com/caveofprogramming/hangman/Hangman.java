package com.caveofprogramming.hangman;

import java.util.Scanner;

public class Hangman {
	private RandomWord randomWord = new RandomWord();
	private int numOfGuesses = 5;
	private boolean running = true;
	Scanner sc = new Scanner(System.in);
	private char lastGuess;

	private void run() {

		do {
			displayWord();
			getUserInput();
			checkUserInput();
		} while (running);

	}

	private void checkUserInput() {
		// TODO implement this method
		boolean isHit = randomWord.addGuess(lastGuess);

		if (isHit) {
			if (randomWord.isComplete()) {
				System.out.println("Congratulations, you have guessed the right word! " + "\n" + randomWord);
				running = false;
			}
		} else {
			numOfGuesses--;
			if(numOfGuesses == 0) {
				System.out.println("You have lost!");
				running = false;
			}
		}
		
	}

	private void getUserInput() {
		sc = new Scanner(System.in);
		boolean isValid = false;
		String input = "";
		input = sc.nextLine();

		do {
			System.out.println("Guess a letter: ");

			if (input.length() == 1) {
				isValid = true;
			} else {
				System.out.println("Invalid input. Please enter just one letter");
				sc.nextLine();
			}
		} while (!isValid);

		lastGuess = input.charAt(0);

	}

	private void displayWord() {
		// TODO Auto-generated method stub
		System.out.println("You have " + numOfGuesses + " guesses left.");
		System.out.println(randomWord);
	}

	public static void main(String[] args) {
		Hangman hangman = new Hangman();
		hangman.run();
		hangman.close();
	}

	private void close() {
		// TODO Auto-generated method stub
		sc.close();
	}
}
