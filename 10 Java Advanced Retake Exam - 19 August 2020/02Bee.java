package Exams_matrix;

import java.util.Arrays;
import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int rowMatrix = Integer.parseInt(console.nextLine());
        char[][] matrix = new char[rowMatrix][rowMatrix];
        int[] beePosition = new int[2];
        fillTheMatrix(matrix, beePosition, console);

        int[] outOfTerritory = new int[1];
        int pollinatedFlowers=0;
        String command;
        while (!"End".equals(command = console.nextLine())) {
            matrix[beePosition[0]][beePosition[1]] = '.';
            move(command, beePosition, rowMatrix, outOfTerritory);
            if (outOfTerritory[0] == 1) {
                break;
            }
            if (matrix[beePosition[0]][beePosition[1]] == 'O') {
                matrix[beePosition[0]][beePosition[1]] = '.';
                move(command, beePosition, rowMatrix, outOfTerritory);
            }
            if (matrix[beePosition[0]][beePosition[1]] == 'f') {
                pollinatedFlowers++;
            }
            matrix[beePosition[0]][beePosition[1]] = 'B';
        }
        if (outOfTerritory[0] == 1) {
            System.out.println("The bee got lost!");
        }
        if (pollinatedFlowers>=5) {
            System.out.println("Great job, the bee manage to pollinate " + pollinatedFlowers + " flowers!");
        } else{
            System.out.println("The bee couldn't pollinate the flowers, she needed " + (5-pollinatedFlowers) + " flowers more");
        }
        Arrays.stream(matrix).map(String::valueOf).forEach(System.out::println);
    }

    public static void fillTheMatrix(char[][] matrix, int[] beePosition, Scanner console) {
        for (int i = 0; i < matrix.length; i++) {
            String input = console.nextLine();
            for (int j = 0; j < input.length(); j++) {
                matrix[i][j] = input.charAt(j);
                if (input.charAt(j) == 'B') {
                    beePosition[0] = i;
                    beePosition[1] = j;
                }
            }
        }
    }

    public static boolean BeeInTheMatrix(int row, int col, int rowMatrix) {
        return row >= 0 && row < rowMatrix && col >= 0 && col < rowMatrix;
    }

    public static void move(String command, int[] beePosition, int rowMatrix, int[] outOfTerritory) {
        switch (command) {
            case "up":
                if (BeeInTheMatrix(beePosition[0] - 1, beePosition[1], rowMatrix)) {
                    beePosition[0]--;
                } else {
                    outOfTerritory[0] = 1;
                }
                break;
            case "down":
                if (BeeInTheMatrix(beePosition[0] + 1, beePosition[1], rowMatrix)) {
                    beePosition[0]++;
                } else {
                    outOfTerritory[0] = 1;
                }
                break;
            case "left":
                if (BeeInTheMatrix(beePosition[0], beePosition[1] - 1, rowMatrix)) {
                    beePosition[1]--;
                } else {
                    outOfTerritory[0] = 1;
                }
                break;
            case "right":
                if (BeeInTheMatrix(beePosition[0], beePosition[1] + 1, rowMatrix)) {
                    beePosition[1]++;
                } else {
                    outOfTerritory[0] = 1;
                }
                break;
        }
    }
}
