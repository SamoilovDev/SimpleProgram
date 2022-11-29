package org.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputManager {

    public List<Integer> nums = new ArrayList<>();

    protected File inputFile;

    protected File outputFile;

    private boolean isFirstPath = false;

    private boolean isSecondPath = false;

    public boolean isFirstPath() {
        return isFirstPath;
    }

    public boolean isSecondPath() {
        return isSecondPath;
    }

    public void addNumsToArray(String firstParameter, String secondParameter) {
        pathCheck(secondParameter);

        try {
            int number = Integer.parseInt(firstParameter);

            System.out.printf("Write %d num(-s):%n", number);
            for (int i = 0; i < number; i++) {
                this.nums.add(Main.sc.nextInt());
            }

        } catch (NumberFormatException e) {
            setNewInputFile(firstParameter);

            Main.sc.tokens()
                    .map(Integer::parseInt)
                    .forEach(x -> nums.add(x));
        }
    }

    public void setNewInputFile(String firstParameter) {
        inputFile = new File(firstParameter);

        try {
            Main.sc = new Scanner(inputFile);
            this.isFirstPath = true;
        } catch (FileNotFoundException e) {
            System.err.println("Wrong path to input file!");
            e.printStackTrace();
        }
    }

    public void pathCheck(String secondParameter) {

        if (! secondParameter.isBlank()) {
            try {
                this.outputFile = new File(secondParameter);
                boolean isCreated = this.outputFile.createNewFile();

                if (!isCreated) new FileOutputStream(this.outputFile.getPath()).close();

                isSecondPath = true;
            } catch (IOException ignored) {
            }
        }
    }

}
