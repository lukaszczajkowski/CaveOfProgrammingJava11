package com.caveofprogramming.hangman;

import java.util.*;
import java.util.Random;

public class RandomWord {
	private String[] words = {"possum" };
	private Random random = new Random();
	private String word;
	private char[] characters;
	private ArrayList<Character> guessedCharacters;

	public RandomWord() {
		word = words[random.nextInt(words.length)];
		characters = new char[word.length()];
		guessedCharacters = new ArrayList<>();
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < characters.length; i++) {
			char letter = characters[i];
			sb.append(letter == '\u0000' ? '_' : letter);
			sb.append(' ');
		}
		String text = sb.toString();
		return text;
	}
	

	public boolean addGuess(char letter) {
		// TODO Auto-generated method stub
		boolean isCorrect = false;
		for (int i = 0; i < word.length(); i++) {
			if (letter == word.charAt(i) && !guessedCharacters.contains(letter)) {
				characters[i] = letter;
				isCorrect = true;
			}
		}
		guessedCharacters.add(letter);
		return isCorrect;
	}

	public boolean isComplete() {
		for (int i = 0; i < characters.length; i++) {
			char letter = characters[i];
			if (letter != this.word.charAt(i)) {
				return false;
			}
		}
		return true;

	}
}
