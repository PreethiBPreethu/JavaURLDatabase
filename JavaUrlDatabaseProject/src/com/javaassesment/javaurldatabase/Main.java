package com.javaassesment.javaurldatabase;

import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	public static HashMap<String, UrlTablePojo> table = new HashMap<>();
	public static int uniqueCount = 1;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		initalInstructionsForUser();
	}

	private static void initalInstructionsForUser() {
		System.out.println("Hey!!!!!. Welcome to Java URL database world.....!!!!!");
		System.out.println("We have some commands for you...!!:");

		IntStream.rangeClosed(0, 5).mapToObj(i -> generateInstruction(i)).forEach(System.out::println);

		CommandExecution commandExecution = new CommandExecution();
		commandExecution.executeCommandLine(scanner);
	}

	private static String generateInstruction(int commandNumber) {
		return switch (commandNumber) {
		case 0 -> "";
		case 1 -> "1. storeurl <Enter URL>";
		case 2 -> "2. get <Enter URL>";
		case 3 -> "3. count <Enter URL>";
		case 4 -> "4. list";
		case 5 -> "5. exit";
		default -> "";
		};
	}

}
