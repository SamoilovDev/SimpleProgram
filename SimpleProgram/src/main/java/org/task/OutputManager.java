package org.task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;

public class OutputManager extends InputManager {

    protected void finalOutput() {

        if (super.isFirstPath() && super.isSecondPath()) {

            System.out.println("Nums from input file added to the output file");
            fileOutput(super.outputFile);

        } else if (super.isSecondPath()) {

            System.out.println("Nums from console added to the output file");
            fileOutput(super.outputFile);

        } else if (super.isFirstPath()) {

            System.out.println("Nums from input file:");
            consoleOutput(System.out::println);

        } else {
            System.out.println("Result of program:");
            consoleOutput(System.out::println);
        }
    }

    private void consoleOutput(Consumer<? super Integer> action) {
        if (super.nums.size() % 2 == 0) {
            super.nums.stream()
                    .filter(x -> x % 2 == 0)
                    .forEach(action);
        } else {
            super.nums.stream()
                    .filter(x -> x % 2 != 0)
                    .forEach(action);
        }
    }

    private void fileOutput(File file) {
        try {
            FileWriter writer = new FileWriter(file);

            consoleOutput(x -> {
                try {
                    writer.write(x + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            writer.close();
        } catch (Exception e) {
            System.err.println("Can't write nums in output file!");
            e.printStackTrace();
        }

    }
}
