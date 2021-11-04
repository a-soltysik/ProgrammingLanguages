package com.github.a_soltysik;

import java.util.Scanner;

public class Console {
    private static final String ERROR_MESSAGE =
            """
                    Nieprawidłowe dane!
                    Spróbuj ponownie.
                    """;
    private final Scanner in = new Scanner(System.in);

    public void printLine(String line) {
        System.out.println(line);
    }

    public void print(String line) {
        System.out.print(line);
    }

    public void printError(String error) {
        System.err.println(error);
    }

    public String requestString(String message) {
        print(message);
        return in.nextLine();
    }

    public int requestInt(String message) {
        print(message);
        while (true) {
            try {
                return Integer.parseInt(requestString(message));
            } catch (NumberFormatException e) {
                printLine(ERROR_MESSAGE);
            }
        }
    }
}
