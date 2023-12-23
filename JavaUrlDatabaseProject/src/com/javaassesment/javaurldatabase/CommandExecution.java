package com.javaassesment.javaurldatabase;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class CommandExecution {

	DataBaseStore baseStore;

	public void executeCommandLine(Scanner scanner) {
		while (true) {
			System.out.print("Please enter a command: ");
			String command = scanner.next().toLowerCase();
			CommandHandler commandHandler = commandHandlers.get(command);
			if (commandHandler != null) {
				commandHandler.accept(scanner);
			} else {
				System.out.println("Invalid command. Please enter a valid command and try again.");
				break;
			}
		}
	}

	interface CommandHandler extends Consumer<Scanner> {
	}

	private final Map<String, CommandHandler> commandHandlers = Map.of("storeurl",
			scanner -> baseStore.storeUrl(scanner.next()), "get",
			scanner -> System.out.println("Short Key: " + baseStore.getUrlShortKey(scanner.next())), "count",
			scanner -> System.out.println("Usage Count: " + baseStore.getUrlUsageCount(scanner.next())), "list",
			scanner -> baseStore.listUrls(), "exit", scanner -> {
				System.out
						.println("Exiting the program. Thank you for using our system. Have a great time, Goodbye!!!");
				System.exit(0);
			});
}
