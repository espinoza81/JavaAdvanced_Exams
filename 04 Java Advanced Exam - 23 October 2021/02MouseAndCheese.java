package Exams;

import java.util.Arrays;
import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int rowMatrix = Integer.parseInt(console.nextLine());
        char[][] matrix = new char[rowMatrix][rowMatrix];
        int[] curMousePosition = new int[2];

        for (int i = 0; i < rowMatrix; i++) {
            String input = console.nextLine();
            for (int j = 0; j < input.length(); j++) {
                matrix[i][j] = input.charAt(j);
                if (input.charAt(j) == 'M') {
                    curMousePosition[0] = i;
                    curMousePosition[1] = j;
                }
            }
        }

        String command;
        int[] mouseIsOut = new int[1];
        int eatenCheese = 0;
        while (!"end".equals(command = console.nextLine())) {
            matrix[curMousePosition[0]][curMousePosition[1]] = '-';
            move(command, curMousePosition, rowMatrix, mouseIsOut);
            if (matrix[curMousePosition[0]][curMousePosition[1]] == 'B') {
                matrix[curMousePosition[0]][curMousePosition[1]] = '-';
                move(command, curMousePosition, rowMatrix, mouseIsOut);
            }
            if (mouseIsOut[0] == 1) {
                break;
            }
            if (matrix[curMousePosition[0]][curMousePosition[1]] == 'c') {
                eatenCheese++;
            }
            matrix[curMousePosition[0]][curMousePosition[1]] = 'M';
        }
        if (mouseIsOut[0] == 1) {
            System.out.println("Where is the mouse?");
        }
        if(eatenCheese < 5) {
            System.out.println("The mouse couldn't eat the cheeses, she needed " +  (5-eatenCheese) + " cheeses more.");
        } else {
            System.out.println("Great job, the mouse is fed " + eatenCheese + " cheeses!");
        }
        Arrays.stream(matrix).map(String::valueOf).forEach(System.out::println);
    }

    public static boolean mouseInTheMatrix(int row, int col, int rowMatrix) {
        return row >= 0 && row < rowMatrix && col >= 0 && col < rowMatrix;
    }

    public static void move(String command, int[] curMousePosition, int rowMatrix, int[] mouseIsOut){
        switch (command) {
            case "up":
                if (mouseInTheMatrix(curMousePosition[0] - 1, curMousePosition[1], rowMatrix)) {
                    curMousePosition[0]--;
                } else {
                    mouseIsOut[0] = 1;
                }
                break;
            case "down":
                if (mouseInTheMatrix(curMousePosition[0] + 1, curMousePosition[1], rowMatrix)) {
                    curMousePosition[0]++;
                } else {
                    mouseIsOut[0] = 1;
                }
                break;
            case "left":
                if (mouseInTheMatrix(curMousePosition[0], curMousePosition[1] - 1, rowMatrix)) {
                    curMousePosition[1]--;
                } else {
                    mouseIsOut[0] = 1;
                }
                break;
            case "right":
                if (mouseInTheMatrix(curMousePosition[0], curMousePosition[1] + 1, rowMatrix)) {
                    curMousePosition[1]++;
                } else {
                    mouseIsOut[0] = 1;
                }
                break;
        }
    }
}
