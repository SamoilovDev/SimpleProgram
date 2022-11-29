package org.task;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Write a command and parameter(-s):");
        List<String> options = List.of(sc.nextLine().split(" "));

        if (options.get(0).trim()
                .equalsIgnoreCase("aplikace") && options.size() > 1) {

            OutputManager manager = new OutputManager();

            manager.addNumsToArray(options.get(1),
                    options.size() > 2 ? options.get(2) : "");

            manager.finalOutput();
        } else if (options.size() < 2) {
            System.out.println("You must write 'aplikace' command and 1 or 2 parameter(-s)");
        } else {
            System.out.println("Unknown command!");
        }
    }

}