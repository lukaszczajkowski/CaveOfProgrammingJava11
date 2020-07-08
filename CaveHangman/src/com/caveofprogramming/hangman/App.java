package com.caveofprogramming.hangman;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb1 = new StringBuilder();
		
		sb1.append("I ");
		sb1.append("am ");
		sb1.append("a ");
		sb1.append("herring ");
		
		String result1 = sb1.toString();
		System.out.println(result1);
		
		StringBuilder sb2 = new StringBuilder("I ");
		sb2.append("am ").append("a ").append("ferret");
		
		String result2 = sb2.toString();
		System.out.println(result2);
	}

}
